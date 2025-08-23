package com.wipro.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGParameterizationEg {

    @Parameters({ "browser", "platform" })
    @Test
    public void testparameters(String browser, String platform) {

        WebDriver driver = null;

        if (browser.equals("chrome")) {

            if (platform.equals("windows")) {

                ChromeOptions chromeOptions = new ChromeOptions();

                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver(chromeOptions);

                driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            }

        } else if (browser.equals("edge")) {

            if (platform.equals("windows")) {

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

            }

        }

        if (driver != null) {
            driver.quit();
        }
    }

}