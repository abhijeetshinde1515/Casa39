package pages.catalogue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import framework.CommonPage;
import utils.ReportUtils;

public class ProductSorterFunction extends CommonPage {

	public ProductSorterFunction(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(partialLinkText = "Grid")
	WebElement gridSort_by;
	
	@FindBy(partialLinkText= "List")
	WebElement listSort_by;
	
	@FindBy(id = "sorter")
	WebElement sortBySelect_by;
	
	@FindBy(id = "limiter")
	WebElement limitSelect_by;
	
	@FindBy(css= ".sort-desc")
	public static WebElement descendingOrder_by;
	
	
	@FindBy(css= ".sort-asc")
	public static WebElement ascendingOrder_by;
	
	/************ actions ****************/
	
	public void viewAsGridSort() {
		click(gridSort_by);
		waituntilPageLoads();
	}
	
	public void viewAsListSort() {
		click(listSort_by);
		waituntilPageLoads();
	}

	public void sortByOptionAs(String option) {
		logStep("Select Sorting Option As - "+option);
		click(sortBySelect_by);
		Select sortOptions = new Select(sortBySelect_by);
		sortOptions.selectByValue(option);
		waituntilPageLoads();
		ReportUtils.logVerify("Selected Sorting Option As - "+option);
	}
	
	public void setShowProductsPerPage(String limit) {
		logStep("Select Products Per Page As - "+limit);
		Select sortOptions = new Select(limitSelect_by);
		sortOptions.selectByValue(limit);
		waituntilPageLoads();
		ReportUtils.logVerify("Select Products Per Page As - "+limit);
	}
	
	public void sortByAscendingOrder() {
		click(ascendingOrder_by);
		waituntilPageLoads();
	}
		
	public void sortByOrder() {
		if (descendingOrder_by.isDisplayed()) {
			clickUsingJSExecutor(descendingOrder_by);
		} else {
			clickUsingJSExecutor(ascendingOrder_by);
		}
		refreshPage();
	}
	
	public void applyFiltersOneByOne() {
		List<WebElement> listItems = driver.findElements(By.cssSelector("li.item a input"));
		for (WebElement listItem : listItems) {
			clickUsingJSExecutor(listItem);
				waituntilPageLoads();
			}
	}
	
	public void setPriceRange(String a, String b) {
		List<WebElement> listItems = driver.findElements(By.cssSelector("input.am-filter-price"));
		String limit = a;
		for (WebElement listItem : listItems) {
			listItem.clear();
			listItem.sendKeys(limit);
			limit = b;
		}
	}
}
