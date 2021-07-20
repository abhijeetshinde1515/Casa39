package pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import framework.CommonPage;

public class MyAccountPage extends CommonPage {
	
	public MyAccountPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	@FindBy(css = ".page-title")
	WebElement pageTitle_by;
		
	@FindBy(css = "div.message.success.success.message")
	WebElement success_message_by;
	
	@FindBy(css = "div.block.block-dashboard-info")
	WebElement accountInformation_by;
	
	@FindBy(css = "div.box-billing-address")
	WebElement billingAddress_by;
	
	@FindBy(css = "div.box-shipping-address")
	WebElement shippingAddress_by;
	
	@FindBy(css = "div.message.info.empty")
	WebElement emptyMessage_by;

	/************ actions ***************/
	

	/************ validations ***************/
	
	public boolean isMyAccountPageDisplayed() {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().equals("My Account");
	}
	
	public boolean isSuccessMessageDisplayed(String message) {
		return success_message_by.isDisplayed() && success_message_by.getText().contains(message);
	}
	
	public boolean isAccountInformationDisplayed(String accountInformation) {
		return accountInformation_by.isDisplayed() && accountInformation_by.getText().contains(accountInformation);
	}
	
	public boolean isBillingAddressDisplayed(String billingAddress) {
		return billingAddress_by.isDisplayed() && billingAddress_by.getText().contains(billingAddress);
	}
	
	public boolean isShippingAddressDisplayed(String shippingAddress) {
		return shippingAddress_by.isDisplayed() && shippingAddress_by.getText().contains(shippingAddress);
	}
	
	public boolean isEmptyMessageDisplayed(String message) {
		return emptyMessage_by.isDisplayed() && emptyMessage_by.getText().contains(message);
	}
}