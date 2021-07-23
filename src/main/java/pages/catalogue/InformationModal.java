package pages.catalogue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import framework.CommonPage;

public class InformationModal extends CommonPage {

	public InformationModal(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	/************ locators ***************/
	
	@FindBy(id = "messageBox")
	WebElement message_by;
	
	@FindBy(css = "button.am-btn-left")
	WebElement crossButton_by;
	
	/************ actions ****************/
	
	public ProductDescriptionPage clickCross() {
		click(crossButton_by);
		return new ProductDescriptionPage(driver);
	}
	
	/************ accessors **************/
	
	/************ validations ************/
	
	public boolean isSuccessMessageDisplayed(String message) {
		return message_by.isDisplayed() && message_by.getText().contains(message);
	}
}
