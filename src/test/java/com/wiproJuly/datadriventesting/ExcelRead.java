package com.wiproJuly.datadriventesting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ExcelRead {	 
		WebDriver driver;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFCell cell;
		@Test
		public void login() throws IOException {
			File src = new File ("C:\\Users\\princ\\eclipse-workspace\\javasdet\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			// load the work book
			workbook = new XSSFWorkbook(fis) ;
			sheet = workbook.getSheetAt(0);
			// create a for loop to iterate in the sheet of rows and columns
			for (int i = 1; i<= sheet.getLastRowNum(); i++) {
				ChromeOptions chromeOptions = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver(chromeOptions);
				// launch the url
				driver.get("https://www.facebook.com/login");
				driver.manage().window().maximize();
				// import  the username from the excel sheet
				cell = sheet.getRow(i).getCell(0);
				WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
				email.sendKeys(cell.getStringCellValue());
				cell = sheet.getRow(i).getCell(1);
				WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
				password.sendKeys(cell.getStringCellValue());
			}
		}
	}

	 
