package Labsession19_08;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

@Listeners(TestListener.class)
public class Hotelbooking {

    WebDriver driver;

    // Custom click + input method
    public static void clickEvent(WebDriver driver, String xpath, String inputText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
        if (!inputText.isEmpty()) {
            element.clear();
            element.sendKeys(inputText);
        }
    }

    @BeforeMethod
    public void setup() {
        System.out.println("Launching browser and navigating to hotel booking site...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(groups = {"Sanity", "Regression"})
    public void Booking() throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        driver.get("https://phptravels.net/");
        Thread.sleep(1500);
        System.out.println("Opened PHPTravels homepage");

        // Hotels tab
        clickEvent(driver, "//ul[@id='tab']/li[2]/button", "");
        System.out.println("Hotels tab selected");

        // City selection
        clickEvent(driver, "//span[@id='select2-hotels_city-container']", "");
        WebElement city = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='searchbox']")));
        city.sendKeys("Dubai");
        Thread.sleep(2000);
        city.sendKeys(Keys.ENTER);
        System.out.println("City selected: Dubai");

        // Check-in and check-out
        clickEvent(driver, "//input[@id='checkin']", "25-08-2025");
        clickEvent(driver, "//input[@id='checkout']", "26-08-2025");
        System.out.println("Dates selected: Check-in 25-08-2025, Check-out 26-08-2025");

        // Travellers and room info
        clickEvent(driver, "//form[@id='hotels-search']//div[contains(@class,'dropdown-contain') and contains(@class,'active')]", "");
        clickEvent(driver, "//input[@id='hotels_rooms']", "2");
        clickEvent(driver, "//input[@id='hotels_adults']", "");
        System.out.println("Rooms set to 2");

        // Search hotels
        clickEvent(driver, "//form[@id='hotels-search']//button[@type='submit']", "");
        Thread.sleep(3000);
        System.out.println("Search submitted");

        // Handle cookie banner if exists
        try {
            WebElement cookieBanner = driver.findElement(By.id("cookie_disclaimer"));
            if (cookieBanner.isDisplayed()) {
                WebElement acceptButton = cookieBanner.findElement(By.xpath(".//button[contains(text(),'Got It')]"));
                acceptButton.click();
                System.out.println("Cookie banner removed");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("No cookie banner found");
        }

        // Select hotel and click Details
        clickEvent(driver, "//li[2]//a[contains(@class,'btn-primary') and contains(text(),'Details')]", "");
        Thread.sleep(4000);
        System.out.println("Hotel details opened");

        // Book now
        clickEvent(driver, "//button[contains(@class,'btn-primary') and contains(@class,'waves-effect')]", "");
        System.out.println("Clicked on Book Now");

        // Fill personal info
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement firstNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='p-first-name']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameInput);
        Thread.sleep(500);

        firstNameInput.clear();
        firstNameInput.sendKeys("Varaprasad");
        clickEvent(driver, "//input[@id='p-last-name']", "Reddy");
        clickEvent(driver, "//input[@id='p-email']", "vara@wipro.com");
        clickEvent(driver, "//input[@id='p-phone']", "9874563571");
        clickEvent(driver, "//input[@id='p-address']", "Ongole, AndhraPradesh, India");
        System.out.println("Filled personal details");

        // Travellers info
        clickEvent(driver, "//input[@name='firstname_1']", "Varaprasad");
        clickEvent(driver, "//input[@name='lastname_1']", "Reddy");
        clickEvent(driver, "//input[@name='firstname_2']", "Saipraveen");
        clickEvent(driver, "//input[@name='lastname_2']", "Reddy");
        System.out.println("Filled travellers info");

        // Payment method
        clickEvent(driver, "//input[@id='gateway_bank_transfer']", "");
        clickEvent(driver, "//input[@id='agreechb']", "");
        System.out.println("Selected payment method and agreed to terms");

        // Confirm booking
        clickEvent(driver, "//div[@class='btn-box mt-3']", "");
        System.out.println("Booking submitted");

        Thread.sleep(3000); // Pause to see result

        // Assertion example (you can add more based on actual confirmation page content)
        String currentURL = driver.getCurrentUrl();
        soft.assertTrue(currentURL.contains("invoice"), "Booking confirmation URL does not contain 'invoice'");

        soft.assertAll();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        System.out.println("Closing browser...");
        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();
        }
    }
    @BeforeTest

	public void beforetest() {

		System.out.println("checking products");

	}

 
	@AfterTest

	public void aftertest() {

		System.out.println("removing products");

	}

	@BeforeClass

	public void beforeclass() {

		System.out.println("Opening the api connections");

	}

 
	@AfterClass

	public void afterclass() {

		System.out.println("closing the api connections");

	}

	@BeforeSuite

	public void beforesuite() {

		System.out.println("Opening the db connections");

	}

 
	@AfterSuite

	public void aftersuite() {

		System.out.println("closing the db connections");

	}

	@BeforeMethod

	public void beforemethod() {

		System.out.println("Launch browser");

	}

 
	@AfterMethod

	public void aftemethod() {

		System.out.println("closing the browser");

	}

	@Test

	public void testcase1() {
 
		System.out.println("Testcase1 is executed");

	}
 
	@Test

	public void testcase2() {
 
		System.out.println("Testcase2 is executed");
 
	}
 
	@Test

	public void testcase3() {
 
		System.out.println("Testcase3 is executed");
 
	}	


}



