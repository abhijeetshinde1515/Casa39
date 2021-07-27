package pages.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import framework.CommonPage;

public class BuyersProtectionModal extends CommonPage {

	public BuyersProtectionModal(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(css = "div._13o7q6c")
	WebElement label_by;
	
	@FindBy(id = "close-button-98e3dadd90eb493088abdc5597a70810")
	WebElement closeButton_by;
	
	/************ actions ****************/
	
	public void closeBadge() {
		clickUsingJSExecutor(closeButton_by);
	}
	
	/************ accessors **************/
	
	/************ validations ************/	
	public boolean validateKeySummary(String summary) {
		Reporter.log("Validating '" + summary + "' from Buyer's Protection Information...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("div._13o7q6c"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(summary)) {
				return true;
			}
		return false;
	}
}
