package com.testngtutorial.MyTestNGTutorial.utilities;

import org.apache.log4j.Logger;

import com.testngtutorial.MyTestNGTutorial.runner.Runner;

public class ShutdownHookAdder {
	
	public void attachShutDownHook(){
		  Runtime.getRuntime().addShutdownHook(new Thread() {
		   @Override
		   public void run() {
			   Logger LOG = Logger.getLogger(Runner.class);
			   LOG.info("Shutdown hook initiated");
		   }
		  });
	}
}
