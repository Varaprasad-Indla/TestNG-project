package com.wiproJuly.javasdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://the-internet.herokuapp.com/windows");
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement clikchere = driver.findElement(By.xpath("//a[normalize-space()='Click Here']"));
		
		clikchere.click();
		Thread.sleep(2000);
		
		Object[] windowHandles = driver.getWindowHandles().toArray();
		System.out.println(windowHandles);
		driver.switchTo().window((String) windowHandles[1]);
		String title = driver.getTitle();
		
		System.out.println(title);
		
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		
		driver.switchTo().window((String) windowHandles[0]);
		
		driver.quit();
		
	}

}
