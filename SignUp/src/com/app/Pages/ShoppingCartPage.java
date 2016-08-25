/**
 * 
 */
package com.app.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.Modules.Log;
import com.app.Modules.ReadOR;

/**
 * @author MS
 *Verify the cost is  $18.51 with tax included
 */
public class ShoppingCartPage {
	WebDriver driver;
	//Getting the OR Object
	private static final Properties ELEMENTS = ReadOR.ReadObjects();
	public ShoppingCartPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public String verifyShoppingCost() throws Exception{
		try{
			return driver.findElement(By.id(ELEMENTS.getProperty("ShoppingCartPage.lblTotalPrice"))).getText();
			}catch (Exception e){
    	 
			// Printing logs for my report
           Log.error("Shopping Cart Page not tested");
			// Taking screenshot for defect reporting
			Log.takeScreenshot(driver,"Make a Purchase" );
           throw(e);

       }
	}
}
