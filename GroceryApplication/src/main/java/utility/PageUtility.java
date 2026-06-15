package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
//selectby index method
	public void selectByIndexmethod(WebElement element, int value) {
		Select object=new Select(element);
		object.selectByIndex(value);
	}
//selectbytext method
	public void selectBytext(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	
	//click thru java script 
	public void clickthrujavascript(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);;
	}
	//scroll thru java script  so total 4 method
	public void scrollthrujavascript(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
}
