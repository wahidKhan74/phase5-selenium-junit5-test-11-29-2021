package com.simplilearn.app.webelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadiobuttonTest {

	// step 1: create a source test url
	String siteURl = "file:///home/wahidkhan74gmai/MCIT_Worspace/phase5-selenium-junit5-test-11-29-2021/static/web-elements.html";
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
	@DisplayName("Radio button One exist test")
	void testRadioButtonExist() {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
	}
	
	@Test
	@DisplayName("Radio button Two exist test")
	void testRadioButton2Exist() {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
	}
	
	@Test
	@DisplayName("Select Radio button One test")
	void testSelectRadioButtonOne() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		
		// select radio button :: click on radio button
		radioButton.click();
		assertEquals(true, radioButton.isSelected());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Select Radio button Two test")
	void testSelectRadioButtonTwo() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		
		// select radio button :: click on radio button
		radioButton.click();
		assertEquals(true, radioButton.isSelected());
		Thread.sleep(3000);
	}
}
