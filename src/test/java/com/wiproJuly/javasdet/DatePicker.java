package com.wiproJuly.javasdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ChromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ChromeOptions);
		driver.get("https://ui.shadcn.com/docs/components/date-picker");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement datepicker = driver.findElement(By.xpath("//*///[@id='date']"));
		datepicker.click();
		Thread.sleep(2000);
		
		WebElement datepicker1 = driver.findElement(By.xpath("//button[@data-day='8/13/2025"));
		
		datepicker1.click();
		Thread.sleep(2000);
		WebElement datepicker2 = driver.findElement(By.xpath("//button[@data-day='8/22/2025"));
		
		datepicker2.click();
		Thread.sleep(2000);
		driver.quit();
	}

}
