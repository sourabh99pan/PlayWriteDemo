package com.playwright.report;

import java.util.HashMap;

import com.aventstack.extentreports.ExtentReports;
import java.util.Map;

import com.aventstack.*;


public class ExtentReportManager {
	
	/** The extent reports. */
	/*private static ExtentReports extentReports;

	/** The map. */
	//private static Map<Long, ExtentTest> map = new HashMap<>();

	/**
	 * Gets the extent reports.
	 *
	 * @return the extent reports
	 */
	/*public static ExtentReports getExtentReports() {
		if (extentReports == null) {
			extentReports = new ExtentReports(Constants.REPORT_DIRECTORY);
			extentReports.assignProject(Constants.PROJECT_NAME);
			extentReports.loadConfig(new File(Constants.EXTENT_CONFIG_PATH));
		}
		return extentReports;
	}

	/**
	 * Start test.
	 *
	 * @param testName the test name
	 * @param desc the desc
	 */


}
