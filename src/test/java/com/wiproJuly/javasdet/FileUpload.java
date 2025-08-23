package com.wiproJuly.javasdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions ChromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ChromeOptions);
		driver.get("https://the-internet.herokuapp.com/upload");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement fileupload = driver.findElement(By.xpath("//input[@id='file-upload']"));
		fileupload.sendKeys("C:/Users/princ/Downloads/test-file (1).txt");
		
		Thread.sleep(2000);
		
		WebElement submit = driver.findElement(By.xpath("//input[@id='file-submit']"));
		
		submit.click();
		
		Thread.sleep(2000);
		WebElement validation = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
		
		if (validation.isDisplayed()) {
			Thread.sleep(2000);
	
			System.out.println("The message displayed properly");
		}else {
			System.out.println("The message not displayed");
		}
			
		}
	}


