package tests.shopping;

import org.testng.annotations.Test;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.catalogue.CartQuotesPage;
import pages.catalogue.InformationModal;
import pages.catalogue.ProductDescriptionPage;
import pages.catalogue.ShoppingCartPage;
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
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies prduct details on product desciption page.", 
			CreateDate = "03/08/2021")
	@Test()
	public void testProductSpecifications() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);

		String productName = "Novellini panelled bathtub Vogue";
		String searchText = "Novellini panelled bathtub Vogue";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText,
				productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName),
				productName + " as Searched Product is Correctly Displayed");

		logStep("Validate Product Specifications");
		assertTrue(descriptionPage.getSpecificationDetails("Novellini"), "Brand Name is Correct");
		assertTrue(descriptionPage.getSpecificationDetails("Does not apply"), "EAN is Correct");
		assertTrue(descriptionPage.getSpecificationDetails("Acrylic"), "Material is Correct");

		String brandInformation = "With enthusiasm, team work and values, we wish to improve the lives of everyone in the world in search of excellence for their homes and families, and aim to do so by using the best in technology, further enhanced by passion and intellectual involvement, born from a quest for beauty in all that we do. To be the reference point for excellence in bathroom furnishings and the most innovative company, proposing better products and better services. To thus grow and become a leader throughout the world, creating value for the resources involved in our activity and for our country. Our core values are a passion for excellence - meaning a love of beauty and fine workmanship - and ethics - meaning long-term worth through sustainability, transparency and valuing people. We want to put mankind and quality of life at the centre of all our choices, ever driven by a passion for what we do.";

		assertTrue(descriptionPage.getManufacturerDetails(brandInformation), "Brand Information is Correct");

		logStep("Select Parameters");
		descriptionPage.setDimension("150x85 cm");
		descriptionPage.setVersion("Senza idromassaggio");
		descriptionPage.selectQuantityAs("5");

		logStep("Add to Cart");
		InformationModal informationModal = descriptionPage.clickAddToCart();
		assertTrue(informationModal.isSuccessMessageDisplayed(productName), productName);
		assertTrue(informationModal.isSuccessMessageDisplayed("has been added to your cart"),
				"has been added to your cart");

		logStep("View Shopping Cart");
		ShoppingCartPage shoppingCartPage = informationModal.clickViewCart();

		logStep("Validate Group Product Price Details");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€778.69"), "Price is Correct");

		logStep("Validate Group Product Sub Total Details");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€3,893.45"), "Subtotal Price is Correct");

		logStep("Validate Group Product Quantity Details");
		assertTrue(shoppingCartPage.validateCartQuantityDetails("5"), "Quantity is Correct");

		shoppingCartPage.clickCASA39Logo();
		closeBrowser();
	}
}