package com.selenium;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.playwrite.base.*;

public class PlaywriteTest extends TestBase {


	
	@Test
	public void TC_001()
	{
			      System.out.println("in Test TC_001");
			      System.out.println("added description");
            page.navigate("http://google.com");
            System.out.println(page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TC_001.png")));
            
	
	}
	
	@Test
	public void TC_002()
	{
		System.out.println("In the Test new TC_002");
	      page.navigate("https://demoqa.com/text-box");
	      page.getByPlaceholder("Full Name").click();
	      page.getByPlaceholder("Full Name").fill("David Smith");
	      page.getByPlaceholder("name@example.com").click();
	      page.getByPlaceholder("name@example.com").fill("abc1@gmail.com");
	      //page.pause();
	      page.getByPlaceholder("Current Address").click();
	      page.getByPlaceholder("Current Address").fill("Indore mp");
	      page.locator("#permanentAddress").click();
	      page.locator("#permanentAddress").fill("indore mp");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
	      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TC_002.png")));
	}

}

