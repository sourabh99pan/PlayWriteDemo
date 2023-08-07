package sikuliproject.sikuliproject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class FlipkartTest {

	public static void main(String[] args) throws MalformedURLException {

		DesktopOptions option = new DesktopOptions();
		
		//option.setApplicationPath("C:\\Users\\soura\\OneDrive\\Desktop\\Postman.lnk");
		
		option.setApplicationPath("C:\\Users\\Public\\Desktop\\VLC media player.lnk");
		
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"),option);
		
		System.out.println(driver.findElement(By.name("Media Alt+M")).isDisplayed());
		
		System.out.println(driver.findElement(By.name("Playback Alt+l")).isDisplayed());
		
		//Playback Alt+l
		
	}

}
