package com.wiproJuly.javasdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonEg {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ChromeOptions = new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ChromeOptions);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement radiobox = driver.findElement(By.xpath("//input[@value='radio3']"));
		
		radiobox.click();
		Thread.sleep(2000);
	}

}
