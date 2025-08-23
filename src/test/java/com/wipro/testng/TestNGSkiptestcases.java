package com.wipro.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGSkiptestcases {
	@Test()
	public void launchbrowser() {
		ChromeOptions chromeOptions = new ChromeOptions();
 
		WebDriverManager.chromedriver().setup();
 
		WebDriver driver = new ChromeDriver(chromeOptions);
 
		driver.get("https://the-internet.herokuapp.com/windows");
		// maximize the window
		driver.manage().window().maximize();
	}
	@Test(enabled = false, priority = 0)
	public void login() throws InterruptedException {

		ChromeOptions chromeOptions = new ChromeOptions();
 
		WebDriverManager.chromedriver().setup();
 
		WebDriver driver = new ChromeDriver(chromeOptions);
 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// name locator 
		// enter text in username field 
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		Thread.sleep(2000);
		// enter text in password field
		WebElement password = driver.findElement
				(By.xpath("//input[@name = 'password']"));

		password.sendKeys("admin123");
		// click on login button
		Thread.sleep(2000);
		WebElement loginbutton = driver.findElement
				(By.xpath("//button[@type = 'submit']"));

		loginbutton.click();
		Thread.sleep(2000);
	}	
}
