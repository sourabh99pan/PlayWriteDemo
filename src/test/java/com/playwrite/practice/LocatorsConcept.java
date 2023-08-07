package com.playwrite.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorsConcept {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/30-day-free-trial/");
		Locator contactsales = page.locator("text=Contact Sales").first();
		contactsales.hover();
		contactsales.click();

	}

}
