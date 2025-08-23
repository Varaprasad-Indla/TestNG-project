package Labsession14_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentRegistration {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ChromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ChromeOptions);
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("Varaprasad");
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("email999@gmail.com");
		Thread.sleep(2000);
		WebElement gender = driver.findElement(By.xpath("//label[normalize-space()='Gender:']"));
		gender.click();
		Thread.sleep(2000);
		WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='mobile']"));	
		mobileNumber.sendKeys("7987456321");
		Thread.sleep(2000);
		WebElement DOB = driver.findElement(By.xpath("//input[@id='dob']"));
		DOB.sendKeys("05-07-2002");
		Thread.sleep(2000);
		WebElement subject = driver.findElement(By.xpath("//input[@id='subjects']"));
		subject.sendKeys("Java-Selenium");
		Thread.sleep(2000);
		WebElement Hobbies = driver.findElement(By.xpath("//label[text()='Sports']/preceding-sibling::input"));
		Hobbies.click();
        Thread.sleep(500);
        WebElement Hobbies1 = driver.findElement(By.xpath("//label[text()='Reading']/preceding-sibling::input"));
        Hobbies1.click();
        Thread.sleep(500);
		WebElement pictureupload = driver.findElement(By.xpath("//input[@id='picture']"));	
		pictureupload.sendKeys("C:/Users/princ/Downloads/test-file (1).txt");
		Thread.sleep(2000);
		WebElement currentaddress = driver.findElement(By.xpath("//textarea[@id='picture']"));
		currentaddress.sendKeys("Hyderabad");
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='state']"));
		Select sel = new Select(dropdown);
		Thread.sleep(2000);
		sel.selectByVisibleText("Uttar Pradesh");
		Thread.sleep(2000);
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='city']"));
		Select sel1 = new Select(dropdown1);
		sel1.selectByVisibleText("Lucknow");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
		login.click();
		Thread.sleep(2000);
		driver.quit();
	}

}
