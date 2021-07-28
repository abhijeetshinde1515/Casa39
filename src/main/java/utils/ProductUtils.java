package utils;

import pages.catalogue.ProductListPage;
import pages.home.HomePage;
import pages.home.MyAccountPage;

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
	
	public static MyAccountPage validateMyOderDetailsAs(MyAccountPage myAccountPage, String orderID, String date, String orderTotal, String status) {

		assertTrue(myAccountPage.isOrderIdDisplayed(orderID), "Order ID as '"+orderID+"' Displayed correctly");
		assertTrue(myAccountPage.isOrderDateDisplayed(date), "Order Date as '"+date+"' Displayed correctly");
		assertTrue(myAccountPage.isOrderTotalDisplayed(orderTotal), "Order Total as '"+orderTotal+"' Displayed correctly");
		assertTrue(myAccountPage.isOrderStatusDisplayed(status), "Order ID as '"+status+"' Displayed correctly");
		
		return myAccountPage;
	}
	
	public static MyAccountPage validateAdditionalAddressDetailsAs(MyAccountPage myAccountPage, String firstName, String lastName, String street, String city, String country, String state, String zip, String phone) {

		assertTrue(myAccountPage.isAdditionalAddressFirstNameDisplayed(firstName), "First Name as '"+firstName+"' Displayed correctly");
		assertTrue(myAccountPage.isAdditionalAddressLastNameDisplayed(lastName), "Last Name as '"+lastName+"' Displayed correctly");
		assertTrue(myAccountPage.isAdditionalStreetAddressDisplayed(street), "street Address as '"+street+"' Displayed correctly");
		assertTrue(myAccountPage.isAdditionalCityDisplayed(city), "City as '"+city+"' Displayed correctly");
		assertTrue(myAccountPage.isAdditionalCityDisplayed(country), "Country as '"+country+"' Displayed correctly");
		assertTrue(myAccountPage.isAdditionalAddressStateDisplayed(state), "Country as '"+state+"' Displayed correctly");
		assertTrue(myAccountPage.isAdditionalAddressZipCodeDisplayed(zip), "Zip/Postal code as '"+zip+"' Displayed correctly");
		assertTrue(myAccountPage.isAdditionalAddressZipCodeDisplayed(phone), "Phone as '"+phone+"' Displayed correctly");
		
		return myAccountPage;
	}
	
	public static void selectAndValidateAllProductSubCategories(HomePage homePage) {
		logStep("List all subcategories associated with it's navigation link");
		homePage.selectProductAllSubCategory();
	}
	
	public static void selectAndValidateAllPlatforms(HomePage homePage) {
		logStep("List all platforms associated with it's navigation link");
		homePage.selectPlatforms();
	}
	
	public static void selectAndValidateAllSocialMediaPlatforms(HomePage homePage) {
		logStep("List all social media platforms associated with it's navigation link");
		homePage.selectSocialMediaPlatforms();
	}

}
