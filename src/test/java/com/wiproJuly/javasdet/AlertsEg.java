package com.wiproJuly.javasdet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsEg {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ChromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ChromeOptions);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement simplealert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
		
		simplealert.click();
		
		Thread.sleep(1000);
		
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(1000);
		
		WebElement confirmalert = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']"));
		confirmalert.click();
		
		Thread.sleep(1000);
		
		Alert alt1 = driver.switchTo().alert();
		
		alt1.dismiss();
		Thread.sleep(2000);
		WebElement promptalert = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']"));
		
		promptalert.click();
		Thread.sleep(2000);
		
		Alert alt2 = driver.switchTo().alert();
		String alerttext = alt2.getText();
		
		alt2.sendKeys("Varaprasad Reddy");
		Thread.sleep(2000);
		
		alt2.accept();
		
		Thread.sleep(2000);
		
		
		driver.quit();
		
		
		
		
		
		
	}

}
