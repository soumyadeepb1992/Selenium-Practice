package com.excelr.module2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new  ChromeDriver();
		driver.manage().window().maximize();

		//Navigating to the site
		driver.get("https://demo.guru99.com/test/web-table-element.php");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		List<WebElement> list = driver.findElements(By.xpath("//div[@id=\"leftcontainer\"]/table/tbody/tr/td[1]/a")); 
		
		//Total number of companies
		System.out.println("Total number of Companies = " + list.size());
		for(int i=0; i<list.size();i++) {
			String text =list.get(i).getText();
			
			//Display all company names
			System.out.println(text);

		}
		
		//navigate to guru99 page
		driver.navigate().to("https://demo.guru99.com/test/login.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
		//Enter email id
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("poojappm30@gmail.com");
		
		//Entering Password
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345");
		
		//Click Sign in Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		
	}
}
