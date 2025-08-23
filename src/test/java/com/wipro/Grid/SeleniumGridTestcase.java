package com.wipro.Grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumGridTestcase extends HelperClass{
	@Test
	public void login() throws InterruptedException {

		WebElement Username = getDriver().findElement(By.name("username"));
		Username.sendKeys("Admin");
		Thread.sleep(1000);
		// name locator 
		WebElement Password  = getDriver().findElement(By.name("password"));
		Password.sendKeys("admin123");
		Thread.sleep(1000);
		WebElement LoginButton = getDriver().findElement(By.tagName("button"));
		LoginButton.click();
		Thread.sleep(2000);
	}
 
}

