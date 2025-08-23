package com.wiproJuly.javasdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvents {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		act.moveToElement(email).keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).build().perform();
		WebElement username = driver.findElement(By.name("username"));
		// explicit wait - applicable for single web element - selenium 4
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		act.moveToElement(password).click().sendKeys("hi").release().build().perform();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
