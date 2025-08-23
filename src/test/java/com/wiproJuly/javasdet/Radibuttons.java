package com.wiproJuly.javasdet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radibuttons {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ChromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ChromeOptions);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		List<WebElement> radioboxes = driver.findElements(By.xpath("//input[@name='radioButton']"));
		int size = radioboxes.size();
		System.out.println(size);
		for (int i = 0; i<size; i++) {
			
			Thread.sleep(1000);
			radioboxes.get(i).click();
			System.out.println("Radio Button " + (i + 1));
			
			Thread.sleep(1000);
		}
	}

}
