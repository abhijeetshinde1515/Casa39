package pages.catalogue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import framework.CommonPage;
import utils.GeneratorUtils;

public class ProductDescriptionPage extends CommonPage {

	public ProductDescriptionPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
		hardWait(5000);
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
	
	@FindBy(id = "flooring_qty")
	WebElement flooringQty_by;
	
	@FindBy(id = "product-addtocart-button")
	WebElement addToCart_by;
	
	@FindBy(id = "product-askdiscount-button")
	WebElement askForDisount_by;
	
	@FindBy(css = "div.section-title")
	WebElement sectionTitle;
	
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
	
	@FindBy(xpath = "//*[@id=\"inputName\"]")
	WebElement companyName_by;
	
	@FindBy(id = "inputEmail")
	WebElement email_by;
	
	@FindBy(xpath = "//*[@id=\"flooring_input_crm\"]")
	WebElement quantityForm_by;
	
	@FindBy(id = "inputZip")
	WebElement zip_by;
	
	@FindBy(id = "inputCountry")
	WebElement country_by;
	
	@FindBy(id = "message")
	WebElement message_by;
	
	@FindBy(css = "#weclap-offer-form .button.button")
	WebElement submitButton_by;
	
	@FindBy(css = "div.alert")
	WebElement successMessage_by;
	
	@FindBy(xpath = "//*[@id=\"block-title-button\"]/strong")
	WebElement review_by;
	
	@FindBy(css = "#review-form button.action.submit.primary")
	WebElement submitReviewButton_by;
	
	@FindBy(id = "product-addtoquote")
	WebElement addToQuote_by;
	
	@FindBy(id = "flooring_input")
	WebElement flooringInput_by;
	
	@FindBy(id = "attribute224")
	WebElement dimention_by;
	
	@FindBy(id = "attribute225")
	WebElement version_by;
	
	@FindBy(css = "div.brand-description")
	WebElement manufacturerDetails_by;
	
	@FindBy(id = "productprice")
	WebElement productPrice_by;
	
	@FindBy(id = "productcost")
	WebElement productCost_by;
	
	@FindBy(id = "sku")
	WebElement sku_by;
	
	@FindBy(id = "estimated_shipping")
	WebElement estimatedShipping_by;
	
	@FindBy(id = "language")
	WebElement language_by;
	
	
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
		sendKeys(quantity_by, quantity);
	}
	
	public void selectFlooringQtyAs(String quantity) {
		flooringQty_by.clear();
		sendKeys(flooringQty_by, quantity);
	}
	
	public void selectGroupQuantityAs(String quantity) {
		List<WebElement> group = driver.findElements(By.cssSelector("input.input-text.qty.txt"));
		for (int i = 0; i < group.size(); ++i) {
			group.get(i).clear();
			group.get(i).sendKeys(quantity);
			
		}
	}
	
	public void selectIncreaseQuantityPerMeters() {
		logStep("Increase Quantity using Meters (+)");
		List<WebElement> listItems = driver.findElements(By.cssSelector("a.qty-plus.btn.btn-default"));
			clickUsingJSExecutor(listItems.get(1));
			waituntilPageLoads();
	}
	
	public void selectReduceQuantityPerMeters() {
		logStep("Reduce Quantity using Meters (-)");
		List<WebElement> listItems = driver.findElements(By.cssSelector("a.qty-minus.btn.btn-default"));
			clickUsingJSExecutor(listItems.get(1));
			waituntilPageLoads();
	}
	
	public void selectIncreaseQuantityPerBoxes() {
		logStep("Increase Quantity using Boxes (+)");
		List<WebElement> listItems = driver.findElements(By.cssSelector("a.qty-plus.btn.btn-default"));
			clickUsingJSExecutor(listItems.get(2));
			waituntilPageLoads();
	}
	
	public void selectReduceQuantityPerBoxes() {
		logStep("Reduce Quantity using Boxes (-)");
		List<WebElement> listItems = driver.findElements(By.cssSelector("a.qty-minus.btn.btn-default"));
		clickUsingJSExecutor(listItems.get(2));
			waituntilPageLoads();
	}
	
	public InformationModal clickAddToCart() {
		clickUsingJSExecutor(addToCart_by);
		return new InformationModal(driver);
	}
	
	public void clickAskForDiscount() {
		clickUsingJSExecutor(askForDisount_by);
	}
	
	public void setCompanyName(String companyName) {
		sendKeys(companyName_by, companyName);
	}
	
	public void setEmail() {
		sendKeys(email_by, GeneratorUtils.generateUniqueEmail());
	}
	
	public void setFormQuantity(String quantity) {
		 sendKeys(quantityForm_by, quantity);
	}
	
	public void setZip(String zip) {
		sendKeys(zip_by, zip);
	}
	
	public void setMessage(String message) {
		sendKeys(message_by, message);
	}
	
	public void submitForm() {
		clickUsingJSExecutor(submitButton_by);
		waituntilPageLoads();
	}
	
	public void setCountry(String country)  {
		Reporter.log("Select Option As - "+country);
		Select sortOptions = new Select(country_by);
		sortOptions.selectByVisibleText(country);
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
		WebElement radioBtn = findElement(By.id("Vote_"+rating));
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
		clickUsingJSExecutor(submitReviewButton_by);
		waituntilPageLoads();
	}
	
	public void clickWriteYourOwnReview() {
		waituntilPageLoads();
		clickUsingJSExecutor(review_by);
	}
	
	public InformationModal clickAddToQuote() {
		clickUsingJSExecutor(addToQuote_by);
		return new InformationModal(driver);
	}
	
	public void setDimension(String dimention)  {
		logStep("Select Dimention As - "+dimention);
		Select sortOptions = new Select(dimention_by);
		sortOptions.selectByVisibleText(dimention);
		waituntilPageLoads();
	}
	
	public void setVersion(String version)  {
		logStep("Select Dimention As - "+version);
		Select sortOptions = new Select(version_by);
		sortOptions.selectByVisibleText(version);
		waituntilPageLoads();
	}
	
	/************ accessors ***************/

	public boolean getProductPrice(String productPrice) {
		return productPrice_by.getAttribute("value").contains(productPrice);
	}
	
	public boolean getSKU(String sku) {
		return sku_by.getAttribute("value").contains(sku);
	}
	
	public boolean getProductCost(String productCost) {
		return productCost_by.getAttribute("value").contains(productCost);
	}
	
	public boolean getEstimatedShipping(String estimatedShipping) {
		return estimatedShipping_by.getAttribute("value").contains(estimatedShipping);
	}
	
	public boolean getLanguage(String language) {
		return language_by.getAttribute("value").contains(language);
	}

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
	
	public String getSuccessMessage() {
		return successMessage_by.getText();
	}
	
	public boolean getQuantityInSquares(String quantitySqaures) {
		return flooringInput_by.getAttribute("value").contains(quantitySqaures);
	}
	
	public boolean getQuantityInBoxes(String  flooringQuantityBoxes) {
		return flooringQty_by.getAttribute("value").contains(flooringQuantityBoxes);
	}

	public boolean getSpecificationDetails(String specification) {
		List<WebElement> listItems = driver.findElements(By.cssSelector("span.col.data"));
		for (WebElement listItem : listItems) {
			if(listItem.getText().contains(specification)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean getManufacturerDetails(String details) {
		return manufacturerDetails_by.getText().contains(details);
	}
	
	/************ validations *************/

	public boolean isProductNameDisplayed(String productName) {
		return pageTitle_by.isDisplayed() && pageTitle_by.getText().equals(productName);
	}
	
	public boolean validateReviewingProductNameAs(String productName) {
		return reviewItemName_by.isDisplayed() && reviewItemName_by.getText().contains(productName);
	}
	
	public boolean validateSectionTitle() {
		return sectionTitle.isDisplayed() && sectionTitle.getText().contains("You're one step away from the additional discount!");
	}
}
