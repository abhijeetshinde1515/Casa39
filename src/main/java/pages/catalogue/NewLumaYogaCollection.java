package pages.catalogue;

import org.openqa.selenium.remote.RemoteWebDriver;

import framework.CommonPage;
import pages.catalogue.ProductSorterFunction;

public class NewLumaYogaCollection extends CommonPage {

	public NewLumaYogaCollection(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	/************ actions ****************/
	
	/************ accessors **************/
	
	public ProductSorterFunction getProductSorterFunction() {
		return new ProductSorterFunction(driver);
	}
	
	/************ validations ************/
		
}
