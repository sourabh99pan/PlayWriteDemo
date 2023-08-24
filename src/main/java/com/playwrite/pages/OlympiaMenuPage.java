package com.playwrite.pages;

import com.microsoft.playwright.Page;

public class OlympiaMenuPage {

	Page page;

	public String menuOption = "//span[contains(@class,'layout-menuitem-text ng-tns-') and text()='*' ]";

	public String tieredMenu = "(//span[@class='p-menuitem-text ng-star-inserted' and text()='*'])[2]";

	public String tieredsubMenu = "(//span[@class='p-menuitem-text ng-star-inserted'][normalize-space()='*'])[2]";


	// Page constructor

	public OlympiaMenuPage(Page page) {
		this.page = page;
	}

	public void clickOption(String name) {
		page.click(menuOption.replace("*", name));
	}

	public void clickMenu(String name, String menus) {
		switch (menus) {
		case "tieredMenu":
			page.click(tieredMenu.replace("*", name));
			break;
		case "tieredsubMenu":
			//page.click(tieredsubMenu.replace("*", name));
			page.isVisible(tieredsubMenu.replace("*", name));
			break;
		}
	}
}
