package pages.home;

import java.util.List;

import org.openqa.selenium.By;
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
	
	public MyOrdersPage clickViewOrder() {
		clickUsingJSExecutor(findElement(By.linkText("View Order")));
		return new MyOrdersPage(driver);
	}
	
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
	
	public boolean isOrderIdDisplayed(String order) {
		List<WebElement> orders = driver.findElements(By.cssSelector("td.col.id"));
		for (WebElement listItem : orders)
			if (listItem.getText().contains(order)) {
				break;
			}
		return true;
	}
	
	public boolean isOrderDateDisplayed(String date) {
		List<WebElement> dates = driver.findElements(By.cssSelector("td.col.date"));
		for (WebElement listItem : dates)
			if (listItem.getText().contains(date)) {
				break;
			}
		return true;
	}
	
	public boolean isOrderTotalDisplayed(String orderTotal) {
		List<WebElement> totals = driver.findElements(By.cssSelector("td.col.total"));
		for (WebElement listItem : totals)
			if (listItem.getText().contains(orderTotal)) {
				break;
			}
		return true;
	}
	
	public boolean isOrderStatusDisplayed(String orderstatus) {
		List<WebElement> allStatus = driver.findElements(By.cssSelector("td.col.status"));
		for (WebElement listItem : allStatus)
			if (listItem.getText().contains(orderstatus)) {
				break;
			}
		return true;
	}
	
	public boolean isAdditionalAddressFirstNameDisplayed(String firstName) {
		List<WebElement> Names = driver.findElements(By.id("td.col.firstname"));
		for (WebElement listItem : Names)
			if (listItem.getText().contains(firstName)) {
				break;
			}
		return true;
	}
	
	public boolean isAdditionalAddressLastNameDisplayed(String lastName) {
		List<WebElement> Names = driver.findElements(By.id("td.col.lastname"));
		for (WebElement listItem : Names)
			if (listItem.getText().contains(lastName)) {
				break;
			}
		return true;
	}
	
	public boolean isAdditionalStreetAddressDisplayed(String streetaddress) {
		List<WebElement> listItems = driver.findElements(By.id("td.col.streetaddress"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(streetaddress)) {
				break;
			}
		return true;
	}
	
	public boolean isAdditionalCityDisplayed(String city) {
		List<WebElement> listItems = driver.findElements(By.id("td.col.city"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(city)) {
				break;
			}
		return true;
	}
	
	public boolean isAdditionalAddressCountryDisplayed(String country) {
		List<WebElement> listItems = driver.findElements(By.id("td.col.country"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(country)) {
				break;
			}
		return true;
	}
	
	public boolean isAdditionalAddressStateDisplayed(String state) {
		List<WebElement> listItems = driver.findElements(By.id("td.col.state"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(state)) {
				break;
			}
		return true;
	}
	
	public boolean isAdditionalAddressZipCodeDisplayed(String zip) {
		List<WebElement> listItems = driver.findElements(By.id("td.col.zip"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(zip)) {
				break;
			}
		return true;
	}
	
	public boolean isAdditionalAddressPhoneDisplayed(String phone) {
		List<WebElement> listItems = driver.findElements(By.id("td.col.phone"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(phone)) {
				break;
			}
		return true;
	}
}