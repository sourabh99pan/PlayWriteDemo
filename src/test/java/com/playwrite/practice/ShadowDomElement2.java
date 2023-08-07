package com.playwrite.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElement2 {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		
		Page page = browserContext.newPage();
		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("i like ginger tea");
		page.pause();
		browser.close();
		playwright.close();

	}

}
