package com.playwright.olympia;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.playwrite.base.TestBase;
import com.playwrite.pages.OlympiaLisePage;
import com.playwrite.pages.OlympiaTablePage;

public class ListSelection extends TestBase{

	OlympiaLisePage olympiaListpage;
	
	@Test(enabled=false)
	public void TC011() throws InterruptedException
	{
		
		olympiaListpage = new OlympiaLisePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));
		
		olympiaListpage.clickOption();
		olympiaListpage.dragAndDrop("Istanbul");
		olympiaListpage.verifyCountry("Istanbul");

		
		
	}
	
	@Test
	public void TC012() throws InterruptedException
	{
		
		olympiaListpage = new OlympiaLisePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));
		
		olympiaListpage.clickOption();
		ArrayList<String> countryList = new ArrayList<>(Arrays.asList("Istanbul","Paris","Berlin","Rome"));
		olympiaListpage.dragAndDrop(countryList);
		
		olympiaListpage.verifyCountry(countryList);
	
	}
}
