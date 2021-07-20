package pages.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import framework.CommonPage;
import pages.catalogue.ProductDescriptionPage;

public class SearchResultsPage extends CommonPage {

	public SearchResultsPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(css = ".amsearch-products.-waste")
	WebElement blankResults_by;
	
	/************ actions ****************/
	
	public ProductDescriptionPage selectProductFromSuggestedList(String partialValue, String value) {
		Reporter.log("Selecting product from suggested item list...");
		List<WebElement> listItems = driver.findElements(By.cssSelector(".product-item-link"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(value)) {
				click(listItem);
				break;
			}
		
		return new ProductDescriptionPage(driver);
	}
	
	/************ accessors **************/
	/************ validations ************/
	public boolean isDisplayedSearchResultsFor(String ProductName) {
		return isPageTitleDisplayed("Search results for: '"+ProductName+"'");
	}
	
	public boolean isNoSearchResultsDisplayed(String blankResultsMessage) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(blankResults_by));
		return blankResults_by.isDisplayed() && blankResults_by.getText().contains(blankResultsMessage);
	}
}
