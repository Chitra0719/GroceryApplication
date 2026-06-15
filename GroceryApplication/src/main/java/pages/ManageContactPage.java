package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class ManageContactPage {
	
public WebDriver driver;
PageUtility put = new PageUtility();
	public ManageContactPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialise elements with PageFactory class
		
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']") WebElement updatebutton;
	@FindBy(id="phone") WebElement phonenumber;
	@FindBy(id="email") WebElement mailid;
	@FindBy(xpath="//textarea[@id='content' and @ name='address']") WebElement address;
	@FindBy(xpath="//button[@type='submit' and @ name='Update']") WebElement updatecontact;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement updatealert;
	
	public ManageContactPage contactupdateclick()
	{
		updatebutton.click();
		return this;
		 
	}
	public ManageContactPage clearupdatenewphonenum()
	{
		phonenumber.clear();
		return this;
		 
	}
		
	 public ManageContactPage updatenewphonenum(String updatenumber)
	    {
	    	
		 phonenumber.sendKeys(updatenumber);
		 return this;
	    	
	    }
	 
	 public ManageContactPage clearupdateemail()
		{
		 mailid.clear();
		 return this;
			 
		}
	 public ManageContactPage updateemailid(String updateemail)
	    {
	    	
		 mailid.sendKeys(updateemail);
		 return this;
	    	
	    }
	 public ManageContactPage clearupdateaddress()
		{
		 address.clear();
		 return this;
			 
		}
	  public ManageContactPage updateaddress(String addressupdate)
	    {
	    	
		  address.sendKeys(addressupdate);
		  return this;
	    	
	    }
	  public ManageContactPage clickupdate()
	  {
		  
		  updatecontact.click();
		  return this;
	  }
		
	  public ManageContactPage  verifyjavascriptforcontactupdateclick()
	    {
		  put.clickthrujavascript(updatecontact, driver);
		  
	
		  return this;
	    }
	  
	  public boolean contactupdatesucessfullyalert()
		{
		
		return updatealert.isDisplayed();
		}
	}
	

