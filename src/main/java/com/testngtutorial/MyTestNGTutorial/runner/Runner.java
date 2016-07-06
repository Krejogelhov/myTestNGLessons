package com.testngtutorial.MyTestNGTutorial.runner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import com.testngtutorial.MyTestNGTutorial.tests.LoginTest;
import com.testngtutorial.MyTestNGTutorial.utilities.ClassNameDisplayer;

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
        
		String[] arguements = args;
		String name = null;
        TestNG tng = new TestNG();
        Class<LoginTest> obj = LoginTest.class;

        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(ClassNameDisplayer.class)) {
                name = obj.getName();
            }
        }
        LOG.info("Name of the class is " + name);

        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");
        List<String> files = new ArrayList<String>();
        files.addAll(new ArrayList<String>() {{
            //add("./src/main/resources/testng.xml");
        	add("./testng2.xml");
        }});
        suite.setSuiteFiles(files);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        tng.setXmlSuites(suites);
        tng.run();
        LOG.info("TestNG runner is working");
        
    }

}
