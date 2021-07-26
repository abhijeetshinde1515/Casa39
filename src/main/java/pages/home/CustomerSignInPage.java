package pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import framework.CommonPage;

public class CustomerSignInPage extends CommonPage {
	
	public CustomerSignInPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	// Casa39 - English

	@FindBy(css = ".page-title")
	WebElement pageTitle_by;
	
	@FindBy(id = "email")
	WebElement email_by;
	
	@FindBy(id = "pass")
	WebElement password_by;
	
	@FindBy(id = "send2")
	WebElement signIn_by;
	
	@FindBy(id = "email-error")
	WebElement emailError_by;
	
	@FindBy(id = "pass-error")
	WebElement passwordError_by;
	
	@FindBy(css = ".amsl-close")
	WebElement close_by;

	@FindBy(linkText = "New account")
	WebElement createAccount_by;

	/************ actions ***************/
	
	public void setEmail(String email) {
		email_by.clear();
		email_by.sendKeys(email);
	}
	
	public void setPassword(String password) {
		password_by.clear();
		password_by.sendKeys(password);
	}
	
	public HomePage clickSignIn() {
		click(signIn_by);
		hardWait(3000);
		return new HomePage(driver);
	}
	
	public HomePage closeSignInPage() {
		click(close_by);
		return new HomePage(driver);
	}
	
	public CustomerRegisterPage clickCreateAnAccount() {
		click(createAccount_by);
		return new CustomerRegisterPage(driver);
	}

	/************ accessors ***************/
	
	public String getEmailErrorMessage() {
		return emailError_by.getText();
	}
	
	public String getPasswordErrorMessage() {
		return passwordError_by.getText();
	}
}
