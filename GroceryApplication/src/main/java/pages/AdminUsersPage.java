package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.PageUtility;

public class AdminUsersPage {
	
	public WebDriver driver;
	PageUtility pu;
	public AdminUsersPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialise elements with PageFactory class
		
	}
	
    @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement addnewuser;
    @FindBy(id="username") WebElement enternewusername;
    @FindBy(id="password") WebElement enternewuserpassword;
	@FindBy(id="user_type") WebElement selectusertype;
	@FindBy(name="Create") WebElement savebutton;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchusers;
	@FindBy(id="un") WebElement searchusernames;
	@FindBy(id="ut") WebElement searchusertypes;
	@FindBy(name="Search") WebElement clicksearch;
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']") WebElement sucessalert;
	@FindBy(xpath="//button[@name='Search']") WebElement usersearchbutton;

    public AdminUsersPage addnewuserbutton()
{
	
	addnewuser.click();
	return this;
}
    
    public AdminUsersPage enternewusernames(String newusername)
    {
    	enternewusername.sendKeys(newusername);
    	return this;
    }
    
    public AdminUsersPage enternewuserpasswords(String newpassword)
    {
    	
    	enternewuserpassword.sendKeys(newpassword);
    	return this;
    	
    }
    
    public AdminUsersPage selectusertypefromdropdown()
    {
    	pu.selectBytext(selectusertype, "Admin");
    	//Select s = new Select(selectusertype);
    	//s.selectByVisibleText("Admin");
    	return this;
    }
    
    public AdminUsersPage clicksave()
    {
    	
    	savebutton.click();
    	return this;
    	
    }
    
    public AdminUsersPage clicksearchusers()
    {
    	
    	searchusers.click();
    	return this;
    }
    
    public AdminUsersPage enterusernametosearch(String searchusername)
    {
    	searchusernames.sendKeys(searchusername);
    	return this;
    	
    }
    
    public AdminUsersPage dropdownusertypetosearch()
    {    pu.selectBytext(searchusertypes, "Admin");
    	//Select r = new Select(searchusertypes);
    	//r.selectByVisibleText("Admin");
    	return this;
    }
    public AdminUsersPage clicksearchbutton()
    {
    	clicksearch.click();
    	return this;
    	
    }
    public boolean newuseraddedsucessfullyalert()
	{
	
	return sucessalert.isDisplayed();
	}
    
    public boolean newusersearch()
 	{
 	
 	return usersearchbutton.isDisplayed();
 	}
     
    
    
}
