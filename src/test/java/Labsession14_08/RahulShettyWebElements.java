package Labsession14_08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RahulShettyWebElements {

	public static void main(String[] args) throws Exception {
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		Radio1.click();
		WebElement Radio2 = driver.findElement(By.xpath("//input[@value='radio2']"));
		Radio2.click();
		WebElement Radio3 = driver.findElement(By.xpath("//input[@value='radio3']"));
		Radio3.click();
		
		WebElement suggestion = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		suggestion.sendKeys("India");
		
		
		WebElement option = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		
		Select sel = new Select(option);
		sel.selectByVisibleText("Option2");   
		sel.selectByIndex(1);                
		sel.selectByValue("option3"); 
	
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		checkbox1.click();
		WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
		checkbox2.click();	
		WebElement checkbox3 = driver.findElement(By.xpath("//input[@id='checkBoxOption3']"));
		checkbox3.click();
		Thread.sleep(3000);
		WebElement openwindow = driver.findElement(By.xpath("//button[@id='openwindow']"));
		openwindow.click();
		
		Thread.sleep(2000);
		
		driver.quit();
			
		
	}

}
