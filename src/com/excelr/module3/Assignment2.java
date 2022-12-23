package com.excelr.module3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment2 {
	public static WebDriver driver;

	// Establishing the Connection from Property File to Java File
	public static FileInputStream fis = new FileInputStream("D:\\eclipse-workspace\\Assignments\\src\\com\\excelr\\utilities\\Assignment2.properties");

	// Creation of Properties object to load the data
	public static Properties prop = new Properties();
	prop.load(fis);

	//Fetching the data from a Property File
	public static	String url_data = prop.getProperty("url");
	public static String email_id_data = prop.getProperty("email");
	public static String pwd_data = prop.getProperty("password");

	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();

		driver.get(url_data);
	}

	@Test
	public void Credentails1() throws Exception
	{

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email_id_data);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(pwd_data);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
