package com.playwrite.practice;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth {

	static Page page;
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brContext = browser.newContext();
		page =brContext.newPage();
		
		page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		page.fill("#input-email", "sourabhpan11@gmail.com");
		page.fill("#input-password", "Aug$1105");
		page.click("input[value='Login']");
		page.pause();
		
		brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
		page.close();
		playwright.close();
	}

}
