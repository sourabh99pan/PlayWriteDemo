package com.playwright.olympia;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.playwrite.base.TestBase;
import com.playwrite.pages.OlympiaMenuPage;

public class MenuCheck extends TestBase{
	
	OlympiaMenuPage olympiamenupage;
	
	@Test
	public void TC012() throws InterruptedException
	{
		
		olympiamenupage = new OlympiaMenuPage(page);
		page.navigate(prop.getProperty("olympiaUrl"));
		//page.pause();
		olympiamenupage.clickOption("Menu");
		olympiamenupage.clickMenu("Customers", "tieredMenu");
		olympiamenupage.clickMenu("New", "tieredsubMenu");
		//olympiamenupage.clickMenu("Customer", "tieredsubMenu");
		olympiamenupage.clickMenu("Orders", "tieredMenu");
		olympiamenupage.clickMenu("View", "tieredsubMenu");
		
		
		
		
	}

}
