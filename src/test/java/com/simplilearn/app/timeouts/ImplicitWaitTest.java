package com.simplilearn.app.timeouts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitTest {

	// step 1: create a source test url
	String siteURl = "https://www.facebook.com/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		// step 2: set selenium system properties
		System.setProperty("webdriver.chrome.driver", driverPath);
		// step 3: create a web driver instance
		driver = new ChromeDriver();
		// implicit wait  : The implicit in selenium is used for tell the web driver to wait for 
		// a certain time before it throw a "No Such element exception" default implicit setting is 0.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		// step 4: launch browser
		driver.get(siteURl);
	}

	@AfterEach
	void cleanUp() {
		// step 6: close driver
		 driver.close();
	}
	
	@Test
	@DisplayName("Facebook Test : Validate inputs exist !")
	void testFacebookHomepage() {
		WebElement email= driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.name("login"));
		
		assertEquals(true, email.isDisplayed());
		assertEquals(true, password.isDisplayed());
		assertEquals(true, submit.isDisplayed());
	}
	

	@Test
	@DisplayName("Facebook Test : Login test !")
	void testFacebookFailureLogin() {
		WebElement email= driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		email.sendKeys("abc@gmail.com");
		password.sendKeys("abc@123");
		submitButton.submit();
		
		WebElement error = driver.findElement(By.cssSelector("#error_box > div.fsl.fwb.fcb"));
		assertEquals("Wrong Credentials", error.getText());
	}
}
