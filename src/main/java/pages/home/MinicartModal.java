package pages.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import framework.BaseFragment;
import framework.CommonModal;
import pages.catalogue.CartQuotesPage;
import pages.catalogue.ShoppingCartPage;

public class MinicartModal extends BaseFragment {

	public MinicartModal(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(css = ".subtitle.empty")
	WebElement emptyCart_by;
	
	@FindBy(id = "btn-minicart-close")
	WebElement closeCart_by;
	
	@FindBy(css = "span.counter-number")
	WebElement counterNumber_by;
	
	@FindBy(css = ".items-total")
	WebElement totalItems_by;
	
	@FindBy(css = ".amount.price-container")
	WebElement amountPrice_by;
	
	@FindBy(css = "a.action.viewcart")
	WebElement viewCart_by;
	
	@FindBy(css = "a.action.delete")
	WebElement removeItem_by;
	
	@FindBy(id = "top-quotecart-button")
	WebElement askQuoteButton_by;
	
	/************ actions ****************/
	
	public void closeMyCart() {
		click(closeCart_by);
	}
	
	public ShoppingCartPage clickViewAndEditCart() {
		click(viewCart_by);
		return new ShoppingCartPage(driver);
	}
	
	public CommonModal clickRemoveItemFromList() {
		click(removeItem_by);
		return new CommonModal(driver);
	}
	
	public CartQuotesPage clickAskForQuotes() {
		click(askQuoteButton_by);
		return new CartQuotesPage(driver);
	}
	
	/************ accessors **************/
	public boolean getEmptyCartText() {
		return emptyCart_by.getText().contains("You have no items in your shopping cart.");
	}
	
	public String getProductNumber() {
		return counterNumber_by.getText();
	}
	
	public String getTotalItems() {
		return totalItems_by.getText();
	}
	
	public String getAmountPrice() {
		return amountPrice_by.getText();
	}
	
	public boolean getItemPrice(String price) {
		logStep("Validating '" + price + "' from Summary...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("span.price"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(price)) {
				return true;
			}
		return false;
	}
	
	/************ validations ************/
}