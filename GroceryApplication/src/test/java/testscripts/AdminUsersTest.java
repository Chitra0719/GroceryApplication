package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basescript.Base;
import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.RandomDataUtility;

public class AdminUsersTest extends Base {
	AdminUsersPage u;
	HomePage h ;
	@Test(description="User is trying to add new users")
	public void verifyuserisabletoaddnewusers() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginCredentials");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginCredentials");
		RandomDataUtility rd = new RandomDataUtility();
		String newusername = rd.fullusername();
		String newpassword = rd.randompassword();
		//String newusername = ExcelUtility.readStringData(2, 0, "NewUsers");
		//String newpassword = ExcelUtility.readStringData(2, 1, "NewUsers");
		LoginPage l = new LoginPage(driver);
		
		//AdminUsersPage u = new AdminUsersPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue);
		h= l.clicklogin();
		u=h.moreinfoclick();
		u.addnewuserbutton().enternewusernames(newusername).enternewuserpasswords(newpassword).selectusertypefromdropdown().clicksave();
		boolean alertmessage = u.newuseraddedsucessfullyalert();
	    Assert.assertTrue(alertmessage,Constant.UNABLETOADDNEWUSERSERROR);
	}

	@Test(description="User is trying to search users")
	public void verifyuserisabletosearchusers() throws IOException {

		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginCredentials");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginCredentials");
		String searchusername = ExcelUtility.readStringData(1, 0, "ExistingUserNames");
		LoginPage l = new LoginPage(driver);
		l.enterusername(usernamevalue).enterpassword(passwordvalue);
		h= l.clicklogin();
		u= h.moreinfoclick();
		u.clicksearchusers().enterusernametosearch(searchusername).dropdownusertypetosearch().clicksearchbutton();
		boolean usersearchbutton = u.newusersearch();
	    Assert.assertTrue(usersearchbutton,Constant.UNABLETOSEARCHUSERSERROR);

	}

}
