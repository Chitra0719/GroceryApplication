package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basescript.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class HomeTest extends Base{
	
	HomePage h;
	@Test(description="User is trying to logout from application")
	public void verifyifUserisabletosuccessfullyLoggedout() throws IOException
	{
	 String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginCredentials");
	 String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginCredentials");
	 LoginPage l = new LoginPage(driver);
	 //HomePage h = new HomePage(driver);
     l.enterusername(usernamevalue).enterpassword(passwordvalue);
     h=l.clicklogin();
     h.adminclick();
     l= h.logoutclick();
     String Actual = l.logintextdisplay();
     String Expected = "7rmart supermarket";
     Assert.assertEquals(Actual, Expected, Constant.UNABLETOLOGOUTERROR);
	}
} 
