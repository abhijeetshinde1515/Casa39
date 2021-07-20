package baseTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.home.HomePage;
import utils.AssertUtil;
import utils.ReportUtils;

public class TestNGBaseTest extends AssertUtil {

	protected RemoteWebDriver driver;
	
	public HomePage navigateToCasa39Website(boolean keepBrowserOpen) {
		
		logStep("Launch Browser Successfully...");
		
		if(keepBrowserOpen) {
			System.setProperty("webdriver.chrome.driver", TestData.driver_location);
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			logStep("Navigate to Casa39 English Website Home Page.");
			driver.get(TestData.casa39_English_url);
			acceptCookies();
		}else {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu");
			options.addArguments("window-size=1280x768");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver", TestData.driver_location);
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			logStep("Navigate to Casa39 English Website Home Page.");
			driver.get(TestData.casa39_English_url);
			acceptCookies();
		}
		
		return new HomePage(driver);
	}
	
	public void acceptCookies() {
		logStep("Accepting Cookies...");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.cc-btn.cc-dismiss"))).click();
	}
	public void closeBrowser() {
		logStep("Closing Browser Successfully...");
		driver.quit();
	}

	public void logStep(String logs) {
		ReportUtils.logStep(logs);
	}
}