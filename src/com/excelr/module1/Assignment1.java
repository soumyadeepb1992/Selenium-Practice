package com.excelr.module1;


import java.time.Duration;
import java.util.Scanner;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment1 {

	public static WebDriver driver;
	public static String site;
	public static Scanner scan;
	public static String etitle;
	public static String atitle;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Enter site to verify: fB for Facebook or amazon for Amazon");
		scan = new Scanner(System.in);
		site = scan.next();

		if (site.equals("fb"))
		{
			//Open the Chrome Browser
			driver = new  ChromeDriver();
			driver.manage().window().maximize();

			/*
			 * I haven't mentioned system.setProperties as I have directly copied the drivers to the project
			We can select any of the following to invoke firefox/IE
			driver = new FirefoxDriver();
			driver = new InternetExplorerDriver();

			 */

			//Navigate to Facebook Application
			driver.get("https://www.facebook.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.manage().window().maximize();

			
			//Get The Title
			String title=driver.getTitle();
			System.out.println( title);
			
			//Verify The Title
			if (title.equals("Facebook – log in or sign up"))
			{
				System.out.println("Title is correct");
			}
			else {
				System.out.println("Title is incorrect");
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.navigate().to("http://www.google.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.navigate().back();
		}

		//Case : Amazon
		else if (site.equals("amazon"))
		{
			//Open the Chrome Browser
			driver = new  ChromeDriver();
			
			driver.manage().window().maximize();

			//Navigate to Amazon Application
			driver.get("https://www.amazon.in");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			//Get The Title
			String title=driver.getTitle();
			System.out.println( title);
			
			//Verify The Title
			if (title.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
			{
				System.out.println("Title is correct");
			}
			else {
				System.out.println("Title is incorrect");
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.navigate().to("http://www.google.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.navigate().back();

		}
		Thread.sleep(3000);
		driver.close();
	}

}
