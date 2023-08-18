package com.playwrite.practice;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploadHandle {

	public static void main(String[] args) {

		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		page.pause();
		page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));
		
		page.setInputFiles("input#filesToUpload", new Path[0]);
		
		page.setInputFiles("input#filesToUpload",new Path[] { Paths.get("applogin.json"),Paths.get("TC_001.png"),Paths.get("TC_002.png")});
		
		
		
	}

}
