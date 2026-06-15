package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialise elements with PageFactory class
		
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin; // annotation in Pagefactory to find elements	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']") WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @ class='small-box-footer']") WebElement aumoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement mcinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement managenewsinfo;

   // public void adminclick()
	public HomePage adminclick()
{
	
	admin.click();
	return this;
}

    public LoginPage logoutclick()
{
	
	logout.click();
	return new LoginPage(driver);
}
    public AdminUsersPage moreinfoclick()
{
    	
    	aumoreinfo.click(); 
    	return new AdminUsersPage(driver);
}
  public ManageContactPage managecontactinfoclick()
  {
  
  mcinfo.click();
  return new ManageContactPage(driver);

}
  
  public ManageNewsPage managenewsinfoclick()
  {
	  managenewsinfo.click();	  
	  return new ManageNewsPage(driver);
  }
}