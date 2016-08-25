/**
 * 
 */
package com.app.Pages;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

import com.app.Modules.LaunchBrowser;
import com.app.Modules.Log;
import com.app.Modules.ReadOR;

/**
 * @author MS
 *Select the blue T-shirt Medium size 
 */
public class SelectTShirtPage {
	WebDriver driver;
	//Getting the OR Object
	private static final Properties ELEMENTS = ReadOR.ReadObjects();
	public SelectTShirtPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void selectBlueTShirt() throws Exception{
		try{
			//Click Tshirt
			driver.findElement(By.xpath(ELEMENTS.getProperty("SelectTShirtPage.lblTShirts"))).click();
			Log.info("T-Shirt menu option is Selected");
			//Synchronization
			LaunchBrowser.waitForElement(driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.lblBlueColor"))),20);
			//Select Blue Color
			driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.lblBlueColor"))).sendKeys(Keys.ENTER);
			//driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.lblBlueColor"))).click();
			Log.info("Selected Blue color");
			new Select(driver.findElement(By.id(ELEMENTS.getProperty("CreateAnAccountPage.drpdwnSize")))).selectByVisibleText("M");
			Log.info("Select Medium Size");
			//Add to Cart
			driver.findElement(By.name(ELEMENTS.getProperty("CreateAnAccountPage.btnAddToCart"))).click();
			Log.info("Item is added to cart");
			//Synchronization 
			LaunchBrowser.waitForElement(driver.findElement(By.xpath(ELEMENTS.getProperty("CreateAnAccountPage.btnCheckout"))),20);
			//Proceed to Checkout
			driver.findElement(By.xpath(ELEMENTS.getProperty("CreateAnAccountPage.btnCheckout"))).click();
			Log.info("Proceed to Checkout");
		}catch (Exception e){
    	 
			// Printing logs for my report

           Log.error("Not able to Select Blue Shirt");

			// Taking screenshot for defect reporting

			Log.takeScreenshot(driver,"Make a Purchase" );

		     throw(e);

       }
	}
}
