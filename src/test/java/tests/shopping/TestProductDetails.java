package tests.shopping;

import org.testng.annotations.Test;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.catalogue.CartQuotesPage;
import pages.catalogue.InformationModal;
import pages.catalogue.ProductDescriptionPage;
import pages.home.HomePage;
import pages.home.SearchResultsPage;
import utils.GeneratorUtils;

public class TestProductDetails extends TestNGBaseTest {
		
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies user can add product to card by selecting quantity.", 
			CreateDate = "23/07/2021")
	@Test()
	public void testAddProductToCart() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);
		
		String productName = "Lineabeta Basket waste bin 5346.29";
		String searchText = "Lineabeta Basket waste";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText,
				productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName), productName +" as Searched Product is Correctly Displayed");

		logStep("Select Quantity and add to cart");
		descriptionPage.selectQuantityAs("3");
		InformationModal informationModal = descriptionPage.clickAddToCart();
		assertTrue(informationModal.isSuccessMessageDisplayed(productName), productName);
		assertTrue(informationModal.isSuccessMessageDisplayed("has been added to your cart"), "has been added to your cart");
		informationModal.clickCross();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies user can ask for discount by submitting form.", 
			CreateDate = "23/07/2021")
	@Test()
	public void testAskForDiscount() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);
		
		String productName = "Lineabeta Atlantica shower platform 50x50 cm 7224.08";
		String searchText = "Lineabeta Atlantica shower";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText,
				productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName), productName +" as Searched Product is Correctly Displayed");

		logStep("Ask For Discount");
		descriptionPage.clickAskForDiscount();
		assertTrue(descriptionPage.validateSectionTitle(), "You're one step away from the additional discount!");
		
		logStep("Fill and Submit form for discount");
		descriptionPage.setCompanyName("ELSNER TESTING");
		descriptionPage.setEmail();
		descriptionPage.setFormQuantity("10");
		descriptionPage.setZip("123456");
		descriptionPage.setCountry("India");
		descriptionPage.setMessage(GeneratorUtils.generateUniqueId("Testing Form"));
		descriptionPage.submitForm();
		assertTrue(descriptionPage.getSuccessMessage().contains("Thank you very much for your request. We will respond to it as soon as possible."),
				"Thank you very much for your request. We will respond to it as soon as possible.");
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies user can add review on Products.", 
			CreateDate = "26/07/2021")
	@Test()
	public void testAddProductReviewByUser() throws Exception {
		
		HomePage homePage = navigateToCasa39Website(false);
		
		String productName = "House Design mirror Traccia";
		String searchText = "House Design mirror Traccia";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText,
				productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName), productName +" as Searched Product is Correctly Displayed");
		
		logStep("Write Your Own Review");
		descriptionPage.clickWriteYourOwnReview();
		
		logStep("Submit a Review");
		assertTrue(descriptionPage.validateReviewingProductNameAs(productName), "You are Reviewing "+productName);
		
		descriptionPage.setRating(4);
		descriptionPage.setNickName(GeneratorUtils.generateUniqueId("Test_Nickname"));
		descriptionPage.setSummary(GeneratorUtils.generateUniqueId("Test_Summary"));
		descriptionPage.setReview(GeneratorUtils.generateUniqueId("Test_Review"));
		descriptionPage.clickSubmitReview();
		assertTrue(descriptionPage.isSuccessMessageDisplayed("You submitted your review for moderation."), "Review Submitted for Review Successfully");
		
		descriptionPage.clickCASA39Logo();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies user can add product quotes successfully.", 
			CreateDate = "26/07/2021")
	@Test()
	public void testProductAddToQuote() throws Exception {
		
		HomePage homePage = navigateToCasa39Website(false);
		
		String productName = "Lineabeta Duemila hook 5507.29";
		String searchText = "Lineabeta Duemila hook";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText,
				productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName), productName +" as Searched Product is Correctly Displayed");
		
		logStep("Add to Quote");
		InformationModal informationModal = descriptionPage.clickAddToQuote();
		assertTrue(informationModal.isSuccessMessageDisplayed(productName), productName);
		assertTrue(informationModal.isSuccessMessageDisplayed("has been added to your quote cart"), "has been added to your cart");
		
		logStep("Navigate to Cart Quotes Page");
		CartQuotesPage cartQuotesPage = informationModal.clickQuoteCart();
		assertTrue(cartQuotesPage.isPageTitleDisplayed("Cart Quotes"), "Cart Quotes Page is Displayed");
		
		logStep("Update Quote");
		cartQuotesPage.updateQuantity("10");
		cartQuotesPage.updateQuote();
		
		logStep("Enter User Details to Request Quote");
		cartQuotesPage.setEmail(GeneratorUtils.generateUniqueEmail());
		cartQuotesPage.setFirstName(GeneratorUtils.generateUniqueId("FirstName"));
		cartQuotesPage.setLastName(GeneratorUtils.generateUniqueId("LastName"));
		cartQuotesPage.setZipCode("123456");
		cartQuotesPage.setRemarks("Remarks");
		cartQuotesPage.clickRequestQuote();
		assertTrue(homePage.isPageTitleDisplayed("Your quote request has been received!"), "Your quote request has been received!");
		
		cartQuotesPage.clickCASA39Logo();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies user can add configurable products to quote by selecting quantity.", 
			CreateDate = "02/08/2021")
	@Test()
	public void testAddConfigurableProductsToQuotes() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);
		
		String productName = "Ragno Woodtale Miele 30x120 cm R4TH";
		String searchText = "R4TH";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText, productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName), productName +" as Searched Product is Correctly Displayed");
		
		logStep("Select Quantity for all product groups");
		assertTrue(descriptionPage.getQuantityInSquares("1,08"), "Quantity per Squares is Correct");
		assertTrue(descriptionPage.getQuantityInBoxes("1"), "Quantity per Boxes is Correct");
		
		descriptionPage.selectIncreaseQuantityPerMeters();
		descriptionPage.selectReduceQuantityPerBoxes();
		descriptionPage.selectIncreaseQuantityPerBoxes();
		descriptionPage.selectReduceQuantityPerMeters();
		
		assertTrue(descriptionPage.getQuantityInSquares("1,08"), "Quantity per Squares is Correct");
		assertTrue(descriptionPage.getQuantityInBoxes("1"), "Quantity per Boxes is Correct");
		
		descriptionPage.selectIncreaseQuantityPerBoxes();
		assertTrue(descriptionPage.getQuantityInBoxes("2"), "Quantity per Boxes is Correct");
		
		logStep("Add to Quote");
		InformationModal informationModal = descriptionPage.clickAddToQuote();
		assertTrue(informationModal.isSuccessMessageDisplayed(productName), productName);
		assertTrue(informationModal.isSuccessMessageDisplayed("has been added to your quote cart"), "has been added to your cart");
	
		logStep("Navigate to Cart Quotes Page");
		CartQuotesPage cartQuotesPage = informationModal.clickQuoteCart();
		assertTrue(cartQuotesPage.isPageTitleDisplayed("Cart Quotes"), "Cart Quotes Page is Displayed");
		
		logStep("Validate Product Details");
		assertTrue(cartQuotesPage.validateCartQuotesQuantityDetails("3"), "Quantity is Correct");
		assertTrue(cartQuotesPage.validateCartQuotesPriceDetails("€73.53"), "SubTotal is Correct");
		assertTrue(cartQuotesPage.validateCartQuotePriceDetails("29.90"), "Product Price is Correct");
		
		cartQuotesPage.clickCASA39Logo();
		closeBrowser();
	}
}