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

public class CheckboxTest {

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
	@DisplayName("Checkbox One exist test")
	void testcheckBoxExist() {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("Check box Two exist with default test")
	void testcheckBox2Exist() {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(true, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("Select check box One test")
	void testSelectcheckBoxOne() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
		
		// select checkbox button 
		checkBox.click();
		assertEquals(true, checkBox.isSelected());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Un Select Check box Two test")
	void testSelectcheckBoxTwo() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(true, checkBox.isSelected());
		
		// un select check box  :: click on check box 
		checkBox.click();
		assertEquals(false, checkBox.isSelected());
		Thread.sleep(3000);
	}
	
}
