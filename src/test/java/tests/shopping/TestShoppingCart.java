package tests.shopping;

import org.testng.annotations.Test;
import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.catalogue.CartQuotesPage;
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
		assertTrue(minicartModal.getTotalItems().contains("4"), "Total Items are Correct");
		assertTrue(minicartModal.getAmountPrice().contains("€565.54"), "Cart subtotal price is Correct");
		
		CartQuotesPage cartQuotesPage = minicartModal.clickAskForQuotes();
		assertTrue(cartQuotesPage.isPageTitleDisplayed("Cart Quotes"), "Cart Quotes Page is Displayed");
		
		assertTrue(minicartModal.getItemPrice("€25.21"), "Items Price is Correct");
		assertTrue(minicartModal.getItemPrice("€215.97"), "Items Price is Correct");
		assertTrue(minicartModal.getItemPrice("€105.88"), "Items Price is Correct");
		assertTrue(minicartModal.getItemPrice("€218.48"), "Items Price is Correct");
	
		cartQuotesPage.clickCASA39Logo();
		homePage.clickSignOut();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "", 
			Coverage = "Verifies user can apply discount on shopping cart page.",
			CreateDate = "27/07/2021")
	@Test()
	public void testApplyForDiscountOnShoppingCartPage() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);

		String productName = "Zucchetti Closer Wall Mounted Showerhead Z94250";
		String searchText = "Zucchetti Closer Wall Mounted Showerhead Z94250";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText, productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName), productName + " as Searched Product is Correctly Displayed");

		logStep("Select Quantity and add to cart");
		InformationModal informationModal = descriptionPage.clickAddToCart();
		assertTrue(informationModal.isSuccessMessageDisplayed(productName), productName);
		assertTrue(informationModal.isSuccessMessageDisplayed("has been added to your cart"), "has been added to your cart");
		
		logStep("Navigate to Shopping Cart Page");
		ShoppingCartPage shoppingCartPage = informationModal.clickViewCart();
		assertTrue(shoppingCartPage.isPageTitleDisplayed("Shopping cart"), "Page Title is Displayed");
		
		shoppingCartPage.clickApplyCoupon("DISCOUNT");
		assertTrue(shoppingCartPage.isErrorMessageDisplayed("The coupon code \"DISCOUNT\" is not valid."), "The coupon code \"DISCOUNT\" is not valid.");
		
		logStep("Clear Shopping Cart");
		shoppingCartPage.clearShoppingCart();
		assertTrue(shoppingCartPage.validateEmptyCartMessage(), "You have no items in your shopping cart.");
		
		shoppingCartPage.clickCASA39Logo();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies user can add group products to card by selecting quantity.", 
			CreateDate = "02/08/2021")
	@Test()
	public void testAddGroupProductsToCart() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);
		
		String productName = "Simas Vignoni suspended toilet Rimless, bidet and WC-seat";
		String searchText = "Simas Vignoni suspended toilet Rimless";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText, productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName), productName +" as Searched Product is Correctly Displayed");

		logStep("Select Quantity for all product groups");
		descriptionPage.selectGroupQuantityAs("5");
		
		logStep("Add to Cart");
		InformationModal informationModal = descriptionPage.clickAddToCart();
		assertTrue(informationModal.isSuccessMessageDisplayed(productName), productName);
		assertTrue(informationModal.isSuccessMessageDisplayed("has been added to your cart"),
				"has been added to your cart");
		
		logStep("View Shopping Cart");
		ShoppingCartPage shoppingCartPage = informationModal.clickViewCart();
		
		logStep("Validate Group Product Price Details");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€164.71"), "Price is Correct");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€68.91"), "Price is Correct");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€151.26"), "Price is Correct");
		
		logStep("Validate Group Product Sub Total Details");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€823.55"), "Subtotal Price is Correct");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€344.55"), "Subtotal Price is Correct");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€756.30"), "Subtotal Price is Correct");
		
		logStep("Validate Group Product Quantity Details");
		assertTrue(shoppingCartPage.validateCartQuantityDetails("5"), "Quantity is Correct");
		assertTrue(shoppingCartPage.validateCartPriceDetails("5"), "Quantity is Correct");
		assertTrue(shoppingCartPage.validateCartPriceDetails("5"), "Quantity is Correct");
		
		shoppingCartPage.clickCASA39Logo();
		closeBrowser();
	}
	
	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies user remove product from cart from shopping cart page.", 
			CreateDate = "24/08/2021")
	@Test()
	public void testRemoveProductFromCart() throws Exception {

		HomePage homePage = navigateToCasa39Website(false);
		
		String productName = "Pozzi Ginori Abele Square shower tray 90x90 cm 60141";
		String searchText = "Pozzi Ginori Abele Square";

		logStep("Search for a Available Product as " + productName);
		SearchResultsPage searchResultsPage = homePage.searchFor(searchText);
		ProductDescriptionPage descriptionPage = searchResultsPage.selectProductFromSuggestedList(searchText, productName);
		assertTrue(descriptionPage.isPageTitleDisplayed(productName), productName +" as Searched Product is Correctly Displayed");

		logStep("Select Quantity and add to cart");
		descriptionPage.selectQuantityAs("3");
		InformationModal informationModal = descriptionPage.clickAddToCart();
		assertTrue(informationModal.isSuccessMessageDisplayed(productName), productName);
		assertTrue(informationModal.isSuccessMessageDisplayed("has been added to your cart"), "has been added to your cart");
		
		logStep("View Shopping Cart");
		ShoppingCartPage shoppingCartPage = informationModal.clickViewCart();
		
		logStep("Validate Group Product Price Details");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€294.12"), "Price is Correct");
		
		logStep("Validate Group Product Sub Total Details");
		assertTrue(shoppingCartPage.validateCartPriceDetails("€882.36"), "Subtotal Price is Correct");
		
		logStep("Validate Group Product Quantity Details");
		assertTrue(shoppingCartPage.validateCartQuantityDetails("3"), "Quantity is Correct");
		
		logStep("Remove Item from Cart");
		shoppingCartPage.clickRemoveItem();
		assertTrue(shoppingCartPage.validateEmptyCartMessage(), "You have no items in your shopping cart.");
		
		shoppingCartPage.clickCASA39Logo();
		closeBrowser();
	}
}