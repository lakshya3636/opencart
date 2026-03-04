package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.homePage;
import pageObject.register;
import testBase.testBase;

public class tc__0001AccountRegistration extends testBase {

/*	
	@Test
	public void verifyaccountregistration() {
		try {
		logger.info("Starting tc__001AccountRegistration ");
		homePage hp=new homePage(driver);
		
		hp.clickmyaccount();
		hp.clickregister();
		
		register rg=new register(driver);
		
		rg.setfirstname(ranalphabet());
		rg.setlastname(ranalphabet());
		rg.setemail(ranalphabet()+"@gmail.com");
		rg.settelephone(rannumeric());
		
		
		String pswd=ranpswd();
		rg.setpassword(pswd);
		rg.setconfrmpassword(pswd);
		
		rg.clickbutton();
		rg.clickagree();
		rg.clickContinue();
		
		String textString= rg.verifycreated();
		System.out.println(textString);
		Assert.assertEquals(textString, "Your Account Has Been Created!");
		
	}
	catch (Exception e) {
System.out.println(e.getMessage());
 
		}
	logger.info("Finished tc__001AccountRegistration");
	}
	
	*/
	
	
	
	@Test(groups = {"Sanity","Master"})
	public void verifyaccountregistration() {
		logger.info("Starting tc__001AccountRegistration ");

		try {
		homePage hp=new homePage(driver);
		
		hp.clickmyaccount();
		hp.clickregister();
		
		register rg=new register(driver);
		
		rg.setfirstname(firstnamefaker());
		rg.setlastname(lastnamefaker());
		rg.setemail(emailfaker());
		rg.settelephone(phnnumfaker());
		
		
		//String pswd=ranpswd();
		String pswd=pswdfaker();
		
		rg.setpassword(pswd);
		rg.setconfrmpassword(pswd);
		
		rg.clickbutton();
		rg.clickagree();
		rg.clickContinue();
		
		String textString= rg.verifycreated();
		System.out.println(textString);
		Assert.assertEquals(textString, "Your Account Has Been Created!");
		
	}
	catch (Exception e) {
System.out.println(e.getMessage());
 
		}
	logger.info("Finished tc__001AccountRegistration");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}












