package Labsession18_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {

    @Test(priority = 0)
    public void positiveLoginTest() throws InterruptedException {
    	
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        
        Thread.sleep(2000);
        
        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(1000);
        
        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(1000);
        
        // Click Submit
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        Thread.sleep(2000);
        
        // Verify URL
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("logged-in-successfully")) {
        	System.out.println("logged-in-successfully");
        }else {
        	System.out.println("URL verification failed!");
        }
        
        // Verify success message
        WebElement message = driver.findElement(By.tagName("h1"));
        if(message.getText().contains("Logged In Successfully")){
        	System.out.println("Success Message Verified");
        }else {
        	System.out.println("Success message not found!");
        }
                     
        
        // Verify Log out button
        WebElement logoutBtn = driver.findElement(By.linkText("Log out"));
        if(logoutBtn.isDisplayed()) {
        	System.out.println("Log out Button is displayed");
        }else {
        	System.out.println("Log out button is not displayed!");
        }
        
        Thread.sleep(1000);
        driver.quit();
    }
    
    // Test Case 2: Negative Username Test
    @Test(priority = 1)
    public void negativeUsernameTest() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        
        Thread.sleep(2000);
        
        // Enter invalid username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrectUser");
        Thread.sleep(1000);
        
        // Enter valid password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(1000);
        
        // Click Submit
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        Thread.sleep(2000);
        
        // Verify error message
        WebElement error = driver.findElement(By.id("error"));

        if (error.isDisplayed()) {
            String actualError = error.getText();
            if (actualError.equals("Your username is invalid!")) {
                System.out.println("Correct error message displayed.");
            } else {
                System.out.println("Unexpected error message");
            }
        } else {
            System.out.println("Error message not displayed!");
        }
        
        Thread.sleep(2000);
        driver.quit();
    }
    
    // Test Case 3: Negative Password Test
    @Test(priority = 2)
    public void negativePasswordTest() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        
        Thread.sleep(2000);
        
        // Enter valid username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(1000);
        
        // Enter invalid password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("incorrectPassword");
        Thread.sleep(1000);
        
        // Click Submit
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        Thread.sleep(2000);
        
        // Verify error message
        WebElement error = driver.findElement(By.id("error"));
        
        if (error.isDisplayed()) {
            String actualError = error.getText();
            if (actualError.equals("Your password is invalid!")) {
                System.out.println("Correct error message displayed");
            } else {
                System.out.println("Unexpected error message");
            }
        } else {
            System.out.println("Error message not displayed!");
        }
        
        Thread.sleep(2000);
        driver.quit();
    }

}