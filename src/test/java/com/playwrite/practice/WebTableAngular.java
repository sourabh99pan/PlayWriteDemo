package com.playwrite.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator.LocatorOptions;

public class WebTableAngular {

	static Page page;
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page =browser.newPage();
		
		page.navigate("https://www.primefaces.org/olympia-ng/#/uikit/table");
		Locator rows = page.locator("div#pr_id_17 tr");
		
		//rows.locator("scope:",new Locator.LocatorOptions().setHasText("Art Venere")).locator(""));
	}

}
