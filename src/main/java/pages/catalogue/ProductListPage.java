package pages.catalogue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import framework.CommonPage;

public class ProductListPage extends CommonPage {

	public ProductListPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/

	/************ actions ****************/
	
	public InformationModal addProductToCart(String productName, int index) {
		logStep("Selecting " + productName + " from list...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("li img.mincartnew"));
			clickUsingJSExecutor(listItems.get(index));
		
		return new InformationModal(driver);
	}
	
	public InformationModal addProductToQuote(String productName, int index) {
		logStep("Selecting " + productName + " from list...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("li img.mincartnew"));
			clickUsingJSExecutor(listItems.get(index));
		
		return new InformationModal(driver);
	}

	/************ accessors **************/

	public ProductSorterFunction getProductSorterFunction() {
		return new ProductSorterFunction(driver);
	}

	/************ validations ************/
}
