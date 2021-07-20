package utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *Generate Unique Names
 */
public class GeneratorUtils {

	public static String generateUniqueId(String prefix) {
		return prefix + "_" + generateUniqueId();
	}

	public static String generateUniqueId() {
		SimpleDateFormat format = new SimpleDateFormat("MMddkkmmssSSS");
		return format.format(new Date());
	}
	
	public static String generateUniqueEmail() {
		return "email_" + generateUniqueId() + "@test.com";
	}
}
