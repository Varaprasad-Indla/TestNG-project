package com.wiproJuly.javasdet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) {
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://the-internet.herokuapp.com/tables");
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr"));
		int rowcount = rows.size();
		System.out.println(rowcount);
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr[1]/th"));
		int colscount = cols.size();
		System.out.println(colscount);
		WebElement celltext = driver.findElement(By.xpath("//table[@id = 'table1']/tbody/tr[4]/td[3]"));
		String actualtext = celltext.getText();
		String excepextedtext = "tconway@earthlink.net";
		if(actualtext.equalsIgnoreCase(excepextedtext)) {
			System.out.println("The text matching");	
		}else {
			System.out.println("The text not matching");
		}
	}

}
