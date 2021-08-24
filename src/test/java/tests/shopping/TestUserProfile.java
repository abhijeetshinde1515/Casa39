package tests.shopping;

import org.testng.annotations.Test;
import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.home.CustomerSignInPage;
import pages.home.HomePage;
import pages.home.MyAccountPage;
import pages.home.MyOrdersPage;
import utils.ProductUtils;

public class TestUserProfile  extends TestNGBaseTest{

	@Test()
	public void testAutomationSetUpForCasa39English() throws Exception {
		
		logStep("Check connection to Casa39 English Website...");
		navigateToCasa39Website(false);
		assertEquals(driver.getTitle(), TestData.casa39English_HomepageTitle, "Connection Established Successfully...");
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies that logged in user can access all account related information  through My Account Section.", 
			CreateDate = "22/07/2021")
	@Test()
	public void testLoggedInUserMyAccountSection() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);
		
		logStep("Log In with Valid username and Password");
		CustomerSignInPage customerSignInPage = homePage.clickSignIn();
		customerSignInPage.setEmail(TestData.email);
		customerSignInPage.setPassword(TestData.password);
		homePage = customerSignInPage.clickSignIn();
		
		logStep("Go to My Account Section");
		MyAccountPage myAccountPage = homePage.clickMyAccount();
		assertTrue(myAccountPage.isMyAccountPageDisplayed(), "My Account Page is Displayed");
		
		String newsLetterInformation = "You are subscribed to \"General Subscription\".";
		
		logStep("Validate Account Information");
		assertTrue(myAccountPage.isAccountInformationDisplayed(TestData.user_fullname), "User Name as '"+TestData.user_fullname+"' is Correct");
		assertTrue(myAccountPage.isAccountInformationDisplayed(TestData.email), "User Email Id as '"+TestData.email+"' is Correct");
		assertTrue(myAccountPage.isAccountInformationDisplayed(newsLetterInformation), newsLetterInformation);
		
		logStep("Validate Address Book");
		assertTrue(myAccountPage.isBillingAddressDisplayed("check, 73057"), "Billing Address is Correct");
		assertTrue(myAccountPage.isShippingAddressDisplayed("Italy"), "Shipping Address is Correct");
		
		String myOrderSection = "My orders";
		
		logStep("Go to "+myOrderSection);
		myAccountPage.clickLink(myOrderSection);
		assertTrue(myAccountPage.isPageTitleDisplayed(myOrderSection), myOrderSection+" Section is Displayed");
	
		logStep("Validate Order Details");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "000026948", "9/28/20", "€279.00", "Canceled");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "000027299", "1/19/21", "€169.00", "Canceled");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "000026914", "9/21/20", "€518.00", "Canceled");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "000027677", "5/24/21", "€727.16", "Canceled");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "3000036324", "5/19/21", "€526.91", "Canceled");
		
		String addresses = "Addresses";
		
		logStep("Go to "+addresses);
		myAccountPage.clickLink(addresses);
		assertTrue(myAccountPage.isPageTitleDisplayed(addresses), addresses+" Section is Displayed");
		
		logStep("Validate Additional Address Book");
		ProductUtils.validateAdditionalAddressDetailsAs(myAccountPage, "Ajay", "Sikarwar", "7242 Atlantic Street", "check", "Italy", "", "73057", "9033855585");
		ProductUtils.validateAdditionalAddressDetailsAs(myAccountPage, "Ajay", "Sikarwar", "farrari", "check", "Italy", "", "73057", "9033855585");
		
		String accountInformation = "Account information";
		
		logStep("Go to "+accountInformation);
		myAccountPage.clickLink(accountInformation);
		assertTrue(myAccountPage.isPageTitleDisplayed("Edit account information"), accountInformation+" Section is Displayed");
		
		String newsLetterSection = "Newsletter";
		
		logStep("Go to "+newsLetterSection);
		myAccountPage.clickLink(newsLetterSection);
		assertTrue(myAccountPage.isPageTitleDisplayed("Newsletter subscription"), newsLetterSection+" Section is Displayed");
		
		String myQuotes = "My quotes";
		
		logStep("Go to "+myQuotes);
		myAccountPage.clickLink(myQuotes);
		assertTrue(myAccountPage.isPageTitleDisplayed(myQuotes), myQuotes+" Section is Displayed");
		
		logStep("Validate My Quotes Details");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "1000459434", "5/19/21", "€727.16", "Complete");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "2000455214", "5/4/21", "€32.29", "Pending");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "1000455205", "5/4/21", "€104.28", "Pending");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "9000446208", "4/6/21", "€0.00", "Pending");
		ProductUtils.validateMyOderDetailsAs(myAccountPage, "2000424146", "1/27/21", "€613.55", "Pending");
		
		homePage = myAccountPage.clickCASA39Logo();
		homePage.clickSignOut();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies that logged in user can access order details from My Account Section.", 
			CreateDate = "24/08/2021")
	@Test()
	public void testMyAccountSection() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);

		logStep("Log In with Valid username and Password");
		CustomerSignInPage customerSignInPage = homePage.clickSignIn();
		customerSignInPage.setEmail(TestData.email);
		customerSignInPage.setPassword(TestData.password);
		homePage = customerSignInPage.clickSignIn();

		logStep("Go to My Account Section");
		MyAccountPage myAccountPage = homePage.clickMyAccount();
		assertTrue(myAccountPage.isMyAccountPageDisplayed(), "My Account Page is Displayed");

		String newsLetterInformation = "You are subscribed to \"General Subscription\".";

		logStep("Validate Account Information");
		assertTrue(myAccountPage.isAccountInformationDisplayed(TestData.user_fullname),
				"User Name as '" + TestData.user_fullname + "' is Correct");
		assertTrue(myAccountPage.isAccountInformationDisplayed(TestData.email),
				"User Email Id as '" + TestData.email + "' is Correct");
		assertTrue(myAccountPage.isAccountInformationDisplayed(newsLetterInformation), newsLetterInformation);

		logStep("Go to My Account Section");
		myAccountPage = homePage.clickMyAccount();
		assertTrue(myAccountPage.isMyAccountPageDisplayed(), "My Account Page is Displayed");

		MyOrdersPage myOrdersPage = myAccountPage.clickViewOrder();
		assertTrue(myOrdersPage.isPageTitleDisplayed("Order # 3000036324"), "Order Id as #3000036324 is Displayed");

		String product1 = "Emilceramica Be-Square Sand 80x80 cm 80KC3R ECXH";
		String product2 = "Ragno Woodtale Miele 30x120 cm R4TH";

		logStep("Validate Order Details");
		assertTrue(myOrdersPage.isProductNameDisplayed(product1), product1 + " is Displayed");
		assertTrue(myOrdersPage.isProductNameDisplayed(product2), product2 + " is Displayed");

		assertTrue(myOrdersPage.isOrderDetailsDisplayed("12"), product1 + " Box Quantity is Displayed");
		assertTrue(myOrdersPage.isOrderDetailsDisplayed("2"), product2 + " Box Quantity is Displayed");

		assertTrue(myOrdersPage.isOrderDetailsDisplayed("€34.56"), product1 + " Box Price is Displayed");
		assertTrue(myOrdersPage.isOrderDetailsDisplayed("€32.29"), product2 + " Box Price is Displayed");

		assertTrue(myOrdersPage.isOrderDetailsSKUDisplayed("EMI1555"), product1 + " SKU is Displayed");
		assertTrue(myOrdersPage.isOrderDetailsSKUDisplayed("RGN2184"), product2 + " SKU is Displayed");

		assertTrue(myOrdersPage.isOrderPriceDetailsDisplayed("€22.13"), product1 + " Price is Displayed");
		assertTrue(myOrdersPage.isOrderPriceDetailsDisplayed("€24.51"), product2 + " Price is Displayed");

		assertTrue(myOrdersPage.isOrderPriceDetailsDisplayed("€339.92"), product1 + " Subtotal Price is Displayed");
		assertTrue(myOrdersPage.isOrderPriceDetailsDisplayed("€50.98"), product2 + " Subtotal Price is Displayed");

		assertTrue(myOrdersPage.isOrderQuantityDetailsDisplayed("15.36"), product1 + " Canceled Quantity is Displayed");
		assertTrue(myOrdersPage.isOrderQuantityDetailsDisplayed("2.08"), product2 + " Canceled Quantity is Displayed");

		assertTrue(myOrdersPage.isOrderPriceSummaryDetailsDisplayed("€476.91"), "€476.91 Subtotal is Displayed");
		assertTrue(myOrdersPage.isOrderPriceSummaryDetailsDisplayed("€50.00"),
				"€50.00 Shipping & Handling Charges is Displayed");
		assertTrue(myOrdersPage.isOrderPriceSummaryDetailsDisplayed("€431.88"),
				"€431.88 Grand Total Excludinng Tax is Displayed");
		assertTrue(myOrdersPage.isOrderPriceSummaryDetailsDisplayed("€95.03"), "€95.03 Tax is Displayed");
		assertTrue(myOrdersPage.isOrderPriceSummaryDetailsDisplayed("€526.91"),
				"€526.91 Grand Final Total is Displayed");

		homePage = myAccountPage.clickCASA39Logo();
		homePage.clickSignOut();
		closeBrowser();
	}
}