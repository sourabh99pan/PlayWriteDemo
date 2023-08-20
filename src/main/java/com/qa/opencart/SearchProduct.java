package com.qa.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.microsoft.playwright.Page;
import com.playwrite.pages.SearchPage;

import org.testng.Assert;

public class SearchProduct {
	
	SearchPage searchPage;
	Page page;
	
	public SearchProduct(Page page)
	{
		this.page=page;
	}
	

}
