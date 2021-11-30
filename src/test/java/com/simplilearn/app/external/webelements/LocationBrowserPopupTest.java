package com.simplilearn.app.external.webelements;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocationBrowserPopupTest {

	// step 1: create a source test url
	String siteURl = "https://www.amazon.in/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteURl);
	}

	@AfterEach
	void cleanUp() {
		driver.close();
	}
	
	@Test
	void testLocationPopup() throws InterruptedException {
		// find and click location popoup
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);
		
		//swith from main window to popup window
		String mainWindow = driver.getWindowHandle();		
		//list of external popups
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			String chidWindow = itr.next();
			// switch to child window
			driver.switchTo().window(chidWindow);
			// find pincode input field 
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500038");
			// submit location
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}
		
		driver.switchTo().window(mainWindow);
		Thread.sleep(5000);
	}

}
