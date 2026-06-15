package constant;

public class Constant {

	public static final String CONFIGFILE=System.getProperty("user.dir") + "\\src\\main\\resources\\Config.property" ;
    public static final String TESTDATA = System.getProperty("user.dir") + "\\src\\test\\resources\\GroceryAppLoginData.xlsx";
    public static final String VALIDCREDENTIALERROR= "User is unable to login with valid credentials";
    public static final String INVALIDCREDENTIALERROR =" User is able to login with invalid credentials";
    public static final String INVALIDUSERNAMEERROR ="User is unable to login with invalid username";
    public static final String INVALIDPASSWORDERROR ="User is unable to login with invalid password";
    public static final String UNABLETOADDNEWUSERSERROR = "User is not able to add new admin user";
    public static final String UNABLETOSEARCHUSERSERROR ="User is not able to search user";
    public static final String UNABLETOLOGOUTERROR ="User is unable to logout";
    public static final String UNABLETOUPDATECONTACTERROR ="User is not able to update contact";
    public static final String UNABLETOADDNEWSERROR="User is not able to add news";
    public static final String UNABLETOSEARCHNEWSERROR="User is not able to search news";
}

