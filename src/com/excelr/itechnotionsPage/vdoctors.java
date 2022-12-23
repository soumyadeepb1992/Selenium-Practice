package com.excelr.itechnotionsPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class vdoctors {
public WebDriver driver;
By name = By.xpath("//input[@name='firstname']");
By email = By.xpath("//input[@name='email']");
By country = By.xpath("//input[@name='country']");
By message = By.xpath("//textarea[@class='hs-input']");
By basic_Android = By.xpath("//input[@id='voomplatform0-e83e7559-32cd-4d21-8fe5-970edce9bc8e']");
By premium_Android = By.xpath("//input[@id='voomplatform1-e83e7559-32cd-4d21-8fe5-970edce9bc8e']");
By business_Android = By.xpath("//input[@id='voomplatform2-e83e7559-32cd-4d21-8fe5-970edce9bc8e']");
By custom_dev = By.xpath("//input[@id='voomplatform3-e83e7559-32cd-4d21-8fe5-970edce9bc8e']");
By others = By.xpath("//input[@id='voomplatform4-e83e7559-32cd-4d21-8fe5-970edce9bc8e']");
By submit = By.xpath("//input[@type='submit']");
	
	public vdoctors(WebDriver driver){
	
		this.driver = driver;
	}
	
	public void retrieveFeatures() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement features = driver.findElement(By.xpath("//a[contains(text(),'Features')]"));
		features.click();

		//Creating list of all features
		List<WebElement> allFeatures = driver.findElements(By.xpath("//div[@class='col-md-6 col-12']/descendant::h4[@class='title']"));

		//Printing size of list of features
		System.out.println("Total number of Features = " + allFeatures.size());



		//we can run for loop to fetch the features
		//		for(int i=0; i<allFeatures.size();i++) {
		//			String text =allFeatures.get(i).getText();
		//			System.out.println(text);

		//Printing all Features using JS executor
		for (WebElement feature : allFeatures){    
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", feature);
			System.out.println(feature.getText());
		}
	}
	
	public void retrieveTechnologies() {
		//Technologies
		
				WebElement technology = driver.findElement(By.xpath("//a[contains(text(),'Technology')]"));
				technology.click();

				//Creating list of all Technologies
				List<WebElement> alltechnos = driver.findElements(By.xpath("(//div[@class='section-title ml-lg-5']/descendant::ul[@class='list-unstyled text-muted'])[3]"));

				//Printing size of list of Technologies
				System.out.println("Total number of Technologies = " + alltechnos.size());



				//we can run for loop to fetch the Technologies
//						for(int i=0; i<alltechnos.size();i++) {
//							String text =alltechnos.get(i).getText();
//							System.out.println(text);

				//Printing all Technologies using JS executor
				for (WebElement techno : alltechnos){    
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", techno);
					System.out.println(techno.getText());
				}
	}
	
	public void getQuote() {
		driver.findElement(By.xpath("(//a[contains(text(),'Get Quote')])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void FillForm() {
		//Locating frame1 using its id
        WebElement frame1 = driver.findElement(By.className("hs-form-iframe"));
        
      //Switching the WebDriver context to frame1
        driver.switchTo().frame(frame1);
		driver.findElement(name).sendKeys("Soumyadeep Biwal");
		driver.findElement(email).sendKeys("soumyadeep.biswal@gmail.com");
		driver.findElement(country).sendKeys("India");
		driver.findElement(message).sendKeys("Test Form");
		driver.findElement(basic_Android).click();
		driver.findElement(business_Android).click();
		driver.findElement(others).click();
		
		//Click Submit Button
		driver.findElement(submit).click();
	}


}
