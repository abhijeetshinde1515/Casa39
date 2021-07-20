package pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import framework.CommonPage;

public class SignOutPage extends CommonPage {

	public SignOutPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/

	@FindBy(css = ".page-title")
	WebElement pageTitle_by;

	@FindBy(id = "maincontent")
	WebElement blockContent_by;

	/************ accessors ***************/

	public String getPageInformationContent() {
		return blockContent_by.getText();
	}

	/************ actions ***************/

	/************ validations ***************/

	public boolean isSignOutPageDisplayed() {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().equals("You are signed out");
	}

	public boolean isDisplayedSignOutInformation(String signOutInformation) {
		return getPageInformationContent().contains(signOutInformation);
	}
}
