package pages.catalogue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.CommonPage;

public class CheckOutPage extends CommonPage {

	public CheckOutPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
		hardWait(5000);
	}
	/************ locators ***************/
	
	@FindBy(css = ".anchors__item-customer")
	WebElement customerName_by;
	
	@FindBy(css = ".anchors__item-street-name")
	WebElement streetName_by;
	
	@FindBy(css = "a.edit-cart-link")
	WebElement editCartLink_by;
	
	/************ actions ****************/
	
	public ShoppingCartPage clickBackToShoppingCartPage() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(editCartLink_by)).click();
		waituntilPageLoads();
		return new ShoppingCartPage(driver);
	}
	/************ accessors **************/
	
	public boolean getShipToCustomerName(String name) {
		return customerName_by.getText().contains(name);
	}
	
	public boolean getShipToAddress(String address) {
		return streetName_by.getText().contains(address);
	}
	
	/************ validations ************/
}