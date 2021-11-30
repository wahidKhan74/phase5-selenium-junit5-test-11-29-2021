package com.simplilearn.app.external.webelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	// step 1: create a source test url
	String siteURl = "file:///home/wahidkhan74gmai/MCIT_Worspace/phase5-selenium-junit5-test-11-29-2021/static/alert-web-elements.html";
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
	@DisplayName("Alert Test :  simple  alert window ")
	void testAlertDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(2) > button")).click();

		// switch focus to alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Do you really want to proceed ??", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}

	@Test
	@DisplayName("Confirm Test :  confirm alert window with accept")
	void testConfirmDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();

		// switch focus to alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}

	@Test
	@DisplayName("Confirm Test :  confirm alert window with cancel")
	void testConfirmDailog2Window() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();

		// switch focus to alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", alert.getText());
		Thread.sleep(3000);
		alert.dismiss();
	}

	@Test
	@DisplayName("Prompt Test :  prompt alert window with accept")
	void testPromptDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(6) > button")).click();

		// switch focus to alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		Thread.sleep(3000);
		// prompt with ok button click
		alert.accept();
	}
}
