package com.playwrite.opencart;

import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.playwrite.pages.HomePage;
import com.playwrite.base.TestBase;

import junit.framework.Assert;

public class HomePageTest extends TestBase{


	HomePage homepage;
	
	@Test
	public void TC_003()
	{
			
			homepage = new HomePage(page);
            //page.navigate("https://naveenautomationlabs.com/opencart/");
            page.navigate(prop.getProperty("url"));
            System.out.println(homepage.getHomePageTitle());
            String title = homepage.getHomePageTitle();
            Assert.assertEquals(title, "Your Store");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TC_003.png")));
            
	
	}
	
	@Test
	public void TC_004()
	{
			
			homepage = new HomePage(page);
            page.navigate("https://naveenautomationlabs.com/opencart/");
            System.out.println(homepage.getHomePageURL());
            String url = homepage.getHomePageURL();
            Assert.assertEquals(url, "https://naveenautomationlabs.com/opencart/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TC_004.png")));
            
	
	}
	
	@Test(dataProvider = "getProductData")
	public void TC_005(String productName)
	{
			
			homepage = new HomePage(page);
            page.navigate("https://naveenautomationlabs.com/opencart/");
            System.out.println(homepage.getHomePageURL());
            String actualSearchHeader = homepage.doSearch(productName);
            Assert.assertEquals(actualSearchHeader, "Search - "+productName);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TC_005_"+productName+".png")));
            
	
	}
	
	@DataProvider
	public Object[][] getProductData()
	{
		return new Object [][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
			
		};
	}
}
