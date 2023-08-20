package com.playwrite.opencart;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.playwrite.base.TestBase;
import com.playwrite.pages.HomePage;
import com.playwrite.pages.SearchPage;
import com.qa.opencart.SearchProduct;

import junit.framework.Assert;

public class SearchItems extends TestBase{
	
	HomePage homepage;
	SearchPage searchPage;
	
	SearchProduct searchProduct = new SearchProduct(page);
	
	@Test
	public void TC_008()
	{
			
		//searchPage = new SearchPage(page);
		homepage = new HomePage(page);
            //page.navigate("https://naveenautomationlabs.com/opencart/");
            page.navigate(prop.getProperty("url"));
            System.out.println(homepage.getHomePageTitle());
            String title = homepage.getHomePageTitle();
            Assert.assertEquals(title, "Your Store");
            
            
            String actualSearchHeader = homepage.doSearch("samsung");
            
            Assert.assertEquals(actualSearchHeader, "Search - samsung");
            
            searchPage = homepage.navigateToSearchResult();
            boolean present = searchPage.isProductPresent("Samsung SyncMaster 941BW");
            System.out.println(present);
            //page.pause();
            searchPage.openProduct("Samsung SyncMaster 941BW");
            
            searchPage.checkProductDetails("Samsung SyncMaster 941BW", "$242.00");         
	
	}

	@Test
	public void TC_009()
	{
			
		//searchPage = new SearchPage(page);
		homepage = new HomePage(page);
            //page.navigate("https://naveenautomationlabs.com/opencart/");
            page.navigate(prop.getProperty("url"));
            System.out.println(homepage.getHomePageTitle());
            String title = homepage.getHomePageTitle();
            Assert.assertEquals(title, "Your Store");
            
            
            String actualSearchHeader = homepage.doSearch("samsung");
            
            Assert.assertEquals(actualSearchHeader, "Search - samsung");
            
            searchPage = homepage.navigateToSearchResult();
            boolean present = searchPage.isProductPresent("Samsung SyncMaster 941BW");
            System.out.println(present);
            searchPage.openProduct("Samsung SyncMaster 941BW");
            
            searchPage.checkProductDetails("Samsung SyncMaster 941BW", "$242.00");  
            searchPage.addToCart();
	
	}
}
