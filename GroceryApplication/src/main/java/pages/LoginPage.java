package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class LoginPage {
public WebDriver driver;
	WaitUtility wu= new WaitUtility();
	public LoginPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialise elements with PageFactory class
		
	}
	@FindBy(name="username") WebElement username; // annotation in Pagefactory to find elements
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath ="//b[text()='7rmart supermarket']") WebElement logintext;
	
	
	//public void enterusername(String usernamevalue )
	public LoginPage enterusername(String usernamevalue )
	{
		
		username.sendKeys(usernamevalue);
		return this;
	}
	
	//public void enterpassword(String passwordvalue)
	public LoginPage enterpassword(String passwordvalue)
	{
		
		password.sendKeys(passwordvalue);
		return this;
	}
	
	//public void clicklogin()
	public HomePage clicklogin()
	{
		wu.waitUntilElementToBeClickable(driver, signin);
		signin.click();
		return new HomePage(driver);
	}
	
	public boolean dashboarddisplayed()
	
	{
		return dashboard.isDisplayed();
		
	}
	
	public String logintextdisplay()
	{
		
		 return logintext.getText();
	}
	
}

