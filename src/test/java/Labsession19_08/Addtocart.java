package Labsession19_08;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListener.class)
public class Addtocart {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Launching browser and navigating to site...");
        ChromeOptions chromeOption = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOption);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Parameters("Cart")
    @Test(groups = {"Sanity", "Regression"})
    public void mobile(String cartName) throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        // Select phone
        WebElement phone = driver.findElement(By.xpath("//a[normalize-space()='Iphone 6 32gb']"));
        phone.click();
        System.out.println("Navigated to iPhone 6 32GB product page");

        WebElement iphone = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
        iphone.click();
        Thread.sleep(2000);

        Alert alt = driver.switchTo().alert();
        alt.accept();
        System.out.println("iPhone added to cart");

        // Go back to home and select laptop
        WebElement home = driver.findElement(By.xpath("//a[text()='Home ']"));
        home.click();

        WebElement laptops = driver.findElement(By.xpath("//a[text()='Laptops']"));
        laptops.click();

        WebElement laptop = driver.findElement(By.xpath("//a[normalize-space()='MacBook air']"));
        laptop.click();
        System.out.println("Navigated to MacBook Air product page");

        WebElement macbook = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
        macbook.click();
        Thread.sleep(2000);

        Alert alt1 = driver.switchTo().alert();
        alt1.accept();
        System.out.println("MacBook added to cart");

        // Go to cart and place order
        WebElement adc = driver.findElement(By.xpath("//a[@id='cartur']"));
        adc.click();
        System.out.println("Navigated to cart");

        WebElement order = driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
        Assert.assertTrue(order.isDisplayed(), "Place Order button is not visible");
        order.click();
        System.out.println("Clicked on Place Order");

        // Fill in order form
        driver.findElement(By.id("name")).sendKeys("Varaprasad");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Ongole");
        driver.findElement(By.id("card")).sendKeys("4581 3312 9999");
        driver.findElement(By.id("month")).sendKeys("August");
        driver.findElement(By.id("year")).sendKeys("2025");

        WebElement purchase = driver.findElement(By.xpath("//button[normalize-space()='Purchase']"));
        soft.assertTrue(purchase.isDisplayed(), "Purchase button is not displayed");
        purchase.click();
        System.out.println("Clicked on Purchase");

        // Confirmation
        Thread.sleep(3000);
        WebElement ok = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        soft.assertTrue(ok.isDisplayed(), "Confirmation OK button is not visible");
        ok.click();
        System.out.println("Order placed successfully");

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

