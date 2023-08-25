package com.playwright.olympia;

import org.testng.annotations.Test;

import com.playwrite.base.TestBase;
import com.playwrite.pages.OlympiaFileNBarPage;
import com.playwrite.pages.ProductPage;

public class ProductCreation extends TestBase {
	
	ProductPage olympiaproductpage;

	@Test
	public void TC017() throws InterruptedException {

		olympiaproductpage = new ProductPage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaproductpage.clickOption("Pages");
		olympiaproductpage.clickOption("Crud");
		olympiaproductpage.createProduct();

	}

}
