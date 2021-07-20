package pages.catalogue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import framework.CommonPage;

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
	
	@FindBy(linkText= "Set Descending Direction")
	public static WebElement descendingOrder_by;
	
	
	@FindBy(linkText= "Set Ascending Direction")
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
		Reporter.log("Select Sorting Option As - "+option);
		click(sortBySelect_by);
		Select sortOptions = new Select(sortBySelect_by);
		sortOptions.selectByValue(option);
		waituntilPageLoads();
	}
	
	public void sortByAscendingOrder() {
		click(ascendingOrder_by);
		waituntilPageLoads();
	}
		
	public void sortByDescendingOrder() {
		click(descendingOrder_by);
		waituntilPageLoads();
	}
}
