package tests.shopping;

import org.testng.annotations.Test;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.catalogue.InformationModal;
import pages.catalogue.ProductDescriptionPage;
import pages.catalogue.ProductListPage;
import pages.catalogue.ProductSorterFunction;
import pages.home.HomePage;
import pages.home.SearchResultsPage;
import utils.GeneratorUtils;

public class TestProductShopping extends TestNGBaseTest {

	@TestDocumentation(
			TestNumber = "",
			Coverage = "Verifies that user can select product by applying filters and sorting options and products per page.", 
			CreateDate = "22/07/2021")
	@Test()
	public void testApplySortingOptionsFiltersAndPriceRange() throws Exception {
		HomePage homePage = navigateToCasa39Website(false);
		
		String category = "FLOOR TILES";
		String subcategory = "Cleansers";
		
		logStep("Choose and Select Category As "+category+" From Product Categories");
		ProductListPage productListPage = homePage.selectProductSubCategory(category, subcategory);
		assertTrue(productListPage.isPageTitleDisplayed(subcategory), subcategory +" - Sub Category Opened Successfully...");
		
		logStep("Validate Sorting Options");
		ProductSorterFunction productSorterFunction = productListPage.getProductSorterFunction();
		productSorterFunction.sortByOptionAs("bestsellers");
		productSorterFunction.sortByOptionAs("is_hot");
		productSorterFunction.sortByOptionAs("most_viewed");
		productSorterFunction.sortByOptionAs("new");
		productSorterFunction.sortByOptionAs("price");
		
		logStep("Apply all filters one by one.");
		productSorterFunction.applyFiltersOneByOne();
		
		logStep("Set price range.");
		productSorterFunction.setPriceRange("0", "22");
		
		logStep("Change Products Per Page");
		productSorterFunction.setShowProductsPerPage("48");
		productSorterFunction.setShowProductsPerPage("72");
		productSorterFunction.setShowProductsPerPage("24");
		
		productSorterFunction.clickCASA39Logo();
		closeBrowser();
	}
	
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
}