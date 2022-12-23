package com.excelr.module3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3 {
	WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();

	}

	@Test (groups = "Smoke Test")  
	public void clickForms() throws Exception
	{
		driver.findElement(By.xpath("//h5[contains(text(),'Forms')]")).click();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("soumyadeep.biswal@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();

	}
	
//	@Test (priority = 2, groups = "Smoke Test") 
//	public void clickPracticeForms() throws Exception
//	{
//		driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();
//		
//	}
	
	@Test (groups = "Regression") 
	public void FillForm() throws Exception
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("soumyadeep.biswal@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
