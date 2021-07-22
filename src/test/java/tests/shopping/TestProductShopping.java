package tests.shopping;

import org.testng.annotations.Test;
import baseTestScripts.TestNGBaseTest;
import framework.TestDocumentation;
import pages.catalogue.ProductListPage;
import pages.catalogue.ProductSorterFunction;
import pages.home.HomePage;

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
}