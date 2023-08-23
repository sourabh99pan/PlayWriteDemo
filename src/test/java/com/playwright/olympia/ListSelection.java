package com.playwright.olympia;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.playwrite.base.TestBase;
import com.playwrite.pages.OlympiaLisePage;
import com.playwrite.pages.OlympiaTablePage;

public class ListSelection extends TestBase{

	OlympiaLisePage olympiaListpage;
	
	@Test
	public void TC011() throws InterruptedException
	{
		
		olympiaListpage = new OlympiaLisePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));
		
		olympiaListpage.clickOption();
		olympiaListpage.dragAndDrop("Istanbul");
		olympiaListpage.verifyCountry("Istanbul");

		
		
	}
}
