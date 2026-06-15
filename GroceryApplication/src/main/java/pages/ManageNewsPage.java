package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialise elements with PageFactory class
		
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @onclick='click_button(1)']") WebElement newbutton;
	@FindBy(id="news") WebElement newstext;
	@FindBy(xpath="//button[@name='create' and @type='submit']") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newsalert;
	@FindBy(xpath="//a[@href='javascript:void(0)' and @onclick='click_button(2)']") WebElement searchnewsbutton;
	@FindBy(name="un") WebElement searchnews;
	@FindBy(name="Search") WebElement searchbutton;
	@FindBy(xpath="//td[text()='Severe weather warnings at specific locations near to coastal regions in Kerala -Reported']") WebElement searchresult;
	
	public ManageNewsPage clicknewbutton()
	{
		newbutton.click();
		return this;
		
	}
	
	public ManageNewsPage enternews(String addnews)
	{
		newstext.sendKeys(addnews);
		return this;
		
	}
	public ManageNewsPage clicksavebutton()
	{
		
		savebutton.click();
		return this;
	}
	public boolean newsaddedsucessfullyalert()
	{
	
	return newsalert.isDisplayed();
	}
	
	public ManageNewsPage clicksearch()
	{
		searchnewsbutton.click();
		return this;
		
	}
	
	public ManageNewsPage enternewstosearch(String searchnewstext)
    {
    	searchnews.sendKeys(searchnewstext);
    	return this;
    	
    }
	
	public ManageNewsPage searchclickfornews()
	{
		
		searchbutton.click();
		return this;
	}
	
	public boolean newsfoundalert()
	{
	
	return searchresult.isDisplayed();
	}
	

}
