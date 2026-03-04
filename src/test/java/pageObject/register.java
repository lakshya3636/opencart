package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class register extends basePage {

	
	
	public register(WebDriver driver) {
		super(driver);
	}


	//input[@id='input-firstname']
	//input[@id='input-lastname']
	//input[@id='input-email']
	//input[@id='input-telephone']
	//input[@id='input-password']
	//input[@id='input-confirm']
	//label[normalize-space()='Yes']
	//input[@name='agree']
	//input[@value='Continue']
	
	
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confrmpassword;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement button;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continue1;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement created;
	
	
	
	//----------------------------------------------
	
	public void setfirstname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setlastname(String lname) {
		lastname.sendKeys(lname);
		
	}
	
	public void setemail(String emal ) {
		email.sendKeys(emal);
	}
	
	public void settelephone(String tlephn) {
		telephone.sendKeys(tlephn);
	}
	
	public void setpassword(String pswd) {
		password.sendKeys(pswd);
	}
	
	public void setconfrmpassword(String cnfpswd) {
		confrmpassword.sendKeys(cnfpswd);	
	}
	
	public void clickbutton() {
		button.click();
	}
	
	public void clickagree() {
		agree.click();
	}
	
	public void clickContinue() {
		continue1.click();
	}
	
	public String verifycreated() {
		try {
			return (created.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
	
	
	
	
	
}
