package reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;

import utils.ReportUtils;

public class TestListener implements ITestListener {


	public void onStart(ITestContext context) {
		ReportUtils.logStep("*** Test Suite " + context.getName() + " started ***");
//		ExtentTestManager.getTest().log(Status.INFO, "*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		ReportUtils.logStep(("*** Test Suite " + context.getName() + " ending ***"));
//		ExtentTestManager.getTest().log(Status.INFO, "*** Test Suite " + context.getName() + " ending ***");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		ReportUtils.logStep(("*** Running test method " + result.getMethod().getMethodName() + "..."));
//		ExtentTestManager.getTest().log(Status.INFO, "*** Running test method " + result.getMethod().getMethodName() + "...");
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		ReportUtils.logStep("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		ReportUtils.logStep("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		ReportUtils.logStep("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ExtentTestManager.getTest().log(Status.INFO, "*** Test failed but within percentage % " + result.getMethod().getMethodName());
		ReportUtils.logStep("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
	
//	public void onTestFailure(ITestResult result) {
//		log.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
//		log.info((result.getMethod().getMethodName() + " failed!"));
//
//		ITestContext context = result.getTestContext();
//		WebDriver driver = (WebDriver) context.getAttribute("driver");
//
//		String targetLocation = null;
//
//		String testClassName = getTestClassName(result.getInstanceName()).trim();
//		String timeStamp = Util.getCurrentTimeStamp(); // get timestamp
//		String testMethodName = result.getName().toString().trim();
//		String screenShotName = testMethodName + timeStamp + ".png";
//		String fileSeperator = System.getProperty("file.separator");
//		String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
//				+ "screenshots";
//		log.info("Screen shots reports path - " + reportsPath);
//		try {
//			File file = new File(reportsPath + fileSeperator + testClassName); // Set
//																				// screenshots
//																				// folder
//			if (!file.exists()) {
//				if (file.mkdirs()) {
//					log.info("Directory: " + file.getAbsolutePath() + " is created!");
//				} else {
//					log.info("Failed to create directory: " + file.getAbsolutePath());
//				}
//
//			}
//
//			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;// define
//																											// location
//			File targetFile = new File(targetLocation);
//			log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
//			log.info("Target File location - " + targetFile.getAbsolutePath());
//			FileHandler.copy(screenshotFile, targetFile);
//
//		} catch (FileNotFoundException e) {
//			log.info("File not found exception occurred while taking screenshot " + e.getMessage());
//		} catch (Exception e) {
//			log.info("An exception occurred while taking screenshot " + e.getCause());
//		}
//
//		// attach screenshots to report
//		try {
//			ExtentTestManager.getTest().fail("Screenshot",
//					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
//		} catch (IOException e) {
//			log.info("An exception occured while taking screenshot " + e.getCause());
//		}
//		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
//	}

}