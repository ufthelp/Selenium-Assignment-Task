/**
 * 
 */
package com.app.Modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * @author MS
 *Setup for reading application objects from OR file
 */
public class ReadOR {
	 //Creating properties object
	private static final Properties PROPERTY = new Properties();
	//Setter method for OR
	public static void LoadObjects(){
	 //Creating the File Object
	  File file = new File(System.getProperty("user.dir")+ ConstantValues.PROPERTIESPATH +".properties");
	  //Creating InputStream object to read data
	   FileInputStream objInput = null;
	   try {
		    objInput = new FileInputStream(file);
		    //Reading properties key/values in file
		    PROPERTY.load(objInput);
			//Closing the InputStream
			objInput.close();
			} catch (FileNotFoundException e) {
			 Log.error("Inside OR class"+e.getMessage());
			 Runtime.getRuntime().halt(0);
				     
			} catch (IOException e) {
			 Log.error("Inside OR class "+e.getMessage());
			 Runtime.getRuntime().halt(0);
		  }

	}
	
	//Getter method for OR class
	public static Properties ReadObjects(){
		 return PROPERTY; 
	}
}

