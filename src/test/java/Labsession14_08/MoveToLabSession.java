package Labsession14_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToLabSession {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Action class is used to simulate the mouse related activities
		Actions act = new Actions(driver);
		
		WebElement prime = driver.findElement(By.xpath("//button[@id='mousehover']"));
		act.moveToElement(prime).perform();
		
		Thread.sleep(3000);
		WebElement joinnow = driver.findElement(By.xpath("//a[@href='#top']"));
		act.click(joinnow).perform();
		
		Thread.sleep(3000);
		String cUrl = driver.getCurrentUrl();
		if (cUrl.contains("#top")) {
		    System.out.println("Navigated to Top");
		} else {
		    System.out.println("URL did not change");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}