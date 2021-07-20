package framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestDocumentation {
	
	// The Description annotation is for a detailed description or objective of the test.
		String TestNumber() default "";

	// The Description annotation is for a detailed description or objective of the test.
	String Coverage() default "";

	// The Create Date is the date that the test was introduced to the CI builds.
	// Note: Use the format "DD/MM/YYYY"
	String CreateDate() default "";
}