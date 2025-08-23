package com.wiproJuly.javasdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multicheckbox {

	public static void main(String[] args) throws InterruptedException {
		
ChromeOptions ChromeOptions = new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ChromeOptions);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int size = checkboxes.size();
		System.out.println(size);
		for (int i = 0; i<size; i++) {
			
			Thread.sleep(1000);
			checkboxes.get(i).click();
			
			Thread.sleep(1000);
		}
	}

}
