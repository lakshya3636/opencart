package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class loginacc extends basePage{
	
	public loginacc(WebDriver driver) {
		super(driver);
	}
	

	//input[@id='input-email']
	//input[@id='input-password']
	//input[@value='Login']
	//h2[normalize-space()='My Account']
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement loginemal;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement loginpswd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginn;

	
	
	
	
	
	public void setloginemal(String email) {
		loginemal.sendKeys(email);
	}
	
	public void setloginpswd(String pswd) {
		loginpswd.sendKeys(pswd);
	}
	
	public void clickloginn() {
		loginn.click();
	}
	
	
	}
	
	
	
	


