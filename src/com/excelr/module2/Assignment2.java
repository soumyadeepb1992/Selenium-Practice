package com.excelr.module2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new  ChromeDriver();

		driver.manage().window().maximize();

		//Navigating to the site
		driver.get("https://demo.guru99.com/test/delete_customer.php");

		//Entering CustomerID
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("54321");

		//Click Submit in Button
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		// Switching to Alert Window       
		Alert a = driver.switchTo().alert();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String alertMessage= driver.switchTo().alert().getText();	
		System.out.println(alertMessage);	
		
		// Accepting the alert		
		a.accept();	
		Thread.sleep(4000);
		a.accept();
		Thread.sleep(4000);
		driver.close();

	}

}
