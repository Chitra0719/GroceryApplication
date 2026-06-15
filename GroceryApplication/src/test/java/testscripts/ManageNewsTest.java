package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basescript.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base{
	ManageNewsPage mn;
	HomePage h ;
	@Test(description="User is trying to add news")
	public void  verifyuserisabletoaddnews() throws IOException
	{
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginCredentials");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginCredentials");
		String newsvalue = ExcelUtility.readStringData(0, 0, "News");
		LoginPage l = new LoginPage(driver);
		
		//ManageNewsPage mn = new ManageNewsPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue);
		h= l.clicklogin();
		mn =h.managenewsinfoclick();
		mn.clicknewbutton().enternews(newsvalue).clicksavebutton();
		boolean alertmessage = mn.newsaddedsucessfullyalert();
	    Assert.assertTrue(alertmessage,Constant.UNABLETOADDNEWSERROR);		
				
	}
	
	@Test(description="User is searching for news")
	public void verifyuserisabletosearchnews() throws IOException
	{
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginCredentials");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginCredentials");
		String newsvalue = ExcelUtility.readStringData(0, 0, "News");
		LoginPage l = new LoginPage(driver);
		//ManageNewsPage mn = new ManageNewsPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue);
		h =l.clicklogin();
		mn= h.managenewsinfoclick();
		mn.clicksearch().enternewstosearch(newsvalue).searchclickfornews();
		boolean alertmessage = mn.newsfoundalert();
	    Assert.assertTrue(alertmessage,Constant.UNABLETOSEARCHNEWSERROR);
		
	}
	

}
