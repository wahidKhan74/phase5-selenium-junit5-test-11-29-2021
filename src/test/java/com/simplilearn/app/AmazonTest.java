package com.simplilearn.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
	// step 1: create a source test url
	String siteURl = "https://www.amazon.in/";
	String driverPath = "drivers/chromedriver.exe";
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
	void testAmazonHomepage() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void testAmazonMobileLink() {
		// find mobile link
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
		mobileLink.click();

		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	void testAmazonSearch() {
		// find search box
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 12 max pro");
		searchBox.submit();
		
		String expected = "Amazon.in : Iphone 12 max pro";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
}
