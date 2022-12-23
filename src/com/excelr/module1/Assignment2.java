package com.excelr.module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new  ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigating to the site
		driver.get("https://demo.guru99.com/test/radio.html");
		
		//Finnding and selecting Option 1
		driver.findElement(By.xpath("//input[@type='radio' and @id='vfb-7-1']")).click();
		
		//Finnding and selecting Checkbox 2 and 3
		driver.findElement(By.xpath("//input[@type='checkbox' and @id='vfb-6-1']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox' and @id='vfb-6-2']")).click();
		
	}

}
