package com.excelr.module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2Part2 {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = new  ChromeDriver();

		//Navigating to the site
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().window().maximize();

		// Selecting the drop-down 
		Select drop_Down = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		// matching the desired option[ KUWAIT]
		drop_Down.selectByVisibleText("KUWAIT");	

	}

}
