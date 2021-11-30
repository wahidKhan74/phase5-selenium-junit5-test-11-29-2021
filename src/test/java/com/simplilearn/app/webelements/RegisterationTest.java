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

public class RegisterationTest {


	// step 1: create a source test url
	String siteURl = "file:///home/wahidkhan74gmai/MCIT_Worspace/phase5-selenium-junit5-test-11-29-2021/static/registration.html";
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
	@DisplayName("Registration test")
	void testUserRegistration() {
		
	}
}
