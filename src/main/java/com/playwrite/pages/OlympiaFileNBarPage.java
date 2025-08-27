package com.playwrite.pages;

import java.nio.file.Paths;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Page;

//new function222
public class OlympiaFileNBarPage {

	Page page;
	
	public String option = "//span[contains(@class,'layout-menuitem-text ng-tns-') and text()='*' ]";
	
	public String graphLocator = "//p-chart[@type='*']//div//canvas";
	
	public String chooseLocator = "(//input[@type='file'])[1]";
	
	public String fileName = ".p-fileupload-filename";
	
	public String upload = "//span[normalize-space()='Upload']";
	
	public String cancel = "//span[normalize-space()='Cancel']";
	
	public String primeFaces= "//*[@id='templates_form:j_idt59']";
	
	//Page constructor new commit 27 aug
	
	public OlympiaFileNBarPage(Page page)
	{
		this.page=page;
	}
	
	public boolean checkGraphVisible(String graph)
	{
		return page.isVisible(graphLocator.replace("*", graph));
	}
	
	public void checkGraphVisible(List <String>graphs)
	{
		for(String g:graphs)
		{
			boolean flag = page.isVisible(graphLocator.replace("*", g));
			Assert.assertEquals(flag, true);
		}
		
	}
	
	public void clickPerform(String optionClick) throws InterruptedException
	{
		//page.click(option.replace("*", optionClick));
		page.click(primeFaces);
		Assert.assertEquals(page.isVisible(primeFaces), true);
		Thread.sleep(5000);
	}
	
	public void chooseAndUploadFile(String path)
	{
		page.setInputFiles(chooseLocator, Paths.get(path));
		String fileNameDisplayed = page.textContent(fileName);
		Assert.assertEquals(fileNameDisplayed, path);
		page.click(upload);
		
	}
	
	public void removefile()
	{
		page.waitForSelector(cancel);
		page.click(cancel);
		boolean notDisplayed = page.isVisible(fileName);
		Assert.assertEquals(notDisplayed, false);
	}
}
