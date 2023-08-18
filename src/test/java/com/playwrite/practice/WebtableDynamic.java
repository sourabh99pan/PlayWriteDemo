package com.playwrite.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebtableDynamic {

	static Page page;
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page =browser.newPage();
		
		page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		Locator rows = page.locator("table#example tr");
		rows.locator(":scope",new Locator.LocatorOptions().setHasText("Ashton Cox")).locator(".select-checkbox").click();//imp step
		
		rows.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));
		page.locator("table#example tr:nth-child(2)").highlight();
		page.locator("table#example tr:nth-child(2)").allInnerTexts().forEach(e->System.out.println(e));
		
		page.close();
		playwright.close();
		
		

	}

}
