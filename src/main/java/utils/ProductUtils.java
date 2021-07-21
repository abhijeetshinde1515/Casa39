package utils;

import pages.catalogue.ProductListPage;
import pages.home.HomePage;

public class ProductUtils extends AssertUtil {

	public static HomePage selectAndValidateMainProductCategories(HomePage homePage, String category, String pageTitle) {
		
		logStep("Choose and Select Category As "+category+" From Product Categories");
		ProductListPage productListPage = homePage.selectProductCategory(category);
		assertTrue(productListPage.isPageTitleDisplayed(pageTitle), category +" - Category Opened Successfully...");
		return productListPage.clickCASA39Logo();
	}
	
	public static HomePage selectAndValidateProductSubCategories(HomePage homePage, String category, String subcategory, String pageTitle) {
		
		logStep("Choose and Select Category As "+category+" From Product Categories");
		ProductListPage productListPage = homePage.selectProductSubCategory(category, subcategory);
		assertTrue(productListPage.isPageTitleDisplayed(pageTitle), pageTitle +" - Sub Category Opened Successfully...");
		return productListPage.clickCASA39Logo();
	}
}
