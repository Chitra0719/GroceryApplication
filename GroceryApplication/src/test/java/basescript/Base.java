package basescript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utility.ScreenshotUtility;

public class Base {

public WebDriver driver;
    Properties prop;
    FileInputStream filei;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	
	public void initialisebrowser(String browsers) throws IOException
	{   prop = new Properties();
	    filei = new FileInputStream(Constant.CONFIGFILE);
	    prop.load(filei);
		if(browsers.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		
	}
	else if(browsers.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
		
	}
	else if(browsers.equalsIgnoreCase("edge"))
	{
		driver = new EdgeDriver();
		
	}
	
				
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login"); // to get the url
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize(); // to maximise the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closebrowser(ITestResult itestresult) throws IOException// lifecycle of a testcase( pass or fail or skip)  is managed by ITestResult interface
	{
		if(itestresult.getStatus()== ITestResult.FAILURE) // checking only failed testcase
		{
			ScreenshotUtility screenshotutility = new ScreenshotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName()); // failed testcase methodname is fetched using getName 
			
		
		}
		
	}	
	
}