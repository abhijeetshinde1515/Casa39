package utils;

import org.testng.Reporter;

public class ReportUtils {
	
	public static String logVerify(String string) {
		Reporter.log("Verified - "+string, true);
		return null;
	}
	
	public static String logStep(String string) {
		Reporter.log("STEP - "+string, true);
		return null;
	}
}


