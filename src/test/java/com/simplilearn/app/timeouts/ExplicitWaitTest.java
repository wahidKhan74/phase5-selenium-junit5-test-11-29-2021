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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {

	// step 1: create a source test url
	String siteURl = "https://www.facebook.com/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;
	WebDriverWait wait;
	

	@BeforeEach
	void setUp() {
		// step 2: set selenium system properties
		System.setProperty("webdriver.chrome.driver", driverPath);
		// step 3: create a web driver instance
		driver = new ChromeDriver();
		// explicit wait : explicit wait is used to tell the web driver to wait for a certain condition 
		// or maximum time to be exceeded before throwing " Element Not Visible exception"
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
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
		
		// takes time to get loaded.
		// WebElement error = driver.findElement(By.cssSelector("#error_box > div.fsl.fwb.fcb"));
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", error.getText());
	}
}
