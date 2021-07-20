package framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonModal extends BaseFragment {

	public CommonModal(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	/************ locators ***************/
	
	@FindBy(css = "button.action-primary.action-accept")
	WebElement accept_by;
	
	@FindBy(css = "button.action-secondary.action-dismiss")
	WebElement dismiss_by;
	
	@FindBy(css = ".modal-content")
	WebElement content_by;
	
	/************ actions ****************/
	
	public void clickOk() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(accept_by)).click();
		hardWait(5000);
	}
	
	public void clickCancel() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(dismiss_by)).click();
		hardWait(5000);
	}
	
	/************ accessors **************/
	/************ validations ************/
	
	public boolean isModalConentDisplayed(String content) {
		return content_by.isDisplayed() && content_by.getText().equals(content);
	}
}
