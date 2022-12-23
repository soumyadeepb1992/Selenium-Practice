package com.excelr.itechnotionsPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home {
	public  WebDriver driver;


	public Home(WebDriver driver)
	{
		this.driver = driver;
	}

	public void retrieveHeaders()
	{
		//List of H3 headers		
		List<WebElement> headers3 = driver.findElements(By.xpath("//h3[@class='entry-title']"));
		System.out.println("Total number of headers3 = " + headers3.size());

		//List of H5 headers at top
		List<WebElement> headers5_top = driver.findElements(By.xpath("//div[@class='vc_row wpb_row vc_row-fluid cus_pad_top']/descendant::h5[@class='section-title']"));
		System.out.println("Total number of headers5_top = " + headers5_top.size());

		//List of H5 headers
		List<WebElement> headers5 = driver.findElements(By.xpath("//div[@class='vc_row wpb_row vc_row-fluid cus_pad']/descendant::h5[@class='section-title']"));
		System.out.println("Total number of headers5 = " + headers5.size());

		//Common Header to merge all headers
		List<WebElement> headers = new ArrayList<WebElement>();

		//Merging all headers
		headers.addAll(headers3);
		headers.addAll(headers5_top);
		headers.addAll(headers5);

		//Printing all headers using JS executor
		for (WebElement header : headers){    
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", header);
			System.out.println(header.getText());
		}

	}
	public void clickVdoctors() {


		WebElement products = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle' and contains(text(),'Products')]"));
		WebElement vDoctors = driver.findElement(By.xpath("//ul[@class=' dropdown-menu']//li[@id='menu-item-5978']/a[contains(text(),'vDoctor')]"));
		Actions a = new Actions(driver);

		//Click on vDoctors from Products dropdown
		a.moveToElement(products).pause(3000).moveToElement(vDoctors).click().build().perform();
	}



}
