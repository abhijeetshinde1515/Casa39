package tests.shopping;

import org.testng.annotations.Test;

import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.catalogue.CartQuotesPage;
import pages.catalogue.CheckOutPage;
import pages.catalogue.InformationModal;
import pages.catalogue.ProductDescriptionPage;
import pages.catalogue.ShoppingCartPage;
import pages.home.CustomerSignInPage;
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
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies that logged in user can access quotes mini cart section from home page.", 
			CreateDate = "27/07/2021")
	@Test()
	public void testMinicartQuotesModalFromHomePage() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);
		
		logStep("Log In with Valid username and Password");
		CustomerSignInPage customerSignInPage = homePage.clickSignIn();
		customerSignInPage.setEmail(TestData.testEmail);
		customerSignInPage.setPassword(TestData.testPassword);
		homePage = customerSignInPage.clickSignIn();
		
		logStep("Validate Minicart Modal");
		MinicartModal minicartModal = homePage.clickMyQuote();
		assertTrue(minicartModal.getTotalItems().contains("3"), "Total Items are Correct");
		assertTrue(minicartModal.getAmountPrice().contains("€338.53"), "Cart subtotal price is Correct");
		
		CartQuotesPage cartQuotesPage = minicartModal.clickAskForQuotes();
		assertTrue(cartQuotesPage.isPageTitleDisplayed("Cart Quotes"), "Cart Quotes Page is Displayed");
		
		assertTrue(minicartModal.getItemPrice("€24.59"), "Items Price is Correct");
		assertTrue(minicartModal.getItemPrice("€210.66"), "Items Price is Correct");
		assertTrue(minicartModal.getItemPrice("€103.28"), "Items Price is Correct");
		
		cartQuotesPage.clickCASA39Logo();
		homePage.clickSignOut();
		closeBrowser();
	}
}