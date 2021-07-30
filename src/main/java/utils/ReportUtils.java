package utils;

import org.testng.Reporter;
import com.aventstack.extentreports.Status;
import reports.ExtentTestManager;

public class ReportUtils {
	
	public static String logVerify(String string) {
		ExtentTestManager.getTest().log(Status.PASS, "Verified - "+string);
		Reporter.log("Verified - "+string, true);
		return null;
	}
	
	public static String logStep(String string) {
		Reporter.log("STEP - "+string, true);
		return null;
	}
}


