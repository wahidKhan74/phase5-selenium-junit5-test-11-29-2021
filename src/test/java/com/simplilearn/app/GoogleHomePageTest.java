package com.simplilearn.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleHomePageTest {

	// step 1: create a source test url
	String siteURl = "https://www.google.com/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		// step 2: set selenium system properties
		System.setProperty("webdriver.chrome.driver", driverPath);
		// step 3: create a web driver instance
		driver = new ChromeDriver();
		// step 4: launch browser
		driver.get(siteURl);
	}

	@AfterEach
	void cleanUp() {
		// step 6: close driver
		driver.close();
	}

	@Test
	void testGoogleHomepage() {
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}

	@Test
	void testGoogleSourceURL() {
		assertEquals(siteURl, driver.getCurrentUrl());
	}

	@Test
	void testGoogleSearchValue() {
		// search test evaluation
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium documentation");
		searchBox.submit();

		// step 5: evaluate test
		String expectedTitle = "selenium documentation - Google Search";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
}
