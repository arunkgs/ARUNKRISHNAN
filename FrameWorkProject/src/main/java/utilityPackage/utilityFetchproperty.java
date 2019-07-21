package utilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utilityFetchproperty {
		public static Object fetchpropertyvalue(String key) throws IOException
		{
			//For establishing the connection between the file
			FileInputStream file=new FileInputStream("./config/config.properties");
			// Creating an object of the property class
			Properties property=new Properties();
			//First we are loading the required file
			property.load(file);
			//Since we are having the data in property file as key and value pair we are passing
			return property.get(key);
		}
		public static String fetchlocatorvalue(String key) throws IOException
		{
			//For establishing the connection between the file
			FileInputStream file=new FileInputStream("./config/element.properties");
			// Creating an object of the property class
			Properties property=new Properties();
			//First we are loading the required file
			property.load(file);
			//Since we are having the data in property file as key and value pair we are passing
			return property.get(key).toString();
		}	

}
