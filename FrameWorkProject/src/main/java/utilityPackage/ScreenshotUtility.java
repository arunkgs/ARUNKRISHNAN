package utilityPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static String getScreenshot(WebDriver driver) throws IOException {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		    /*File is an pre existing class from java.io package,this will take a screenshot and keep it in a memory*/
		    File source=ts.getScreenshotAs(OutputType.FILE);
		    /* . operator points to the current working directory in which u r working*/
		    String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".jpg";
		    File destination=new File(path);
		    /*FileUtils is a class with many methods*/
		    FileUtils.copyFile(source,destination);
		   // we are returning the path so that this can be attached in the extent report
		return path;
		// TODO Auto-generated method stub

	}

	
}
  
