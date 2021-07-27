package pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import framework.CommonPage;

public class WhyChooseUsSection extends CommonPage {

	public WhyChooseUsSection(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(css = "div.title span")
	WebElement pageTitle_by;
	
	/************ actions ****************/
	
	/************ accessors **************/
	
	public boolean isPageSectionDisplayed(String title) {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().contains(title);
	}

	/************ validations ************/
}
