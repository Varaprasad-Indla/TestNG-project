package Labsession19_08;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListener.class)
public class FormFilling {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Launching browser and opening the Selenium practice form...");
        ChromeOptions chromeOption = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOption);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @Test(groups = {"Sanity", "Regression"})
    public void fillFormTest() throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        // First name
        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Varaprasad");
        System.out.println("Entered first name");

        // Last name
        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Reddy");
        System.out.println("Entered last name");

        // Gender selection
        WebElement gender = driver.findElement(By.xpath("//input[@id='sex-0']"));
        gender.click();
        System.out.println("Selected gender");

        // Years of experience
        WebElement experience = driver.findElement(By.xpath("//input[@id='exp-0']"));
        experience.click();
        System.out.println("Selected experience");

        // Date
        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys("18-08-2025");
        System.out.println("Entered date");

        // Profession
        WebElement profession = driver.findElement(By.xpath("//input[@id='profession-1']"));
        profession.click();
        System.out.println("Selected profession");

        // Tool
        WebElement tools = driver.findElement(By.xpath("//input[@id='tool-2']"));
        tools.click();
        System.out.println("Selected automation tool");

        // Continent dropdown
        WebElement continents = driver.findElement(By.xpath("//select[@id='continents']"));
        continents.click();
        WebElement option = driver.findElement(By.xpath("//option[normalize-space()='Europe']"));
        option.click();
        System.out.println("Selected continent");

        // Command option
        WebElement commands = driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']"));
        commands.click();
        System.out.println("Selected Selenium command");

        // File Upload
        WebElement upload = driver.findElement(By.xpath("//input[@id='photo']"));
        upload.sendKeys("C:\\Users\\princ\\Downloads\\New folder\\test-file.txt");
        System.out.println("Uploaded file");

        // Submit form
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        Assert.assertTrue(submit.isDisplayed(), "Submit button is not displayed!");
        submit.click();
        System.out.println("Form submitted");

        // Final URL check
        String currentURL = driver.getCurrentUrl();
        soft.assertTrue(currentURL.contains("selenium-practice-form"), "URL doesn't contain expected string");

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

