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
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownTest {
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
	@DisplayName("Select drop down exist test")
	void testSelectDropDownExist() {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		assertEquals(true, dropdown.isDisplayed());
		assertEquals(true, dropdown.isEnabled());
		assertEquals(false, dropdown.isSelected());
	}
	
	@Test
	@DisplayName("Select first option from drop down")
	void testFirstOptionSelectDropDown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		// map web element to select
		Select select = new Select(dropdown);
		// select bike as a selected option
		select.selectByVisibleText("Bike");
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Bike ", selectedValue.getText());
		
		Thread.sleep(5000);
	}
	
	
	@Test
	@DisplayName("Select 3rd Index option from drop down")
	void test3rdIndexOptionSelectDropDown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		// map web element to select
		Select select = new Select(dropdown);
		// select 3rd index as selected option
		select.selectByIndex(3);
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Airplane ", selectedValue.getText());
		
		Thread.sleep(5000);
	}
	
	@Test
	@DisplayName("Select option by value from drop down")
	void testSelectOptionByValueDropDown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		// map web element to select
		Select select = new Select(dropdown);
		// select 3rd index as selected option
		select.selectByValue("car");
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Car ", selectedValue.getText());
		
		Thread.sleep(5000);
	}
}
