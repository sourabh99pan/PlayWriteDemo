package com.selenium;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextTest {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcx1	=browser.newContext();
		Page p1 = brcx1.newPage();
		p1.navigate("http://google.com");
		 System.out.println(p1.title());
		 
		 
		 
			BrowserContext brcx2	=browser.newContext();
			Page p2 = brcx2.newPage();
			p2.navigate("https://demoqa.com/text-box");
			 System.out.println(p2.title());
			 brcx1.close();
			 brcx2.close();
		 
		 
		

	}

}
