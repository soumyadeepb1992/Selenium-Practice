package com.excelr.module2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment3 {
	public static WebDriver driver;
	
	public static void takeScreenShot(String fileName) throws IOException
	{
		// take the ScreenShot and store it as a file format
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Copy the ScreenShot to the desired Location using copy()
		FileHandler.copy( f , new File("C:\\Users\\1304235\\Desktop\\ExcelR\\Assignments\\Module2\\Assignment3\\"+fileName+".jpg") );
		
	}

	public static void main(String[] args) throws IOException {
		driver = new  ChromeDriver();

		//Navigating to the site
		driver.get("https://jqueryui.com/");

		driver.manage().window().maximize();
		
		//Click on Draggable
		driver.findElement(By.xpath("//a[contains(text(),'Draggable')]")).click();
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Screenshot before dragging
		takeScreenShot("BeforeDragging");
		
		//Locating frame1 using its id
        WebElement frame1 = driver.findElement(By.className("demo-frame"));
        
      //Switching the WebDriver context to frame1
        driver.switchTo().frame(frame1);
		
		WebElement dragMeAround = driver.findElement(By.xpath("//div[@id='draggable']"));
		//WebElement dragText = driver.findElement(By.xpath("//p[contains(text(),'Drag me around')]"));
		
		Actions a = new Actions(driver);
		a.dragAndDropBy(dragMeAround, 150, 150).perform();
		//a.moveToElement(dragText).clickAndHold().pause(3000).moveByOffset(150, 150).release().build().perform();
		
		//screenshot after dragging
		takeScreenShot("AfterDragging");
		
		driver.close();

	}

}
