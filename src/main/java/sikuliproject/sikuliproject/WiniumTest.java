package sikuliproject.sikuliproject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class WiniumTest {

	public static void main(String[] args) throws MalformedURLException {

		DesktopOptions option = new DesktopOptions();
		
		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"),option);
		driver.findElement(By.name("Seven")).click();
		
		driver.findElement(By.name("Plus")).click();
		
		driver.findElement(By.name("Eight")).click();
		
		//Plus
		
		driver.findElement(By.name("Equals")).click();
		
		if(driver.findElement(By.name("Display is 15")).isDisplayed())
		{
			System.out.println("Correct value is present");
		}
		else
		{
			System.out.println("Correct value is not present");
		}
		
		
		
		
		
		
	}

}
