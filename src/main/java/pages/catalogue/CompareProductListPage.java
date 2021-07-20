package pages.catalogue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import framework.CommonPage;

public class CompareProductListPage extends CommonPage {

	public CompareProductListPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(css = ".page-title")
	WebElement pageTitle_by;
	
	@FindBy(id = "product-comparison")
	WebElement compareDescription_by;
	
	/************ actions ****************/
	/************ accessors **************/
	
	public boolean getDesription(String description) {
		return compareDescription_by.getText().contains(description);
	}
	
	/************ validations ************/
	public boolean isProductCompareListPageDisplayed() {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().equals("Compare Products");
	}
}
