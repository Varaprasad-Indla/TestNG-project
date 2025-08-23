package com.wiproJuly.javasdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement from = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='column-b']"));

		act.dragAndDrop(from, to).perform();
		
		Thread.sleep(2000);
		
		driver.quit();
	}	
		
	
		
	
	

}
