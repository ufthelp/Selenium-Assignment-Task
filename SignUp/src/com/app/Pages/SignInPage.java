package com.app.Pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.app.Modules.Log;
import com.app.Modules.ReadOR;

/**
 * @author MS
 *Click on SignIn Button -> Launch "Create Account Page"
 */
public class SignInPage {
	WebDriver driver;
	//Getting the OR Object
	private static final Properties ELEMENTS = ReadOR.ReadObjects();
	public SignInPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void clickSignInButton() throws Exception{
		try{
			driver.findElement(By.className(ELEMENTS.getProperty("SignInPage.btnSignIn"))).click();
			}catch (Exception e){
    	 
			// Printing logs for my report
            Log.error("SignIn button not found.");
			// Taking screenshot for defect reporting
			Log.takeScreenshot(driver,"Make a Purchase" );
			throw(e);

       }
	}


}
