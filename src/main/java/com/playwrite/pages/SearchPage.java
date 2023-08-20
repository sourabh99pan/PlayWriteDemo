package com.playwrite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchPage {
	
	Page page;
	
	public String product = "//a[normalize-space()='*']";
	
	public String openProduct = "//h1[normalize-space()='*']";
	
	public String productPrice = "//h2[normalize-space()='*']";
	
	public String addTocartBtn = "//button[@id='*']";
	
	public String successMsg="//div[@class='alert alert-success alert-dismissible']";
	
	public SearchPage(Page page)
	{
		this.page=page;
	}
	
	public boolean isProductPresent(String productName)
	{
		return page.isVisible(product.replace("*", productName));
	}
	
	public void openProduct(String productName)
	{
		page.hover(product.replace("*", productName.trim()));
		page.click(product.replace("*", productName.trim()));

	}
	
	public void checkProductDetails(String name, String price)	
	{
		page.waitForLoadState();
		boolean namePresent = page.isVisible(openProduct.replace("*", name));
		 Assert.assertEquals(namePresent, true,"The name is not present");
		 
		boolean pricePresent = page.isVisible(productPrice.replace("*", price));
		 Assert.assertEquals(pricePresent, true,"The price is not present");

	}
	
	public void addToCart()	
	{
		page.click(addTocartBtn.replace("*", "button-cart"));
		page.focus(successMsg);
		boolean msgvisible =page.isVisible(successMsg);
		Assert.assertEquals(msgvisible,true,"Success message is not displaying");

	}
	
}
