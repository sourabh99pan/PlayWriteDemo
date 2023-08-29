package com.playwright.olympia;

import java.util.*;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.playwrite.base.TestBase;
import com.playwrite.pages.OlympiaLisePage;
import com.playwrite.pages.OlympiaTablePage;

public class ListSelection extends TestBase {

	OlympiaLisePage olympiaListpage;

	@Test(enabled = false)
	public void TC011() throws InterruptedException {

		olympiaListpage = new OlympiaLisePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaListpage.clickOption();
		olympiaListpage.dragAndDrop("Istanbul");
		olympiaListpage.verifyCountry("Istanbul");

	}

	@Test(enabled = false)
	public void TC012() throws InterruptedException {

		olympiaListpage = new OlympiaLisePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaListpage.clickOption();
		ArrayList<String> countryList = new ArrayList<>(Arrays.asList("Istanbul", "Paris", "Berlin", "Rome"));
		olympiaListpage.dragAndDrop(countryList);

		olympiaListpage.verifyCountry(countryList);

	}

	@Test(enabled = false)
	public void TC013() throws InterruptedException {

		olympiaListpage = new OlympiaLisePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaListpage.clickOption();

		olympiaListpage.clickPagination();

	}
	
	@Test(enabled = false)
	public void TC014() throws InterruptedException {

		olympiaListpage = new OlympiaLisePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaListpage.clickOption();
		
		HashMap<String, String> map = new <String, String>LinkedHashMap();
		//olympiaListpage.searchProduct("Bamboo Watch", "$65");
		map.put("Bamboo Watch", "$65");
		map.put("Black Watch", "$72");
		map.put("Blue Band", "$79");
		map.put("Bracelet", "$15");
		map.put("Shoes", "$64");
		map.put("Brown Purse", "$120");
		map.put("Sneakers", "$78");
		map.put("Purple Band", "$79");
		olympiaListpage.searchProduct(map);

	}
	
	@Test
	public void TC015() throws Exception {

		olympiaListpage = new OlympiaLisePage(page);
		page.navigate(prop.getProperty("olympiaUrl"));

		olympiaListpage.clickOption();
		
		olympiaListpage.searchAndValidateProduct("Bamboo Watch");
		olympiaListpage.searchAndValidateProduct("Black Watch");
		olympiaListpage.searchAndValidateProduct("Blue Band");
		olympiaListpage.searchAndValidateProduct("Chakra Bracelet");
		olympiaListpage.searchAndValidateProduct("Brown Purse");
		olympiaListpage.searchAndValidateProduct("Grey T-Shirt");
		
		
		

	}
}
