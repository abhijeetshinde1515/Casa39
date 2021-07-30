package pages.home;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import framework.CommonPage;
import pages.catalogue.CategoryPage;
import pages.catalogue.ProductListPage;
import utils.ReportUtils;

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

	// Casa39 - English

	@FindBy(css = "a.cc-btn.cc-dismiss")
	WebElement acceptCookies_by;

	@FindBy(linkText = "SIGN IN")
	WebElement signIn_by;

	@FindBy(linkText = "SIGN OUT")
	WebElement signOut_by;

	@FindBy(id = "switcher-website-trigger")
	WebElement website_switch;

	@FindBy(id = "switcher-country-trigger")
	WebElement country_switch;

	@FindBy(id = "switcher-currency-trigger")
	WebElement currency_switch;

	@FindBy(linkText = "MY ACCOUNT")
	WebElement myAccount_by;

	@FindBy(css = "img._qoy2qn")
	WebElement buyersProtection_by;

	@FindBy(css = ".amquote-showcart.action")
	WebElement quoteCart_by;

	@FindBy(linkText = "All our service")
	WebElement allOurServices_by;

	/************ actions ***************/

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

	public MinicartModal clickMyQuote() {
		clickUsingJSExecutor(quoteCart_by);
		return new MinicartModal(driver);
	}

	// Casa39 - English

	public void acceptCookies() {
		click(new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(acceptCookies_by)));
		;
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

	public HomePage selectLanguageAs(String language) {
		click(website_switch);
		Reporter.log("Selecting " + language + " from list...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("li.switcher-option a"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(language)) {
				click(listItem);
				break;
			}
		return new HomePage(driver);
	}

	public HomePage selectCountryAs(String country) {
		click(country_switch);
		Reporter.log("Selecting " + country + " from list...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("li.switcher-option a"));
		for (WebElement listItem : listItems)
			if (listItem.getText().equals(country)) {
				click(listItem);
				break;
			}
		return new HomePage(driver);
	}

	public HomePage selectCurrencyAs(String currency) {
		click(currency_switch);
		Reporter.log("Selecting " + currency + " from list...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("li.switcher-option a"));
		for (WebElement listItem : listItems)
			if (listItem.getText().contains(currency)) {
				click(listItem);
				break;
			}
		return new HomePage(driver);
	}

	public ProductListPage selectProductCategory(String category) {
		Reporter.log("Selecting " + category + " from list...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("a.ammenu-link.-main.-parent"));
		for (WebElement listItem : listItems)
			if (listItem.getText().equals(category)) {
				click(listItem);
				break;
			}
		return new ProductListPage(driver);
	}

	public ProductListPage selectProductSubCategory(String category, String subcategory) {
		Reporter.log("Selecting " + category + " from list...");
		List<WebElement> listItems = driver.findElements(By.cssSelector("a.ammenu-link.-main.-parent"));
		for (WebElement listItem : listItems)
			if (listItem.getText().equals(category)) {
				Actions action = new Actions(driver);
				action.moveToElement(listItem).perform();
				WebElement subcategoryElement = findElement(By.linkText(subcategory));
				new WebDriverWait(driver, 30)
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(subcategory)));
				new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.linkText(subcategory)));
				clickUsingJSExecutor(subcategoryElement);
				break;
			}
		return new ProductListPage(driver);
	}

	public void selectProductAllSubCategory() {
		List<WebElement> listItems = driver.findElements(By.cssSelector("a.ammenu-link.-level2"));
		for (WebElement listItem : listItems) {
			ReportUtils.logVerify(listItem.getAttribute("title") + " - " + listItem.getAttribute("href"));
			String url = listItem.getAttribute("href");
			verifyLinks(url);

		}
	}

	public void selectPlatforms() {
		List<WebElement> listItems = driver.findElements(By.cssSelector("div.row ul li a"));
		for (WebElement listItem : listItems) {
			ReportUtils.logVerify(listItem.getAttribute("title") + " - " + listItem.getAttribute("href"));
			String url = listItem.getAttribute("href");
			verifyLinks(url);
		}
	}

	public void selectSocialMediaPlatforms() {
		List<WebElement> listItems = driver.findElements(By.cssSelector("ul.social-list li"));
		List<WebElement> urls = driver.findElements(By.cssSelector("ul.social-list li a"));
		for (int i = 0; i < listItems.size(); ++i) {
			ReportUtils.logVerify(listItems.get(i).getAttribute("class") + " - " + urls.get(i).getAttribute("href"));
			String url = urls.get(i).getAttribute("href");
			verifyLinks(url);
		}
	}

	public void selectAllFooterLinks() {
		List<WebElement> listItems = driver.findElements(By.cssSelector("li.nav.item a"));
		for (WebElement listItem : listItems) {
			ReportUtils.logVerify(listItem.getText() + " - " + listItem.getAttribute("href"));
			String url = listItem.getAttribute("href");
			verifyLinks(url);
		}
	}

	public void selectAllOfferForYou() {
		List<WebElement> listItems = driver.findElements(By.cssSelector("a.box-images div.item-text"));
		List<WebElement> urls = driver.findElements(By.cssSelector("div.box-main a"));
		for (int i = 0; i < listItems.size(); ++i) {
			ReportUtils.logVerify(listItems.get(i).getText() + " - " + urls.get(i).getAttribute("href"));
			String url = urls.get(i).getAttribute("href");
			verifyLinks(url);
		}
	}

	public MyAccountPage clickMyAccount() {
		clickUsingJSExecutor(myAccount_by);
		return new MyAccountPage(driver);

	}

	public BuyersProtectionModal clickBuyersProtection() {
		clickUsingJSExecutor(buyersProtection_by);
		return new BuyersProtectionModal(driver);
	}

	public WhyChooseUsSection clickWhyChooseSection(String partialLinkText) {
		WebElement webElement = findElement(By.partialLinkText(partialLinkText));
		clickUsingJSExecutor(webElement);
		return new WhyChooseUsSection(driver);
	}

	public AllOurServicesPage clickAllOurServices() {
		clickUsingJSExecutor(allOurServices_by);
		return new AllOurServicesPage(driver);
	}

	/************ accessors ***************/

	public String getSelectedLanguage() {
		return website_switch.getText();
	}

	public String getSelectedCountry() {
		return country_switch.getText();
	}

	public String getSelectedCurrency() {
		return currency_switch.getText();
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

	/************* helpers ******************/

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				Reporter.log(linkUrl + " - " + httpURLConnect.getResponseMessage() + "<font color='red'>IS A BROKEN LINK...</font>");
			}

			// Fetching and Printing the response code obtained
			else {
				ReportUtils.logVerify(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}
}