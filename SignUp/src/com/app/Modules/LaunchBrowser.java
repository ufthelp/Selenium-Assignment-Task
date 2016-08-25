/**
 * 
 */
package com.app.Modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author MS
 *Common module which launches the application in given browser type 
 **/
public class  LaunchBrowser {
	static WebDriver driver;

	public static WebDriver  startBrowser(String browserName, String url){
		//Create driver object based on the browser type
		switch (browserName.toLowerCase()){
			case "ff":
			case "firefox":
				driver = new FirefoxDriver();
			break;
		
			case "ch":
			case "chrome":
				System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			
			case "ie":
			case "internetexplorer":
				//System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
				//driver = new InternetExplorerDriver();
			break;
			
			default:
				Log.error("Invalid browser name " + browserName);
				System.exit(0);
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	
	}
	 //Synchronization method
	 public static void waitForElement(WebElement ElementTobeFound,int seconds){
		 
		 WebDriverWait wait = new WebDriverWait(driver, seconds);
		 wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
		 // Log.info("Wait called Successfully");
	 	}
	
}
