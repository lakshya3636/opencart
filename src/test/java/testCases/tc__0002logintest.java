package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Myaccount;
import pageObject.homePage;
import pageObject.loginacc;
import testBase.testBase;

public class tc__0002logintest extends testBase{

	
	@Test(groups = {"Regression","Master"})
	public void verifylogintest() {
		
	try {
		logger.info("tc__0002loginTest has started");
		homePage hPage=new homePage(driver);	
		hPage.clickmyaccount();
		hPage.clicklogin();
			
		loginacc lg=new loginacc(driver);
		lg.setloginemal(p.getProperty("email"));
		lg.setloginpswd(p.getProperty("pswd"));
		lg.clickloginn();
		
     Myaccount myacc=new Myaccount(driver);
		
		boolean status=myacc.created();	
 		Assert.assertEquals(status, true);
		logger.info("tc__0002loginTest has finished");
		myacc.clicklogout();
		
		Assert.assertEquals(status, true);
		logger.info("tc__0002loginTest has finished");
		
	    } 
	catch (Exception e) 
	    {
       System.out.println(e.getMessage());  
         }	
	
	   
	
	
	
	
	
	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
