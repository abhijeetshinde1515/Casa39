package pages.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import framework.CommonPage;

public class MyOrdersPage extends CommonPage {
	
	public MyOrdersPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	/************ actions ***************/
	
	/************ accessors ***************/
	
	/************ validations ***************/
	
	public boolean isProductNameDisplayed(String productName) {
		List<WebElement> orders = driver.findElements(By.cssSelector("strong.product.name.product-item-name"));
		for (WebElement listItem : orders)
			if (listItem.getText().contains(productName)) {
				break;
			}
		return true;
	}
	
	public boolean isOrderDetailsDisplayed(String orderDetail) {
		List<WebElement> orders = driver.findElements(By.cssSelector("dl.item-options dd"));
		for (WebElement listItem : orders)
			if (listItem.getText().contains(orderDetail)) {
				break;
			}
		return true;
	}
	
	public boolean isOrderDetailsSKUDisplayed(String skuDetail) {
		List<WebElement> orders = driver.findElements(By.cssSelector("td.col.sku"));
		for (WebElement listItem : orders)
			if (listItem.getText().contains(skuDetail)) {
				break;
			}
		return true;
	}

	public boolean isOrderPriceDetailsDisplayed(String price) {
		List<WebElement> orders = driver.findElements(By.cssSelector("span.cart-price"));
		for (WebElement listItem : orders)
			if (listItem.getText().contains(price)) {
				break;
			}
		return true;
	}
	
	public boolean isOrderQuantityDetailsDisplayed(String qty) {
		List<WebElement> orders = driver.findElements(By.cssSelector("span.content"));
		for (WebElement listItem : orders)
			if (listItem.getText().contains(qty)) {
				break;
			}
		return true;
	}
	
	public boolean isOrderPriceSummaryDetailsDisplayed(String price) {
		List<WebElement> orders = driver.findElements(By.cssSelector("span.price"));
		for (WebElement listItem : orders)
			if (listItem.getText().contains(price)) {
				break;
			}
		return true;
	}
}