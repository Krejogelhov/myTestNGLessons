package com.testngtutorial.MyTestNGTutorial.logger;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MyAppender extends AppenderSkeleton {

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean requiresLayout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void append(LoggingEvent event) {
		// TODO Auto-generated method stub
		
	}

}
