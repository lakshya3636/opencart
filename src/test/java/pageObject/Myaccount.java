package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount extends basePage{

	 public Myaccount(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myaccount;

	
	
	
	
	
	
	public void clicklogout() {
		logout.click();
	}
	
	
	public boolean created() {
		try 
		{
        return(myaccount.isDisplayed());			
		} 
		catch (Exception e) 
		{
			return false;
		}
	
	}
	
	
	
}
