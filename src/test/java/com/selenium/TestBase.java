package com.selenium;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public final static String configFilePath  = "Config//Config.properties";
	public static Properties prop;
	public static Browser browser;
	public static Page page;
	public static Playwright playwright;
	public static BrowserContext context;
	
	public static void configReader()
	{
		BufferedReader reader;
		System.out.println("in config reader "+configFilePath);
		
		try
		{
			reader = new BufferedReader(new FileReader(configFilePath));
			prop = new Properties();
			try
			{
				prop.load(reader);
				reader.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Config.properties file not found at: "+configFilePath);
		}
	}

	public static void selectBrowser(String sbrowser)
	{
		if(sbrowser.equalsIgnoreCase("chromium"))
		{	
			 playwright=Playwright.create();
	        //try (playwrite = Playwright.create()) {
	            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	             context = browser.newContext();
	            context.tracing().start(new Tracing.StartOptions()
	            		  .setScreenshots(true)
	            		  .setSnapshots(true)
	            		  .setSources(true));
	             page = context.newPage();
	             
	             
			//}
		}
	        else if(sbrowser.equalsIgnoreCase("firefox"))
	        {
		       // try (playwrite = Playwright.create()) {
	        	playwright=Playwright.create();
		            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		             context = browser.newContext();
		            context.tracing().start(new Tracing.StartOptions()
		            		  .setScreenshots(true)
		            		  .setSnapshots(true)
		            		  .setSources(true));
		            page = context.newPage();
		        //}
	        }
		//return page;
	}
	
	public static void setupUrl() throws Exception
	{
		configReader();
		
		selectBrowser(prop.getProperty("browser"));
	}
	
	@BeforeTest
	public void initializeTest() throws Exception
	{

		BufferedReader reader;
		
		try
		{
			reader = new BufferedReader(new FileReader(configFilePath));
			prop = new Properties();
			try
			{
				prop.load(reader);
				reader.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Config.properties file not found at: "+configFilePath);
		}
		
		setupUrl();
		//report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		//test = report.startTest("ExtentDemo");
	}

	@AfterTest
	public void tearDown()
	{
		context.tracing().stop(new Tracing.StopOptions()
				  .setPath(Paths.get("trace.zip")));
		browser.close();
		playwright.close();
	}
}