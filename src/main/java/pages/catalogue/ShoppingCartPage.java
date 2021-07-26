package pages.catalogue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import framework.CommonPage;
import pages.catalogue.CheckOutPage;

public class ShoppingCartPage extends CommonPage {

	public ShoppingCartPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
		hardWait(5000);
	}
	
	/************ locators ***************/
	
	@FindBy(css =  ".action.primary.checkout span")
	WebElement checkOutButton_by;
	
	@FindBy(css = "a.action.action-delete")
	WebElement removeItem_by;
	
	@FindBy(css = ".cart-empty")
	WebElement emptyCart_by;
	
	/************ actions ****************/
	public CheckOutPage clickProceedToCheckOut() {
		waituntilPageLoads();
		clickUsingJSExecutor(checkOutButton_by);
		return new CheckOutPage(driver);
	}
	
	public void clickRemoveItemFromList() {
		click(removeItem_by);
	}
	/************ accessors **************/
	
	/************ validations ************/
	public boolean validateEmptyCartMessage() {
		return emptyCart_by.getText().contains("You have no items in your shopping cart.");
	}
	
	public boolean validatePriceSummary(String price) {
		Reporter.log("Validating '" + price + "' from Summary...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("td.amount span.price"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(price)) {
				return true;
			}
		return false;
	}
		
	
}
