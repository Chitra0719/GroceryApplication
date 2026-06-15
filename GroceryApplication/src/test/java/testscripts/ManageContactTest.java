package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basescript.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utility.ExcelUtility;
import utility.RandomDataUtility;

public class ManageContactTest extends Base {
	ManageContactPage m;
	HomePage h ;
	@Test(description="User is trying to update contact")
	public void verifyuserisabletoupdatecontacts() throws IOException
	{
				
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginCredentials");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginCredentials");
		String addressvalue = ExcelUtility.readStringData(0, 0, "Address");
		RandomDataUtility rd = new RandomDataUtility();
		//TestScriptExecutor ts = new TestScriptExecutor();
		String updatephonenumber = rd.generatephonenumber();
		String updateemailaddress= rd.generateemailid();
		LoginPage l = new LoginPage(driver);
		
		//ManageContactPage m = new ManageContactPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue);
		h=l.clicklogin();
		m=h.managecontactinfoclick();
		m.contactupdateclick().clearupdatenewphonenum().updatenewphonenum(updatephonenumber).clearupdateemail().updateemailid(updateemailaddress).clearupdateaddress().updateaddress(addressvalue).verifyjavascriptforcontactupdateclick();
		boolean alertmessage = m.contactupdatesucessfullyalert();
	    Assert.assertTrue(alertmessage,Constant.UNABLETOUPDATECONTACTERROR);
	}

}


// update button click  - use javascript executor