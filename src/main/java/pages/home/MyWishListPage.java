package pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import framework.CommonPage;

public class MyWishListPage extends CommonPage {

	public MyWishListPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	@FindBy(css = ".page-title")
	WebElement pageTitle_by;
	
	@FindBy(css = "div.actions-secondary a.btn-remove.action.delete")
	WebElement removeItem_by;

	/************ actions ***************/
	
	public void removeItemFromWishList() {
		click(removeItem_by);
		waituntilPageLoads();
	}

	/************ validations ***************/
	
	public boolean isMyWishListPageDisplayed() {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().equals("My Wish List");
	}
}
