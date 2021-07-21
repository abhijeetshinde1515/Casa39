package tests.home;

import org.testng.annotations.Test;
import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.catalogue.ProductDescriptionPage;
import pages.home.CustomerSignInPage;
import pages.home.HomePage;
import pages.home.InformationLinksPage;
import pages.home.SearchResultsPage;
import utils.GeneratorUtils;
import utils.ProductUtils;

public class TestHomePage extends TestNGBaseTest {

	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies that a authorised client User can log in and see profile.", 
			CreateDate = "20/07/2021")
	@Test()
	public void testSignInAuthenticatedUser() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);

		logStep("Go to Customer Log In Page and Validate Authenicated User Log In.");
		CustomerSignInPage customerSignInPage = homePage.clickSignIn();

		logStep("Click Sign In without setting username and Password");
		customerSignInPage.clickSignIn();
		assertTrue(customerSignInPage.getEmailErrorMessage().contains("This is a required field."), "Email is required");
		assertTrue(customerSignInPage.getPasswordErrorMessage().contains("This is a required field."), "Password is required");
		homePage = customerSignInPage.closeSignInPage();
		
		logStep("Log In with Invalid username and Password");
		customerSignInPage = homePage.clickSignIn();
		customerSignInPage.setEmail("Invalid User Email");
		customerSignInPage.setPassword("123");
		homePage = customerSignInPage.clickSignIn();
		assertTrue(customerSignInPage.getEmailErrorMessage().contains("Please enter a valid email address (Ex: johndoe@domain.com)."), 
				"Please enter a valid email address (Ex: johndoe@domain.com).");
		assertTrue(customerSignInPage.getPasswordErrorMessage().contains("Please enter 6 or more characters. Leading and trailing spaces will be ignored."), 
				"Please enter 6 or more characters. Leading and trailing spaces will be ignored.");
		customerSignInPage.closeSignInPage();
		
		logStep("Log In with Valid username and Password");
		customerSignInPage = homePage.clickSignIn();
		customerSignInPage.setEmail(TestData.email);
		customerSignInPage.setPassword(TestData.password);
		homePage = customerSignInPage.clickSignIn();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies email subscription option from home page.", 
			CreateDate = "19/07/2021")
	@Test()
	public void testEmailSubscription() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);

		logStep("Subscrition email without entering email.");
		homePage = homePage.clickEmailSubScribe();
		assertTrue(homePage.validateEmailSubscriptionError(), "Email Required error Message is Displayed");

		logStep("Subscrition email by entering existing email.");
		homePage = homePage.subscribeToEmailAs(TestData.email);
		assertTrue(homePage.isErrorMessageDisplayed("This email address is already subscribed."), "This email address is already subscribed");
		
		logStep("Subscrition email by entering new email.");
		homePage = homePage.subscribeToEmailAs(GeneratorUtils.generateUniqueEmail());
		assertTrue(homePage.isSuccessMessageDisplayed("Thank you for your subscription."), "Success Message is Displayed");
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies all information Links given at bottom of home page.", 
			CreateDate = "20/07/2021")
	@Test()
	public void testHomePageInformationLinks() throws Exception {
		
		HomePage homePage = navigateToCasa39Website(false);
		
		String ourStoryContent = "This site is a complete showcase that allows you to choose "
				+ "and buy everything you need to furnish your home and bathroom with taste and style. "
				+ "Our story begins many years ago in Taviano, a town in the southern part of Apulia (Salento),"
				+ " with a showroom of about 500 sqm. From the beginning we've choosen to cooperate with the best "
				+ "manifacturers, offering high quality services and all our professionalism. Over the years our reality"
				+ " has grown more and more and we’ve increasingly looked for new ways to get close to our customers. "
				+ "Today Casa39 creates on Internet the best home and bathroom solutions worldwide";
		
		logStep("Go to Our story");
		InformationLinksPage infoLinks = homePage.clickInfoLinksAs("our story");
		assertTrue(infoLinks.isInformationPageDisplayed("HOW TO FIND US"), "Our story Page is Displayed.");
		assertTrue(infoLinks.isDisplayedPageInformation(ourStoryContent), "Our story Content is Displayed");
		infoLinks.clickCASA39Logo();
		
		String legalInformationContent = "Casa39 SRL";
		
		logStep("Go to Legal Information");
		infoLinks = homePage.clickInfoLinksAs("legal information");
		assertTrue(infoLinks.isInformationPageDisplayed("LEGAL INFORMATION"), "LEGAL INFORMATION Page is Displayed.");
		assertTrue(infoLinks.isDisplayedPageInformation(legalInformationContent), "LEGAL INFORMATION Content is Displayed");
		infoLinks.clickCASA39Logo();
		
		logStep("Go to Promotions");
		infoLinks = homePage.clickInfoLinksAs("promotions");
		assertTrue(infoLinks.isInformationPageDisplayed("Sale"), "Sale Page is Displayed.");
		infoLinks.clickCASA39Logo();
		
		String termsAndConditions = "The general terms and conditions of sale detailed below only govern the contractual relationship"
				+ " between the User (hereafter referred to as You) and Casa39 srl (henceforward referred to as We), whose headquarters "
				+ "is situated at Via Regina Margherita 1, 73057 Taviano (Italy). Both parties accept these conditions unreservedly. "
				+ "These general conditions of sale are the only conditions that are applicable and replace all other conditions, except "
				+ "in the case of express, written prior dispensation. We preserve that, by confirming your order, you unreservedly accept "
				+ "our general conditions of sale, having read them.";
		
		logStep("Go to Terms and Conditions");
		infoLinks = homePage.clickInfoLinksAs("terms and conditions");
		assertTrue(infoLinks.isInformationPageDisplayed("TERMS AND CONDITIONS"), "TERMS AND CONDITIONS Page is Displayed.");
		assertTrue(infoLinks.isDisplayedPageInformation(termsAndConditions), "TERMS AND CONDITIONS Content is Displayed");
		infoLinks.clickCASA39Logo();
		
		logStep("Go to Brands");
		infoLinks = homePage.clickInfoLinksAs("brands");
		assertTrue(infoLinks.isInformationPageDisplayed("OUR BRANDS"), "OUR BRANDS Page is Displayed.");
		infoLinks.clickCASA39Logo();
		
		logStep("Go to SHIPPING");
		infoLinks = homePage.clickInfoLinksAs("shipping");
		assertTrue(infoLinks.isInformationPageTitleDisplayed("SHIPPING"), "SHIPPING Page is Displayed.");
		infoLinks.clickCASA39Logo();
		
		logStep("Go to BUYER PROTECTION");
		infoLinks = homePage.clickInfoLinksAs("buyer protection");
		assertTrue(infoLinks.isInformationPageTitleDisplayed("BUYER PROTECTION"), "BUYER PROTECTION Page is Displayed.");
		infoLinks.clickCASA39Logo();
		
		logStep("Go to 3D projects");
		infoLinks = homePage.clickInfoLinksAs("3D projects");
		assertTrue(infoLinks.isInformationPageTitleDisplayed("FREE 3D PROJECTS"), "FREE 3D PROJECTS Page is Displayed.");
		infoLinks.clickCASA39Logo();
		
		logStep("Go to Quotes");
		infoLinks = homePage.clickInfoLinksAs("quotes");
		assertTrue(infoLinks.isInformationPageTitleDisplayed("QUOTES"), "QUOTES Page is Displayed.");
		infoLinks.clickCASA39Logo();
		
		logStep("Go to VISIT US");
		infoLinks = homePage.clickInfoLinksAs("all our services");
		assertTrue(infoLinks.isInformationPageDisplayed("ALL OUR SERVICES"), "ALL OUR SERVICES Page is Displayed.");
		infoLinks.clickCASA39Logo();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies product search functionality from home page.", 
			CreateDate = "20/07/2021")
	@Test()
	public void testSearchProductsFromHomePage() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);

		String productName = "ABC";
		String noticeMessage = "Your search returned no products.";
		String noResultsMessage = "Are you looking for a product not present on our portal? "
				+ "Contact us and we will find it at the best price for you.";

		logStep("Search for a Not Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(productName);
		assertTrue(searchResultsPage.isNoSearchResultsDisplayed(noticeMessage), noticeMessage);

		searchResultsPage = homePage.clickEnterForSearch();
		assertTrue(searchResultsPage.isDisplayedSearchResultsFor(productName), "Search Results is Displayed");
		assertTrue(searchResultsPage.isNoticeMessageDisplayed(noResultsMessage),
				"No Search Results Message is Displayed");

		searchResultsPage.clickHome();

		productName = "Lineabeta Basket waste bin 5346.29";
		String searchText = "Lineabeta Basket waste";

		logStep("Search for a Available Product as " + productName);
		searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage productDescriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText,
				productName);
		assertTrue(productDescriptionPage.isPageTitleDisplayed(productName), "Searched Product is Correctly Displayed");

		searchResultsPage.clickCASA39Logo();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies that user can choose and select language, country and currency.", 
			CreateDate = "21/07/2021")
	@Test()
	public void testUserSelectLanguageCountryAndCurrency() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);

		String italian = "Italiano";
		String english = "English";

		logStep("Choose other language");
		homePage.selectLanguageAs(italian);
		assertEquals(homePage.getSelectedLanguage(), italian, italian + " Language Selected Successfully");
		homePage.acceptCookies();

		logStep("Reset Language");
		homePage.selectLanguageAs(english);
		assertEquals(homePage.getSelectedLanguage(), english, english + " Language Selected Successfully");

		String algeria = "Algeria";

		logStep("Choose other Country");
		homePage.selectCountryAs(algeria);
		assertEquals(homePage.getSelectedCountry(), algeria, algeria + " Country Selected Successfully");

		String dollar = "Us Dollar";
		String euro = "Euro";

		logStep("Choose other Currency");
		homePage.selectCurrencyAs(dollar);
		assertEquals(homePage.getSelectedCurrency(), dollar, dollar + " Currency Selected Successfully");

		logStep("Reset Currency");
		homePage.selectCurrencyAs(euro);
		assertEquals(homePage.getSelectedCurrency(), euro, euro + " Currency Selected Successfully");
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies that user can choose and select product category from homepage.", 
			CreateDate = "21/07/2021")
	@Test()
	public void testSelectProductCategory() throws Exception {
		HomePage homePage = navigateToCasa39Website(false);
		ProductUtils.selectAndValidateMainProductCategories(homePage, "FLOOR TILES", "Tiles");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "WALL TILES", "Wall Tiles");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "TAPS", "Taps");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "ACCESSORIES", "accessories");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "SANITARY WARES", "Toilet");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "FURNITURE", "furniture");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "BATHTUBS", "Bathtubs");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "SHOWER ENCLOSURES", "Shower Enclosures");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "BRANDS", "OUR BRANDS");
		ProductUtils.selectAndValidateMainProductCategories(homePage, "OFFERS", "Sale");
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies that user can choose and select product sub-category from homepage.", 
			CreateDate = "21/07/2021")
	@Test()
	public void testSelectProductSubCategory() throws Exception {
		HomePage homePage = navigateToCasa39Website(false);
		ProductUtils.selectAndValidateProductSubCategories(homePage, "FLOOR TILES", "Cleansers", "Cleansers");
		ProductUtils.selectAndValidateProductSubCategories(homePage, "WALL TILES", "Marble effect", "Bathroom Tiles Marble effect");
		ProductUtils.selectAndValidateProductSubCategories(homePage, "TAPS", "Waterfall taps", "Waterfall taps");
		ProductUtils.selectAndValidateProductSubCategories(homePage, "ACCESSORIES", "Hooks", "Hooks");
		ProductUtils.selectAndValidateProductSubCategories(homePage, "SANITARY WARES", "Ceramic", "Shower Trays Ceramic");
		ProductUtils.selectAndValidateProductSubCategories(homePage, "FURNITURE", "Mirrors", "Mirrors");
		ProductUtils.selectAndValidateProductSubCategories(homePage, "BATHTUBS", "Recessed", "Bathtubs Recessed");
		ProductUtils.selectAndValidateProductSubCategories(homePage, "SHOWER ENCLOSURES", "Single door opening", "Single door opening");
		ProductUtils.selectAndValidateProductSubCategories(homePage, "BRANDS", "RELAX", "Relax");
		closeBrowser();
	}
}