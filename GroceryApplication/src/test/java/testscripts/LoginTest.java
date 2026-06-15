package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basescript.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
    
public class LoginTest extends Base {
	HomePage home;
	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "Smoke" })

	public void verifyuserloginwithvalidcredential() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginCredentials");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginCredentials");
		LoginPage l = new LoginPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue);
		//l.enterpassword(passwordvalue);
		//l.clicklogin();
		home= l.clicklogin();
		boolean dashboardvalue = l.dashboarddisplayed();
		//Assert.assertTrue(dashboardvalue, "User is unable to login with valid credentials");
		Assert.assertTrue(dashboardvalue,Constant.VALIDCREDENTIALERROR);
		

	}

	@Test(priority = 2, description = "User is trying to login with invalid credentails", retryAnalyzer = retry.Retry.class)
	public void verifyuserloginwithinvalidcredential() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(1, 0, "LoginCredentials");
		String passwordvalue = ExcelUtility.readStringData(1, 1, "LoginCredentials");
		LoginPage l = new LoginPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue).clicklogin();
		String Actual = l.logintextdisplay();
		String Expected = "7rmart supermarket";
		Assert.assertEquals(Actual, Expected, Constant.INVALIDCREDENTIALERROR);

	}

	@Test(priority = 3, description = "User is trying to login with invalid user name")

	public void verifyuserloginwithinvalidusername() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(2, 0, "LoginCredentials");
		String passwordvalue = ExcelUtility.readStringData(2, 1, "LoginCredentials");
		LoginPage l = new LoginPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue).clicklogin();
		String Actual = l.logintextdisplay();
		String Expected = "7rmart supermarket";
		Assert.assertEquals(Actual, Expected, Constant.INVALIDUSERNAMEERROR);
	}

	@Test(priority = 4, description = "User is trying to login with invalid password", groups = {
			"Smoke" }, dataProvider = "loginData")

	public void verifyuserloginwithinvalidpassword( String usernamevalue, String passwordvalue) throws IOException {
		// String usernamevalue = ExcelUtility.readStringData(3, 0, "LoginCredentials");
		// String passwordvalue = ExcelUtility.readStringData(3, 1, "LoginCredentials");
		LoginPage l = new LoginPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue).clicklogin();
		String Actual = l.logintextdisplay();
		String Expected = "7rmart supermarket";
		Assert.assertEquals(Actual, Expected, Constant.INVALIDPASSWORDERROR);

	}

	@DataProvider(name = "loginData")
	public Object[][] getdatafromdataprovider() {
		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "admin123" },

		};

	}
}
