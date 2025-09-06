package project_TestNG;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoBlazeProject {

	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOption = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOption);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOption);

		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C://Varaprasad//msedgedriver.exe/"); 
			EdgeOptions EdgeOption = new EdgeOptions(); 
			driver = new EdgeDriver(EdgeOption);
			
		} else {
			System.out.println("Invalid browser name");
			return;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demoblaze.com/index.html");
	}

	@Test(priority = 1)
	public void signUp() throws InterruptedException {
		WebElement signin = driver.findElement(By.xpath("//a[@id='signin2']"));
		signin.click();
		Thread.sleep(2000);

		WebElement username = driver.findElement(By.xpath("//input[@id='sign-username']"));
		username.sendKeys("Varaprasad@");
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.xpath("//input[@id='sign-password']"));
		password.sendKeys("Varaprasad@123");
		Thread.sleep(2000);

		WebElement signup = driver.findElement(By.xpath("//button[normalize-space()='Sign up']"));
		signup.click();
		Thread.sleep(2000);

		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);

		WebElement close = driver.findElement(By.xpath("//div[@id='signInModal']//button[text()='Close']"));
		close.click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		WebElement login = driver.findElement(By.xpath("//a[@id='login2']"));
		login.click();
		Thread.sleep(3000);

		WebElement logusername = driver.findElement(By.xpath("//input[@id='loginusername']"));
		logusername.clear();
		logusername.sendKeys("Varaprasad@");
		Thread.sleep(2000);

		WebElement logpassword = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		logpassword.clear();
		logpassword.sendKeys("Varaprasad@123");
		Thread.sleep(2000);

		WebElement login1 = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		login1.click();
		Thread.sleep(3000); 
	}

	@Test(priority = 3)
	public void addToCart() throws InterruptedException {
		WebElement iphone = driver.findElement(By.xpath("//a[normalize-space()='Iphone 6 32gb']"));
		iphone.click();
		Thread.sleep(2000);

		WebElement addiphone = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
		addiphone.click();
		Thread.sleep(2000);

		Alert alt1 = driver.switchTo().alert();
		alt1.accept();
		Thread.sleep(2000);

		WebElement home = driver.findElement(By.xpath("//a[text()='Home ']"));
		home.click();
		Thread.sleep(2000);

		WebElement laptops = driver.findElement(By.xpath("//a[text()='Laptops']"));
		laptops.click();
		Thread.sleep(2000);

		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='MacBook air']"));
		mac.click();
		Thread.sleep(2000);

		WebElement addmac = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
		addmac.click();
		Thread.sleep(2000);

		Alert alt2 = driver.switchTo().alert();
		alt2.accept();
		Thread.sleep(2000);
		
		WebElement homepage = driver.findElement(By.xpath("//a[text()='Home ']"));
		homepage.click();
		Thread.sleep(2000);
		
		WebElement Monitors = driver.findElement(By.xpath("//a[text()='Monitors']"));
		Monitors.click();
		Thread.sleep(2000);
		WebElement AppleMonitor = driver.findElement(By.xpath("//a[normalize-space()='Apple monitor 24']"));
		AppleMonitor.click();
		Thread.sleep(3000);
		WebElement addMonitor = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
		addMonitor.click();
		Thread.sleep(2000);
		
		Alert alt3 = driver.switchTo().alert();
		alt3.accept();
		Thread.sleep(2000);
		
		
	}

	@Test(priority = 4)
	public void placeOrder() throws InterruptedException {
		WebElement cart = driver.findElement(By.xpath("//a[@id='cartur']"));
		cart.click();
		Thread.sleep(2000);

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

		WebElement card = driver.findElement(By.xpath("//input[@id='card']"));
		card.sendKeys("4439 5949 9545");
		Thread.sleep(2000);

		WebElement month = driver.findElement(By.xpath("//input[@id='month']"));
		month.sendKeys("September");
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
	}

	@Test(priority = 5)
	public void logout() throws InterruptedException {
		Thread.sleep(2000); 

		WebElement logout = driver.findElement(By.xpath("//a[@id='logout2']"));
			logout.click();
			Thread.sleep(2000);
		} 
	

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
