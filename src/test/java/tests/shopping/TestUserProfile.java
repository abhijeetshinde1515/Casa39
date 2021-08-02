package tests.shopping;

import org.testng.annotations.Test;
import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.home.CustomerSignInPage;
import pages.home.HomePage;
import pages.home.MyAccountPage;
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
}
