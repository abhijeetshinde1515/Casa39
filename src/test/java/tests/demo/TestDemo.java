package tests.demo;

import org.testng.annotations.Test;
import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;

public class TestDemo extends TestNGBaseTest {

	@Test()
	public void testAutomationSetUpForCasa39English() throws Exception {
		
		logStep("Check connection to Casa39 English Website...");
		navigateToCasa39Website(false);
		assertEquals(driver.getTitle(), TestData.casa39English_HomepageTitle, "Connection Established Successfully...");
		closeBrowser();
	}
}
