package com.app.TestCases;
import org.testng.annotations.Test;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.app.Modules.ConstantValues;
import com.app.Modules.LaunchBrowser;
import com.app.Modules.Log;
import com.app.Modules.ReadOR;
import com.app.Pages.CreateAnAccountPage;
import com.app.Pages.SelectTShirtPage;
import com.app.Pages.ShoppingCartPage;
import com.app.Pages.SignInPage;

/**
 * @author MS
 *Create New SignIn Account
 */
public class TC001_MakePurchase {

	//Creating local Variables
	public static WebDriver driver;
	
	//Pre-requisite for Test cases, Launching the APP,setting the log files,Loading OR files
	@BeforeMethod
	public void setUp(){
		//Creating the logs of Test case execution
		DOMConfigurator.configure("log4j.xml");	
		Log.startTestCase("TC_001_makeAPurchase");
		//Loading the properties file
		 ReadOR.LoadObjects();		       
		//Launch APP in given browser
		 driver = LaunchBrowser.startBrowser(ConstantValues.BROWSER,ConstantValues.URL);
		Log.info("Application launched successfully in "+ConstantValues.BROWSER);

	}
 
	// Starting the main test cases
  @Test
  public void MakeAPurchase() {
		try{
		   //Click on Sign in Button
			SignInPage signIn = new SignInPage(driver);
			signIn.clickSignInButton();
			Log.info("Clicked on SignIn Button");
			//Fill Email address
			CreateAnAccountPage accnt = new CreateAnAccountPage(driver);
			accnt.fillEmailAddress();
			Log.info("Clicked on Create Account Button");
			//Create an Account with missing Zip Code
			String errMsg = accnt.fillPersonalInfoMissingZip();
			//Verify that an error will occur if the Zip/Postal Code is ommitted during registration
			Assert.assertEquals(errMsg, "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
			Log.info("Missing Zip Code check passed");
			//Create account by filling the postal code
			accnt.fillPostalCode();
			//Verify that the a Blue Faded Shirt Sleeve T-shirt can be purchased in Medium size and delivered by “My carrier Delivery next day!
			SelectTShirtPage tShirt = new SelectTShirtPage(driver);
			tShirt.selectBlueTShirt();
			//Verify the cost is  $18.51 with tax included
			ShoppingCartPage cart = new ShoppingCartPage(driver);
			String cartValue = cart.verifyShoppingCost();
			Assert.assertEquals(cartValue,"$18.51");
			Log.info("Verified value of Cart");
			Log.info("End of Test Case");
		}catch(Exception e){
			Log.error("Test case failed "+e.getMessage());
			//throw (e);
		 }
		
  }
  
  //Destroying the driver object and end of Test case execution
  @AfterMethod
  public void afterMethod() {
	     Log.endTestCase();
	    // Closing the driver
	     driver.close();

  		}
}
