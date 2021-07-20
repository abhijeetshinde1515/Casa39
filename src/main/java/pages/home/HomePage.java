package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.CommonPage;
import pages.catalogue.CategoryPage;

public class HomePage extends CommonPage {

	public HomePage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
		hardWait(5000);
	}

	/************ locators ***************/

	@FindBy(css = ".not-logged-in")
	WebElement notLoggedIn_by;

	@FindBy(css = ".logged-in")
	WebElement loggedIn_by;

	@FindBy(linkText = "Create an Account")
	WebElement createAccount_by;

	@FindBy(css = ".copyright")
	WebElement copyright_by;

	@FindBy(css = "button.action.switch")
	WebElement profileDropdown_by;

	@FindBy(id = "newsletter")
	WebElement newsletter_by;

	@FindBy(css = "button.action.subscribe")
	WebElement subscribe_by;

	@FindBy(id = "newsletter-error")
	WebElement newslettererror_by;
	
	@FindBy(css = "a.action.showcart")
	WebElement minicart_by;
	
	@FindBy(id = "search")
	WebElement searchBox_by;
	
	@FindBy(css = "button.action.search")
	WebElement searchButton_by;
	
	//Casa39 - English
	
	@FindBy(css = "a.cc-btn.cc-dismiss")
	WebElement acceptCookies_by;
	
	@FindBy(linkText = "SIGN IN")
	WebElement signIn_by;
	
	@FindBy(linkText = "SIGN OUT")
	WebElement signOut_by;

	/************ actions ***************/

	public CustomerRegisterPage clickCreateAnAccount() {
		click(createAccount_by);
		return new CustomerRegisterPage(driver);
	}

	public InformationLinksPage clickInfoLinksAs(String linkText) {
		WebElement element = findElement(By.linkText(linkText));
		clickUsingJSExecutor(element);
		return new InformationLinksPage(driver);
	}

	public MyAccountPage GoToMyAccount() {
		click(profileDropdown_by);
		clickLink("My Account");
		return new MyAccountPage(driver);
	}

	public MyWishListPage GoToMyWishList() {
		click(profileDropdown_by);
		clickPartialLink("My Wish List");
		return new MyWishListPage(driver);
	}

	public HomePage subscribeToEmailAs(String email) {
		newsletter_by.sendKeys(email);
		clickEmailSubScribe();
		return new HomePage(driver);
	}

	public HomePage clickEmailSubScribe() {
		clickUsingJSExecutor(subscribe_by);
		return new HomePage(driver);
	}

	public CategoryPage goToMenuItemAs(String menuText, String subMenuText, String itemText) {
//		List<WebElement> menus = driver.findElements(By.cssSelector(".level-top.ui-menu-item"));
//		Actions actions = new Actions(driver);
//		for (WebElement submenu : menus)
//			if (submenu.getText().equals(menuText)) {
//				actions.moveToElement(findElement(By.linkText(menuText)));
//				actions.moveToElement(findElement(By.linkText(itemText)));
//				actions.click().build().perform();
//				break;
//			}
		
		Actions actions = new Actions(driver);
		actions.moveToElement(findElement(By.linkText(menuText)));
		actions.moveToElement(findElement(By.linkText(subMenuText)));
		actions.click().build().perform();
		return new CategoryPage(driver);
	}
	
	public MinicartModal clickMyCart() {
		click(minicart_by);
		return new MinicartModal(driver);
	}
	
	//Casa39 - English
	
	public void acceptCookies() {
		click(new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(acceptCookies_by)));;
	}
	
	public CustomerSignInPage clickSignIn() {
		click(signIn_by);
		return new CustomerSignInPage(driver);
	}
	
	public SignOutPage clickSignOut() {
		click(signOut_by);
		return new SignOutPage(driver);
	}
	
	public SearchResultsPage searchFor(String searchText) {
		searchBox_by.sendKeys(searchText);
		return new SearchResultsPage(driver);
	}
	
	public SearchResultsPage clickEnterForSearch() {
		searchBox_by.sendKeys(Keys.ENTER);
		return new SearchResultsPage(driver);
	}

	/************ validations ***************/

	public boolean validateNotLoggedInUser() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(notLoggedIn_by));
		return notLoggedIn_by.isDisplayed() && notLoggedIn_by.getText().contains("Default welcome msg!");
	}

	public boolean validatLoggedInUser(String userName) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(loggedIn_by));
		return loggedIn_by.isDisplayed() && loggedIn_by.getText().contains("Welcome, " + userName + "!");
	}

	public boolean validateCopyright() {
		return copyright_by.isDisplayed()
				&& copyright_by.getText().contains("Copyright © 2013-present Magento, Inc. All rights reserved.");
	}

	public boolean validateEmailSubscriptionError() {
		return newslettererror_by.isDisplayed() && newslettererror_by.getText().contains("This is a required field.");
	}
}