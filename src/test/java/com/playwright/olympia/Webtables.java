package com.playwright.olympia;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.playwrite.base.TestBase;
import com.playwrite.pages.HomePage;
import com.playwrite.pages.OlympiaTablePage;

public class Webtables extends TestBase{
	
	
	OlympiaTablePage olympiapage;
	
	@Test
	public void TC010() throws InterruptedException
	{
		
		olympiapage = new OlympiaTablePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));
		olympiapage.searchName("James Butt");
		Locator rows = page.locator("table#pr_id_1-table");
		page.waitForLoadState();
		ArrayList<String> userDetails = new ArrayList<String>();
		int size=page.locator("table#pr_id_1-table tr td").allInnerTexts().size();
		System.out.println(size);
		page.locator("table#pr_id_1-table tr td").allInnerTexts().forEach(e->userDetails.add(e));
		
		for(String e:userDetails)
		{
			System.out.println(e);
			
		}
		
		
	}
	


}
