package com.wiproJuly.javasdet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeFirefoxBrowser {

	public static void main(String[] args) {
		FirefoxOptions firefoxOption = new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(firefoxOption);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

}