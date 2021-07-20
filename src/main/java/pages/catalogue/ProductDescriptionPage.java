package pages.catalogue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.CommonPage;

public class ProductDescriptionPage extends CommonPage {

	public ProductDescriptionPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/

	@FindBy(css = ".page-title")
	WebElement pageTitle_by;

	@FindBy(id = "product-price-1562")
	WebElement itemPrice_by;

	@FindBy(css = ".swatch-option.text")
	WebElement size_by;

	@FindBy(id = "qty")
	WebElement quantity_by;
	
	@FindBy(id = "product-addtocart-button")
	WebElement addToCart_by;
	
	@FindBy(css = "a.action.towishlist span")
	WebElement addToWishList_by;
	
	@FindBy(css = "a.action.tocompare")
	WebElement addToCompare_by;
	
	@FindBy(id = "description")
	WebElement details_by;
	
	@FindBy(id = "additional")
	WebElement moreInformation_by;
	
	@FindBy(id = "customer-reviews")
	WebElement reviews_by;
	
	@FindBy(id = "tab-label-reviews-title")
	WebElement reviewsButton_by;
	
	@FindBy(css = "legend.review-legend")
	WebElement reviewItemName_by;
	
	@FindBy(id = "nickname_field")
	WebElement nickName_by;
	
	@FindBy(id = "summary_field")
	WebElement summary_by;
	
	@FindBy(id = "review_field")
	WebElement reviewText_by;
	
	@FindBy(css = "button.action.submit")
	WebElement submitReview_by;
	
	/************ actions *****************/

	public void selectSizeOptionAs(String sizeOption) {
		List<WebElement> sizes = driver.findElements(By.cssSelector(".swatch-option.text"));
		for (WebElement size : sizes)
			if (size.getText().equals(sizeOption)) {
				click(size);
				break;
			}
	}

	public void selectColorOptionAs(String colorOption) {
		List<WebElement> colorOptions = driver.findElements(By.cssSelector(".swatch-option.color"));
		for (WebElement chooseColor : colorOptions)
			if (chooseColor.getAttribute("data-option-label").equals(colorOption)) {
				click(chooseColor);
				break;
			}
	}

	public void selectQuantityAs(String quantity) {
		quantity_by.clear();
		quantity_by.sendKeys(quantity);
	}
	
	public void clickAddToCart() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addToCart_by)).click();
		waituntilPageLoads();
	}
	
	public void clickAddToWishList() {
		refreshPage();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addToWishList_by)).click();
		waituntilPageLoads();
	}
	
	public void clickAddToCompare() {
		refreshPage();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addToCompare_by)).click();
		addToCompare_by.click();
	}
	
	public CompareProductListPage clickCompareProducts() {
		click(findElement(By.partialLinkText("Compare Products")));
		return new CompareProductListPage(driver);
	}
	
	public void clickReviews() {
		reviewsButton_by.click();
	}
	
	public void setRating(int rating) {
		WebElement radioBtn = findElement(By.id("Rating_"+rating));
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn);
	}
	
	public void setNickName(String name) {
		nickName_by.sendKeys(name);
	}
	
	public void setSummary(String summary) {
		summary_by.sendKeys(summary);
	}
	
	public void setReview(String reviewContent) {
		reviewText_by.sendKeys(reviewContent);
	}
	
	public void clickSubmitReview() {
		click(submitReview_by);
		waituntilPageLoads();
	}
	
	/************ accessors ***************/

	public String getItemPrice() {
		return itemPrice_by.getText();
	}
	
	public String getItemDetails() {
		return details_by.getText();
	}
	
	public String getMoreInformation() {
		return moreInformation_by.getText();
	}
	
	public String getReviews() {
		return reviews_by.getText();
	}
	
	/************ validations *************/

	public boolean isProductNameDisplayed(String productName) {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().equals(productName);
	}
	
	public boolean validateReviewingProductNameAs(String productName) {
		return reviewItemName_by.isDisplayed() && reviewItemName_by.getText().contains(productName);
	}
}
