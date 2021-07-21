package utils;

/**
 *
 */
public class AssertUtil extends ReportUtils {

	/* TRUE */
	public static void assertTrue(boolean condition, String message) {
		org.testng.Assert.assertTrue(condition, ReportUtils.logVerify(message));
	}

	public static void assertEquals(String actual, String expected, String message) {
		org.testng.Assert.assertEquals(actual, expected, ReportUtils.logVerify(message));
	}
}
