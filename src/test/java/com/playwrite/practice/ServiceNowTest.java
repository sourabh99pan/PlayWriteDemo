package com.playwrite.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class ServiceNowTest {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		
		Page page = browserContext.newPage();
		
		page.navigate("https://ven02977.service-now.com");
		page.locator("#user_name").fill("admin");
		page.locator("#user_password").fill("SNow#37WtFeCN5J");
		page.locator("#sysverb_login").click();
		page.pause();
		//getByRole('link', { name: 'Organization - Users' })
		page.getByText("Organization - Users").click();
		//page.locator(":has-text(\"Organization - Users\")").click();
		page.locator("#sys_user_table_header_search_control").fill("Sourabh");
		page.locator("#sys_user_table_header_search_control").highlight();
		//page.getByRole(AriaRole.LINK, "Search column: user id");
		page.getByText("sourabh123").click();
		page.frameLocator("#gsft_main").locator("xpath//input[@id='sys_user.phone']").fill("+12063374168");
		page.pause();
		

	}

}
