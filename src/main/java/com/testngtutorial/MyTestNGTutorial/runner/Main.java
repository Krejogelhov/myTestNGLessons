package com.testngtutorial.MyTestNGTutorial.runner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import static java.util.concurrent.TimeUnit.*;

public class Main {

	public static void main(String[] args) {
		addThreadsToPool();
	}

	private static void addThreadsToPool() {
		
		ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(3);
		eventPool.schedule(new Runner(), 0, SECONDS);
		eventPool.schedule(new ExpandedRunner(), 10, SECONDS);
		
	}

}
