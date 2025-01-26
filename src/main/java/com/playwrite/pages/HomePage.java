package com.playwrite.pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Page;

public class HomePage {
	
	Page page;
	
	
	//String Locators

	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	
	//Page constructor changed
	
	public HomePage(Page page)
	{
		this.page=page;
	}
	
	//page actions/methods
	
	public String getHomePageTitle()
	{
		return page.title();
		
	}
	
	public String getHomePageURL()
	{
		return page.url();
	}
	
	public String doSearch(String productName)
	{
		page.fill(search, productName);
		page.click(searchIcon);
		page.locator(searchPageHeader).waitFor();
		String header = page.textContent(searchPageHeader);
		return header;
	}
	
	public SearchPage navigateToSearchResult()
	{
		return new SearchPage(page);
	}
}
