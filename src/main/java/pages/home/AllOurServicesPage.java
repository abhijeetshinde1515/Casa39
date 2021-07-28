package pages.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import framework.CommonPage;
import utils.ReportUtils;

public class AllOurServicesPage extends CommonPage {

	public AllOurServicesPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	/************ actions ****************/
	
	/************ accessors **************/
	
	/************ validations ************/
	public void getShippingCountries() {
		ReportUtils.logStep("Products purchased on CASA39 can be delivered to the following countries:");
		List<WebElement> listItems = driver.findElements(By.cssSelector(".panel-title a"));
		for (WebElement listItem : listItems) {
				ReportUtils.logVerify(listItem.getText());
				
		}
	}
	
}
