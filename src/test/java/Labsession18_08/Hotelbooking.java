package Labsession18_08;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Hotelbooking {

    public static void clickEvent(WebDriver driver, String xpath, String inputText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
        if (!inputText.isEmpty()) {
            element.clear();
            element.sendKeys(inputText);
        }
    }

    @Test
    public void Booking() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://phptravels.net/");
            driver.manage().window().maximize();
            Thread.sleep(1500);

            // Hotels tab
            clickEvent(driver, "//ul[@id='tab']/li[2]/button", "");

            // City selection
            clickEvent(driver, "//span[@id='select2-hotels_city-container']", "");
            WebElement city = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='searchbox']")));
            city.sendKeys("Dubai");
            Thread.sleep(2000);
            city.sendKeys(Keys.ENTER);

            // Check-in and check-out dates
            clickEvent(driver, "//input[@id='checkin']", "25-08-2025");
            clickEvent(driver, "//input[@id='checkout']", "26-08-2025");

            // Travellers dropdown
            clickEvent(driver, "//form[@id='hotels-search']//div[contains(@class,'dropdown-contain') and contains(@class,'active')]", "");

            // Rooms and Adults
            clickEvent(driver, "//input[@id='hotels_rooms']", "2");
            clickEvent(driver, "//input[@id='hotels_adults']", "");

            // Search hotels
            clickEvent(driver, "//form[@id='hotels-search']//button[@type='submit']", "");
            Thread.sleep(3000);

            // Handle Cookie Disclaimer if present
            try {
                WebElement cookieBanner = driver.findElement(By.id("cookie_disclaimer"));
                if (cookieBanner.isDisplayed()) {
                    WebElement acceptButton = cookieBanner.findElement(By.xpath(".//button[contains(text(),'Got It')]"));
                    acceptButton.click();
                    System.out.println("Cookie banner removed.");
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                // No cookie banner, continue
            }

            // Select the hotel (second in list)
            clickEvent(driver, "//li[2]//a[contains(@class,'btn-primary') and contains(text(),'Details')]", "");
            Thread.sleep(4000);

            // Book now button
            clickEvent(driver, "//button[contains(@class,'btn-primary') and contains(@class,'waves-effect')]", "");
            
            // Wait until the personal info form is visible and interactable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement firstNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='p-first-name']")));

            // Scroll to the input to avoid any overlay issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameInput);
            Thread.sleep(500);

            // Fill personal info
            firstNameInput.clear();
            firstNameInput.sendKeys("Varaprasad");

            clickEvent(driver, "//input[@id='p-last-name']", "Reddy");
            clickEvent(driver, "//input[@id='p-email']", "vara@wipro.com");
            clickEvent(driver, "//input[@id='p-phone']", "9874563571");
            clickEvent(driver, "//input[@id='p-address']", "Ongole, AndhraPradesh, India");
            Thread.sleep(2000);

            // Fill traveller info
            clickEvent(driver, "//input[@name='firstname_1']", "Varaprasad");
            clickEvent(driver, "//input[@name='lastname_1']", "Reddy");
            Thread.sleep(2000);
            clickEvent(driver, "//input[@name='firstname_2']", "Saipraveen");
            clickEvent(driver, "//input[@name='lastname_2']", "Reddy");

            // Payment option - bank transfer
            clickEvent(driver, "//input[@id='gateway_bank_transfer']", "");

            // Agree checkbox
            clickEvent(driver, "//input[@id='agreechb']", "");

            // Confirm booking
            clickEvent(driver, "//div[@class='btn-box mt-3']", "");

            Thread.sleep(3000);  // wait to observe result

        } finally {
            driver.quit();
        }
    }
}

