package com.excelr.module4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import com.excelr.itechnotionsPage.Home;
import com.excelr.itechnotionsPage.vdoctors;

public class Assignment2 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//Open the Chrome Browser
		driver = new  ChromeDriver();

		//Maximize windows
		driver.manage().window().maximize();

		//Navigate to url
		driver.get("https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Home h = new Home(driver);
		h.retrieveHeaders();
		h.clickVdoctors();
		
		
		vdoctors vd = new vdoctors(driver);
		vd.retrieveFeatures();
		vd.retrieveTechnologies();
		vd.getQuote();
		vd.FillForm();
		
		
		
		
		
	}

}
