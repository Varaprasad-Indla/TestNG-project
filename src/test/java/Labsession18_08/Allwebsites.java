package Labsession18_08;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Allwebsites {

    public static class Addtocart {
        @Test(priority = 4)
        public void mobile() throws InterruptedException {
            ChromeOptions chromeOption = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(chromeOption);
            driver.get("https://www.demoblaze.com/index.html");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement phone = driver.findElement(By.xpath("//a[normalize-space()='Iphone 6 32gb']"));
            phone.click();

            WebElement iphone = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
            iphone.click();

            Thread.sleep(2000);
            Alert alt = driver.switchTo().alert();
            alt.accept();

            WebElement home = driver.findElement(By.xpath("//a[text()='Home ']"));
            home.click();

            WebElement laptops = driver.findElement(By.xpath("//a[text()='Laptops']"));
            laptops.click();

            WebElement laptop = driver.findElement(By.xpath("//a[normalize-space()='MacBook air']"));
            laptop.click();

            WebElement macbook = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
            macbook.click();

            Thread.sleep(2000);
            Alert alt1 = driver.switchTo().alert();
            alt1.accept();

            WebElement adc = driver.findElement(By.xpath("//a[@id='cartur']"));
            adc.click();

            WebElement order = driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
            order.click();

            Thread.sleep(3000);
            WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
            name.sendKeys("Varaprasad");

            Thread.sleep(3000);
            WebElement country = driver.findElement(By.xpath("//input[@id='country']"));
            country.sendKeys("India");

            Thread.sleep(3000);
            WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
            city.sendKeys("Ongole");

            Thread.sleep(2000);
            WebElement creditcard = driver.findElement(By.xpath("//input[@id='card']"));
            creditcard.sendKeys("4581 3312 9999");

            Thread.sleep(2000);
            WebElement month = driver.findElement(By.xpath("//input[@id='month']"));
            month.sendKeys("August");

            Thread.sleep(2000);
            WebElement year = driver.findElement(By.xpath("//input[@id='year']"));
            year.sendKeys("2025");

            Thread.sleep(2000);
            WebElement purchase = driver.findElement(By.xpath("//button[normalize-space()='Purchase']"));
            purchase.click();

            Thread.sleep(3000);
            WebElement ok = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
            ok.click();

            Thread.sleep(2000);
            driver.quit();
        }
    }

    public static class FormFilling {
        @Test(priority = 3)
        public void FormFilling() throws InterruptedException {
            ChromeOptions chromeOption = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(chromeOption);
            driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
            firstname.sendKeys("Varaprasad");
            WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
            lastname.sendKeys("Reddy");
            WebElement gender = driver.findElement(By.xpath("//input[@id='sex-0']"));
            gender.click();
            WebElement experience = driver.findElement(By.xpath("//input[@id='exp-0']"));
            experience.click();
            WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
            date.sendKeys("18-08-2025");
            WebElement profession = driver.findElement(By.xpath("//input[@id='profession-1']"));
            profession.click();
            WebElement tools = driver.findElement(By.xpath("//input[@id='tool-2']"));
            tools.click();
            WebElement continents = driver.findElement(By.xpath("//select[@id='continents']"));
            continents.click();
            WebElement commands = driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']"));
            commands.click();
            Thread.sleep(2000);
            WebElement upload = driver.findElement(By.xpath("//input[@id='photo']"));
            upload.sendKeys("C:\\Users\\princ\\Downloads\\New folder\\test-file.txt");
            Thread.sleep(2000);
            WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
            submit.click();
            Thread.sleep(2000);

            driver.quit();
        }
    }

    public static class login {
        @Test(priority = 1)
        public void positiveLoginTest() throws InterruptedException {

            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(chromeOptions);

            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            Thread.sleep(2000);

            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("student");
            Thread.sleep(1000);

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Password123");
            Thread.sleep(1000);

            WebElement submitBtn = driver.findElement(By.id("submit"));
            submitBtn.click();
            Thread.sleep(2000);

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("logged-in-successfully")) {
                System.out.println("logged-in-successfully");
            } else {
                System.out.println("URL verification failed!");
            }

            WebElement message = driver.findElement(By.tagName("h1"));
            if (message.getText().contains("Logged In Successfully")) {
                System.out.println("Success Message Verified");
            } else {
                System.out.println("Success message not found!");
            }

            WebElement logoutBtn = driver.findElement(By.linkText("Log out"));
            if (logoutBtn.isDisplayed()) {
                System.out.println("Log out Button is displayed");
            } else {
                System.out.println("Log out button is not displayed!");
            }

            Thread.sleep(1000);
            driver.quit();
        }

        @Test(priority = 2)
        public void negativeUsernameTest() throws InterruptedException {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(chromeOptions);

            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            Thread.sleep(2000);

            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("incorrectUser");
            Thread.sleep(1000);

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Password123");
            Thread.sleep(1000);

            WebElement submitBtn = driver.findElement(By.id("submit"));
            submitBtn.click();
            Thread.sleep(2000);

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

        @Test(priority = 0)
        public void negativePasswordTest() throws InterruptedException {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(chromeOptions);

            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            Thread.sleep(2000);

            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("student");
            Thread.sleep(1000);

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("incorrectPassword");
            Thread.sleep(1000);

            WebElement submitBtn = driver.findElement(By.id("submit"));
            submitBtn.click();
            Thread.sleep(2000);

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
}
