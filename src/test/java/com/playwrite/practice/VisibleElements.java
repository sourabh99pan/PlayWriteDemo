package com.playwrite.practice;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		
		Page page = browserContext.newPage();
		page.navigate("https://www.flipkart.com/");
		List<String> links = page.locator("a:visible").allInnerTexts();
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i));
		}
		
		browser.close();
		playwright.close();
	}

}
