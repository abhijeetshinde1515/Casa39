package pages.catalogue;

import org.openqa.selenium.remote.RemoteWebDriver;

import framework.CommonPage;

public class ProductListPage extends CommonPage {

	public ProductListPage(RemoteWebDriver webDriver) {
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
