/**
 * 
 */
package com.app.Modules;
import java.io.File;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;


/**
 * @author MS
 *Configure Log4j for creating run logs of test cases in external file
 */
public class Log {
	// Initialize Log4j logs
	 private static Logger Log = Logger.getLogger(Log.class.getName());//
	 
	 // Beginning of test case
	 
	 public static void startTestCase(String sTestCaseName){
	 
			 
		Log.info("****************************************************************************************");
	 
		Log.info("************************                "+sTestCaseName+ "       ***********************");
	 
		Log.info("****************************************************************************************");
	 
	 
		}
	 
		//Ending of Test case execution
	 
	 public static void endTestCase(){
	 
		Log.info("***********************            "+"-E---N---D-"+"            ***********************");
	 
		Log.info("X");
	 

	 
		}
	 //Creating the log4j methods
	 public static void info(String message) {

			Log.info(message);

			}

	 public static void warn(String message) {

	    Log.warn(message);

		}

	 public static void error(String message) {

	    Log.error(message);

		}

	 public static void fatal(String message) {

	    Log.fatal(message);

		}

	 public static void debug(String message) {

	    Log.debug(message);

		}
	 //Taking the screenshots of error
	 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		 
			try{

				File sScreenShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(sScreenShot , new File(ConstantValues.PathScreenShot + sTestCaseName +".jpg"));	
				

			} catch (Exception e){

				Log.error("Exception occured while capturing ScreenShot : "+e.getMessage());

				throw new Exception();

			}

		}

	}

