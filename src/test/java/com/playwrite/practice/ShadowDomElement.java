package com.playwrite.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElement {

	public static void main(String[] args) {

		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		
		Page page = browserContext.newPage();
		page.navigate("https://books-pwakit.appspot.com/");
		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing books");
		String desc = page.locator("book-app[apptitle='BOOKS'] .book-desc").textContent();
		System.out.println(desc);
		browser.close();
		playwright.close();
		
		

	}

}
