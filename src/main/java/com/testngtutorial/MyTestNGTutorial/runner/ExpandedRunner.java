package com.testngtutorial.MyTestNGTutorial.runner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import com.testngtutorial.MyTestNGTutorial.tests.LoginTest;
import com.testngtutorial.MyTestNGTutorial.utilities.ClassNameDisplayer;
import com.testngtutorial.MyTestNGTutorial.utilities.ShutdownHookAdder;

public class ExpandedRunner implements Runnable{
	
	final static Logger LOG = Logger.getLogger(ExpandedRunner.class);

	@Override
	public void run() {
		
		TestNG tng = new TestNG();
        
        String name = null;
        
        Class<LoginTest> obj = LoginTest.class;
        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(ClassNameDisplayer.class)) {
                name = obj.getName();
            }
        }
        LOG.info("Name of the class is " + name);
        
        //ExecutorService service = Executors.newCachedThreadPool();
        
        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");
        List<String> files = new ArrayList<String>();
        files.addAll(new ArrayList<String>() {{
        	add("./testng2.xml");
        }});
        suite.setSuiteFiles(files);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        tng.setXmlSuites(suites);     
        
        tng.run();
        LOG.info("TestNG runner is working");
        ShutdownHookAdder hookAdder = new ShutdownHookAdder();
        hookAdder.attachShutDownHook();       
	}

}
