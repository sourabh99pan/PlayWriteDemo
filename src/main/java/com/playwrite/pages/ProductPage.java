package com.playwrite.pages;

import java.util.ArrayList;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
	
	Page page;
	
	public String option = "//span[contains(@class,'layout-menuitem-text ng-tns-') and text()='*' ]";
	
	public String newBtn = "//span[normalize-space()='New']";
	
	public String name = "//input[@id='name']";
	
	public String description = "//textarea[@id='description']";
	
	public String inventoryStatus = ".p-dropdown-label.p-inputtext.p-placeholder.ng-star-inserted";
	
	public String selectOption = "//span[@class='product-badge status-instock ng-star-inserted']";
	
	public String category = "//p-radiobutton[@id='*']//div[@class='p-radiobutton-box']";
	
	public String price ="(//input[@inputmode='decimal'])[1]";
	
	public String quantity ="(//input[@inputmode='decimal'])[2]";
	
	public String saveBtn = "//span[normalize-space()='Save']";
	
	public String searchBox = "//input[@placeholder='Search...']";
	
	public String editDeleteBtn = "(//button[contains(@class,'p-element p-ripple p-button-rounded ')])[*]";
	
	public String confirmBtn = "//span[normalize-space()='*']";
	
	public String paginatorText = "//span[@class='p-paginator-current ng-star-inserted']";
	
	//Page constructor
	
	public ProductPage(Page page)
	{
		this.page=page;
	}
	
	public void clickOption(String optionClick)
	{
		page.click(option.replace("*", optionClick));
	}
	
	public void createProduct()
	{
		page.click(newBtn);
		page.fill(name, "Test");
		page.fill(description,"Test Desc");
		//Locator selectStatus = page.locator(inventoryStatus);
		//selectStatus.selectOption("INSTOCK");
		page.click(inventoryStatus);
		page.click(selectOption);
		page.click(category.replace("*", "category1"));
		page.fill(price, "21");
		page.fill(quantity, "1");
		page.click(saveBtn);
		page.fill(searchBox, "Test");

		
		Locator rows = page.locator("//table[@class='p-datatable-table ng-star-inserted']//tr");
		System.out.println(rows);
		
		boolean record = rows.locator(":scope",new Locator.LocatorOptions().setHasText("Test")).isVisible();//imp step
		System.out.println(rows.count());
		System.out.println(record);
		//Assert.assertEquals(record, true);

	}
	
	public void deleteProduct(String productName)
	{
		page.fill(searchBox, productName);
		Locator rows = page.locator("//table[@class='p-datatable-table ng-star-inserted']//tr");
		rows.locator(":scope",new Locator.LocatorOptions().setHasText(productName)).locator(".p-checkbox-box.p-component").click();
		page.click(editDeleteBtn.replace("*", "2"));
		page.click(confirmBtn.replace("*", "Yes"));
		page.fill(searchBox, productName);
		String textAfterDelete = page.textContent(paginatorText);
		Assert.assertTrue(textAfterDelete.contains("0 to 0 of 0 entries"));
				
	}

}
