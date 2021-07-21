package framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BaseFragment {

	public CommonPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	/************ locators ***************/
	
	@FindBy(css = ".page-title")
	WebElement pageTitle_by;
	
	@FindBy(css = "div.message.success.success.message")
	WebElement success_message_by;

	@FindBy(css = "div.message.error.error.message")
	WebElement error_message_by;
	
	@FindBy(css = "div.message.notice.notice.message")
	WebElement notice_message_by;

	
	/************ actions ****************/
	/************ accessors **************/
	/************ validations ************/
	
	public boolean isPageTitleDisplayed(String title) {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().contains(title);
	}
	
	
	public boolean isSuccessMessageDisplayed(String message) {
		return success_message_by.isDisplayed() && success_message_by.getText().contains(message);
	}

	public boolean isErrorMessageDisplayed(String message) {
		return error_message_by.isDisplayed() && error_message_by.getText().contains(message);
	}
	
	public boolean isNoticeMessageDisplayed(String message) {
		return notice_message_by.isDisplayed() && notice_message_by.getText().contains(message);
	}
}
