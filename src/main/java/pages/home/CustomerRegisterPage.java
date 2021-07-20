package pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import framework.CommonPage;

public class CustomerRegisterPage extends CommonPage {
	
	public CustomerRegisterPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	@FindBy(css = ".page-title")
	WebElement pageTitle_by;

	@FindBy(id = "firstname")
	WebElement firstName_by;
	
	@FindBy(id = "lastname")
	WebElement lastName_by;
	
	@FindBy(id = "email_address")
	WebElement emailAddress_by;
	
	@FindBy(id = "password")
	WebElement password_by;
	
	@FindBy(id = "password-confirmation")
	WebElement password_confirmation_by;
	
	@FindBy(css = ".action.submit.primary")
	WebElement createAccount_by;

	/************ actions ***************/
	
	public void setFirstName(String firstName) {
		firstName_by.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastName_by.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		emailAddress_by.sendKeys(email);
	}
	
	public void setPassword(String password) {
		password_by.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword) {
		password_confirmation_by.sendKeys(confirmPassword);
	}
	
	public MyAccountPage clickCreateAccount() {
		click(createAccount_by);
		return new MyAccountPage(driver);
	}

	/************ validations ***************/
	
	public boolean isCustomerRegisterPageDisplayed() {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().equals("Create New Customer Account");
	}
}