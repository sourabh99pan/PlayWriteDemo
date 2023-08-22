package com.playwrite.pages;

import com.microsoft.playwright.Page;

public class OlympiaTablePage {

	Page page;
	
	private String searchBox = "//input[@placeholder='Search Keyword']";
	
	//Page constructor
	
	public OlympiaTablePage(Page page)
	{
		this.page=page;
	}
	
	public void searchName(String name)
	{
		page.fill(searchBox, name);
		page.waitForLoadState();
		page.focus(searchBox);
		page.keyboard().press("Enter");
		
		
	}
	
}
