package tests.shopping;

import org.testng.annotations.Test;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.catalogue.CheckOutPage;
import pages.catalogue.InformationModal;
import pages.catalogue.ProductDescriptionPage;
import pages.catalogue.ShoppingCartPage;
import pages.home.HomePage;
import pages.home.MinicartModal;
import pages.home.SearchResultsPage;

public class TestShoppingCart extends TestNGBaseTest {

	@TestDocumentation(
			TestNumber = "", 
			Coverage = "Verifies user can select product, add to cart and proceed to checkout page.",
			CreateDate = "26/07/2021")
	@Test()
	public void testSecureCheckOutForProducts() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);

		String productName = "Marazzi Evolutionmarble Calacatta 60x60 cm MHV2";
		String searchText = "Marazzi Evolutionmarble Calacatta 60x60 cm MHV2";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText,
				productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName),
				productName + " as Searched Product is Correctly Displayed");

		logStep("Select Quantity and add to cart");
		descriptionPage.selectFlooringQtyAs("30");
		InformationModal informationModal = descriptionPage.clickAddToCart();
		assertTrue(informationModal.isSuccessMessageDisplayed(productName), productName);
		assertTrue(informationModal.isSuccessMessageDisplayed("has been added to your cart"),
				"has been added to your cart");
		informationModal.clickCross();
		
		logStep("Validate Non-Empty Cart and Close");
		MinicartModal minicartModal = homePage.clickMyCart();
		assertTrue(minicartModal.getAmountPrice().contains("€687.85"), "Item Prices are Correct");
		assertTrue(minicartModal.getTotalItems().contains("32.4"), "Total Items are Correct");
		
		logStep("View Shopping Cart");
		ShoppingCartPage shoppingCartPage = minicartModal.clickViewAndEditCart();
		assertTrue(shoppingCartPage.isPageTitleDisplayed("Shopping cart"), "Page Title is Displayed");
		assertTrue(shoppingCartPage.validatePriceSummary("€687.85"), "Sub Total is Correct");
		assertTrue(shoppingCartPage.validatePriceSummary("€50.00"), "Shipping Price is Correct");
		assertTrue(shoppingCartPage.validatePriceSummary("€160.33"), "Tax Amount is Correct");
		assertTrue(shoppingCartPage.validatePriceSummary("€889.16"), "Order Total is Correct");
		
		logStep("Proceed To Checkout");
		CheckOutPage checkOutPage = shoppingCartPage.clickProceedToCheckOut();
		assertTrue(checkOutPage.getProductName(productName), productName+" is Displayed");
		closeBrowser();
	}
}