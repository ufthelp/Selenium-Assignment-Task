/**
 * 
 */
package com.app.Pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.app.Modules.ConstantValues;
import com.app.Modules.LaunchBrowser;
import com.app.Modules.Log;
import com.app.Modules.ReadOR;

/**
 * @author MS
 *Fill Email details -> Click Create an Account -> Fill personal details
 */
public class CreateAnAccountPage {
	WebDriver driver;
	//Getting the OR Object
	private static final Properties ELEMENTS = ReadOR.ReadObjects();
	public CreateAnAccountPage(WebDriver driver){
		this.driver = driver;
		
	}
	public void fillEmailAddress() throws Exception{
		try{
			//Synchronization for Create Account page to be displayed
			LaunchBrowser.waitForElement(driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtEmailAddress"))),20);
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtEmailAddress"))).sendKeys(ConstantValues.EMAILADDR);
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.btnCreateAccount"))).click();
		}catch (Exception e){
			 // Printing logs for my report
			 Log.error("Not able to fill Email Address"+e.getMessage());
			 System.out.println(e.getMessage());
			// Taking screenshot for defect reporting
			Log.takeScreenshot(driver,"Make a Purchase" );
			throw(e);

       }
	}
	
	public String fillPersonalInfoMissingZip() throws Exception{
		try{
			//Synchronization for Personal page to be displayed
			driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
			LaunchBrowser.waitForElement(driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtFirstName"))),20);
			//Thread.sleep(3000);
			//LaunchBrowser.waitForElement(driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtFirstName"))));
			//Filling the Mandatory fields
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtFirstName"))).sendKeys("Rob");
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtLastName"))).sendKeys("Paul");
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtPwd"))).sendKeys("test@123");
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtAddress"))).sendKeys("23 Victoria");
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtCity"))).sendKeys("Swiss");
			new Select(driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.drpdwnState")))).selectByVisibleText("Alaska");
			new Select(driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.drpdwnCountry")))).selectByVisibleText("United States");
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtMobilePhone"))).sendKeys("1234567890");
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.btnRegister"))).click();
			//Capture the Error Message for Missing Postal Code
			return driver.findElement(By.xpath(ELEMENTS.getProperty("CreateAnAccountPage.errZipCode"))).getText();
		}catch (Exception e){
			 // Printing logs for my report
			   Log.error("Not able to fill Email Address");
			// Taking screenshot for defect reporting
			Log.takeScreenshot(driver,"Make a Purchase" );
			throw(e);
		}
       }
		
		public void fillPostalCode() throws Exception{
			try{
				//Filling the Zip Code/Pwd and Clicking the Register
				driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtPostalCode"))).sendKeys("12345");
				driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.txtPwd"))).sendKeys("test@123");
				driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.btnRegister"))).click();
			}catch (Exception e){
				 // Printing logs for my report
				   Log.error("Not able to fill Email Address");
				// Taking screenshot for defect reporting
				Log.takeScreenshot(driver,"Make a Purchase" );
				throw(e);

	       }
	}
	
}
