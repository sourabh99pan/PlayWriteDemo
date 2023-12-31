package com.playwrite.pages;

import java.util.*;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.playwright.utils.ExcelUtils;

public class OlympiaLisePage {

	Page page;

	public String listOption = "//span[contains(@class,'layout-menuitem-text ng-tns-') and text()='List' ]";

	public String countrySelect = "(//div[@class='ng-star-inserted'][normalize-space()='*'])[1]";

	public String selectButton = "//div[@class='p-picklist-buttons p-picklist-transfer-buttons']//button[1]";

	public String insertedCountry = "(//div[@class='ng-star-inserted'][normalize-space()='*'])[1]";

	public String paginationNumber = "//button[normalize-space()='*']";

	public String searchBox = "//input[@placeholder='Search by Name']";
	
	public String productOnList = "//div[normalize-space()='*']";
	
	public String priceOnList = "//span[normalize-space()='*']";
	
	public String isAvailable = "//span[contains(@class,'product-badge sm:ml-2 status')]";
	
	public String productCategory = "//span[@class='font-semibold']";
	
	// Page constructor

	public OlympiaLisePage(Page page) {
		this.page = page;
	}

	public void dragAndDrop(String country) {

		page.click(countrySelect.replace("*", country));
		page.click(selectButton);

	}

	public void clickOption() {
		page.click(listOption);
	}

	public void verifyCountry(String country) {
		page.isVisible(insertedCountry.replace("*", country));
	}

	public void dragAndDrop(List<String> country) {
		for (String c : country) {
			page.click(countrySelect.replace("*", c));
			page.click(selectButton);
		}
	}

	public void verifyCountry(List<String> country) {
		for (String c : country) {
			page.isVisible(insertedCountry.replace("*", c));
		}
	}

	public void clickPagination() {

		int count = 1;
		page.waitForSelector(paginationNumber.replace("*", Integer.toString(count).replace("['\']", "")));
		System.out.println(page.isVisible(paginationNumber.replace("*", Integer.toString(count).replace("['\']", ""))));

		while (page.isVisible(paginationNumber.replace("*", Integer.toString(count)))) {
			// page.pause();
			page.click(paginationNumber.replace("*", Integer.toString(count)));
			count++;
		}

	}
	
	public void searchProduct(String productName, String price)
	{
		page.fill(searchBox, productName);
		Assert.assertEquals(page.isVisible(productOnList.replace("*", productName)), true);
		Assert.assertEquals(page.isVisible(priceOnList.replace("*", price)), true);

	}
	
	public void searchProduct(HashMap<String, String> productDet)
	{
		for(Map.Entry<String, String> en:productDet.entrySet())
		{
			page.fill(searchBox, en.getKey());
			Assert.assertEquals(page.isVisible(productOnList.replace("*", en.getKey())), true,en.getKey()+"Product name not match");
			Assert.assertEquals(page.isVisible(priceOnList.replace("*", en.getValue())), true,en.getKey()+" "+en.getValue()+"Price does not match");
			page.fill(searchBox, " ");
			
		}
	}
	
	public void searchAndValidateProduct(String key) throws Exception
	{
		Map<String,String> dataMap = new HashMap<String, String>();
		page.fill(searchBox, key);
		dataMap = ExcelUtils.getData(key);
		Assert.assertEquals(page.isVisible(productOnList.replace("*", dataMap.get("Name"))), true,dataMap.get("Name")+"Product name not match");
		Assert.assertEquals(page.isVisible(priceOnList.replace("*", dataMap.get("Price"))), true,dataMap.get("Price")+"Price does not match");
		String availableStatus = page.textContent(isAvailable);
		System.out.println(availableStatus);
		Assert.assertEquals(availableStatus, dataMap.get("Available"),dataMap.get("Available")+"status does not match");
		String category = page.textContent(productCategory);
		System.out.println(category);
		Assert.assertEquals(category, dataMap.get("Category"),dataMap.get("Category")+"status does not match");	
		page.fill(searchBox, " ");
	}
	
	

}
