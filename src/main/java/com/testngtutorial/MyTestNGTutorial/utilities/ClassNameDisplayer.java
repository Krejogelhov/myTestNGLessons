
package com.testngtutorial.MyTestNGTutorial.utilities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface ClassNameDisplayer{
	
	
	//public static String className = Thread.currentThread().getStackTrace()[1].getClassName();

}
