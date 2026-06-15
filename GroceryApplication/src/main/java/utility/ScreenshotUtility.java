package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException // passing driver and failedTestcase string as parameters
	{
		TakesScreenshot scrShot = (TakesScreenshot) driver; // take screenshot predefined interface 
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); // storing screenshot captured temporarily
		
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenshot//"); // folder to store the screenshots
		if (!f1.exists()) {
			
			f1.mkdirs();
		}
		
		String destination = System.getProperty("user.dir") + "//outputScreenshot//" + failedTestCase + timeStamp +".png";
		// stored failed testcase method name timestamp and in png format
		File finalDestination = new File(destination); //  store in final destination 
		FileHandler.copy(screenShot, finalDestination);
	}

}
