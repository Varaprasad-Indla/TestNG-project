package com.wiproJuly.javasdet;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ChromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ChromeOptions);
		driver.get("https://the-internet.herokuapp.com/download");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement filedownload = driver.findElement(By.xpath("//a[normalize-space()='test-file.txt']"));
		filedownload.click();
		
		File f = new File("C:/Users/princ/Downloads/test-file.txt");
		
		if (f.exists())	{
			System.out.println("The file is downloaded");
		}else {
			System.out.println("The file is not present");
		}
			
		}

}
