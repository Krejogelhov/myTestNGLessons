package com.testngtutorial.MyTestNGTutorial.utilities;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.testngtutorial.MyTestNGTutorial.utilities.DriverFactory.BrowserType;

public class CLIParser {
	
	public static BrowserType parse(Options options) {
		CommandLineParser parser = new DefaultParser();
		BrowserType type = null;
		try {
			CommandLine cmd = parser.parse(options, null);
			if(cmd.hasOption("c")) {
				type = BrowserType.valueOf("CHROME");
			}
			else {
				type = BrowserType.valueOf("FIREFOX");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}

}
