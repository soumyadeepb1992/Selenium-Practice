package com.excelr.module4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int numOfRows;
	public static String action;
	public static String data;

	public static String getCellValues(int rownum,int cellnum) {
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		data = cell.getStringCellValue();
		return data;

	}


	public static void main(String[] args) throws IOException, InterruptedException {

		fis = new FileInputStream("D:\\eclipse-workspace\\Assignments\\src\\com\\excelr\\utilities\\Credentials.xlsx");
		book = new XSSFWorkbook(fis);
		sheet = book.getSheetAt(0);

		//To fetch the number of rows
		numOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(numOfRows);

		for (int i = 1; i < numOfRows; i++)
		{
			action = getCellValues(i,2);
			System.out.println(action);	

			switch(action)

			{
			case "open":
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				break;

			case "navigate":
				driver.get(getCellValues(i,4));
				break;

			case "click":
				driver.findElement(By.xpath(getCellValues(i,3))).click();
				Thread.sleep(5000);
				// Switching to Alert Window       
				Alert a = driver.switchTo().alert();

				// Capturing alert message.    
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				String alertMessage= driver.switchTo().alert().getText();	
				System.out.println(alertMessage);	


				// Accepting the alert		
				a.accept();	 // to click on ok button
				Thread.sleep(5000);
				break;



			case "type":
				driver.findElement(By.xpath(getCellValues(i,3))).sendKeys(getCellValues(i,4));
				break;

			case "quit":
				driver.quit();
				break;

			}	


		}
	}
}	
