/**
 * 
 */
package com.app.Modules;

/**
 * @author MS
 *Class contains all the constant values at the application level like URL
 */
public class ConstantValues {
	public static final String URL = "http://automationpractice.com/index.php";
	public static final String BROWSER = "chrome";
	//We can get this value from Excel also for easier maintenance of test data
	//As email value need to be new for each run so using random email values
	static int randomVal = (int)(Math.random()*9000)+1000;
	public static final String EMAILADDR = "TEST"+String.valueOf(randomVal)+"1234@gmail.com";
	public static final String BLUESHIRTCOST = "$18.51";
	//Screenshot path
	public static final String PathScreenShot =System.getProperty("user.dir")+ "\\ScreenShot\\";
	//TC Name
	public static final String TC001 = "Make a Purchase";
	//Object Repo path
	public static final String PROPERTIESPATH ="\\src\\com\\app\\Pages\\OR";
	

}

