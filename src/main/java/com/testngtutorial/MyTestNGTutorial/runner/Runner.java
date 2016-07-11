package com.testngtutorial.MyTestNGTutorial.runner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import com.testngtutorial.MyTestNGTutorial.tests.LoginTest;
import com.testngtutorial.MyTestNGTutorial.utilities.ClassNameDisplayer;
import com.testngtutorial.MyTestNGTutorial.utilities.ShutdownHookAdder;

public class Runner {
	
	final static Logger LOG = Logger.getLogger(Runner.class);
	
	/*

	public static void main(String[] args) {
		
		final TestNG testNG = new TestNG(true);
		  final Parser parser = new Parser("src/main/resources/testng.xml");
		  List<XmlSuite> suites = null;
		  try {
			  suites = parser.parseToList();
		  } catch (ParserConfigurationException | SAXException | IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		  testNG.setXmlSuites(suites);
		  testNG.run();
		  
	}
	*/
	public static void main(String[] args) {
        	
        TestNG tng = new TestNG();
        
        String name = null;
        
        Class<LoginTest> obj = LoginTest.class;
        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(ClassNameDisplayer.class)) {
                name = obj.getName();
            }
        }
        LOG.info("Name of the class is " + name);
        
        ExecutorService service = Executors.newCachedThreadPool();
        
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
