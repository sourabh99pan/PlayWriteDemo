package com.playwrite.pages;

import com.microsoft.playwright.Page;

public class OlympiaLisePage {
	
	Page page;
	
	public String listOption = "//span[contains(@class,'layout-menuitem-text ng-tns-') and text()='List' ]";
	
	public String countrySelect = "(//div[@class='ng-star-inserted'][normalize-space()='*'])[1]";
	
	public String selectButton = "//div[@class='p-picklist-buttons p-picklist-transfer-buttons']//button[1]";
	
	public String insertedCountry = "(//div[@class='ng-star-inserted'][normalize-space()='*'])[1]";
	
	//Page constructor
	
	public OlympiaLisePage(Page page)
	{
		this.page=page;
	}
	
	public void dragAndDrop(String country)
	{

		page.click(countrySelect.replace("*", country));
		page.click(selectButton);
		
	}
	
	public void clickOption()
	{
		page.click(listOption);
	}
	
	public void verifyCountry(String country)
	{
		page.isVisible(insertedCountry.replace("*", country));
	}
	

}
