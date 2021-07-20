package pages.catalogue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

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
		click(checkOutButton_by);
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
}
