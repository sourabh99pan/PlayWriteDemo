package com.playwright.olympia;

import java.nio.file.Paths;
import java.util.*;
import org.testng.annotations.Test;

import com.playwrite.base.TestBase;
import com.playwrite.pages.OlympiaFileNBarPage;
import com.playwrite.pages.OlympiaLisePage;

public class FileandBarCheck extends TestBase {
	OlympiaFileNBarPage olympiaFileNBarpage;

	@Test(enabled=false)
	public void TC013() throws InterruptedException {

		olympiaFileNBarpage = new OlympiaFileNBarPage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaFileNBarpage.checkGraphVisible("bar");

	}

	@Test(enabled=false)
	public void TC014() throws InterruptedException {

		olympiaFileNBarpage = new OlympiaFileNBarPage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaFileNBarpage.clickPerform("Chart");
		ArrayList<String> alist = new <String>ArrayList(
		Arrays.asList("bar", "line", "pie", "doughnut", "polarArea", "radar"));
		olympiaFileNBarpage.checkGraphVisible(alist);

	}
	
	@Test
	public void TC015() throws InterruptedException {

		olympiaFileNBarpage = new OlympiaFileNBarPage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaFileNBarpage.clickPerform("File");
		page.waitForSelector("//span[text()='Choose']");
		olympiaFileNBarpage.chooseAndUploadFile("TC_001.png");

	}
	
	@Test(enabled=false)
	public void TC016() throws InterruptedException {

		olympiaFileNBarpage = new OlympiaFileNBarPage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaFileNBarpage.clickPerform("File");
		page.waitForSelector("//span[text()='Choose']");
		olympiaFileNBarpage.chooseAndUploadFile("TC_001.png");
		olympiaFileNBarpage.removefile();

	}

}
