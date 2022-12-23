package com.excelr.module2;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_2 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new  ChromeDriver();

		driver.manage().window().maximize();

		//Navigating to the site
		driver.get("http://demo.guru99.com/popup.php");
		
		//Click on Click here
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		// Code to fetch the address of Parent Tab
		String P_addr = driver.getWindowHandle();
		System.out.println(P_addr);
		
		// Code to fetch the address of Parent Tab as well as Child Tab
		Set<String> P_C_addr = driver.getWindowHandles();
		System.out.println(P_C_addr);
		
		ArrayList<String> a = new ArrayList<String>(P_C_addr);
		System.out.println(a);
		
		driver.switchTo().window(a.get(1));
		
		WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
		Thread.sleep(5000);
		email.sendKeys("soumyadeep.biswal@gmail.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Thread.sleep(5000);
		driver.close();
	}

}
