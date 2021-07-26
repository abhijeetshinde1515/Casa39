package pages.catalogue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import framework.CommonPage;
import pages.home.HomePage;

public class CartQuotesPage extends CommonPage {

	public CartQuotesPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
		hardWait(5000);
	}

	/************ locators ***************/
	
	@FindBy(css = ".input-text.qty")
	WebElement qty_by;
	
	@FindBy(name = "update_cart_action")
	WebElement updateQuote_by;
	
	@FindBy(id = "customer-email")
	WebElement email_by;
	
	@FindBy(name = "firstname")
	WebElement firstName_by;
	
	@FindBy(name = "lastname")
	WebElement lastName_by;
	
	@FindBy(name = "zip_code")
	WebElement zipCode_by;
	
	@FindBy(name = "country_id")
	WebElement country_by;
	
	@FindBy(name = "quote_remark")
	WebElement remark_by;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[7]/div/ul/li[1]/button")
	WebElement requestQuote_by;
	
	/************ actions ****************/
	public void updateQuantity(String qty) {
		qty_by.clear();
		sendKeys(qty_by, qty);
	}
	
	public CartQuotesPage updateQuote() {
		clickUsingJSExecutor(updateQuote_by);
		return new CartQuotesPage(driver);
	}
	
	public void setEmail(String email) {
		sendKeys(email_by, email);
		waituntilPageLoads();
	}
	
	public void setFirstName(String firstName) {
		sendKeys(firstName_by, firstName);
		waituntilPageLoads();
	}
	
	public void setLastName(String lastName) {
		sendKeys(lastName_by, lastName);
		waituntilPageLoads();
	}
	
	public void setZipCode(String zipCode) {
		sendKeys(zipCode_by, zipCode);
		waituntilPageLoads();
	}
	
	public void setCountry(String country)  {
		click(country_by);
		Reporter.log("Select Option As - "+country);
		Select sortOptions = new Select(country_by);
		sortOptions.selectByVisibleText(country);
		waituntilPageLoads();
		hardWait(5000);
	}
	
	public void setRemarks(String remarks) {
		sendKeys(remark_by, remarks);
		hardWait(5000);
	}
	
	public HomePage clickRequestQuote() {
		clickUsingJSExecutor(requestQuote_by);
		return new HomePage(driver);
	}
	
	/************ accessors **************/
	
	/************ validations ************/
	
}
