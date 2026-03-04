package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Myaccount;
import pageObject.homePage;
import pageObject.loginacc;
import testBase.testBase;
import utilities.DataproviderExcel;

public class tc__0003ddt extends testBase {


	@Test(dataProvider ="logindata",dataProviderClass =DataproviderExcel.class )
	public void verifylogintest(String username,String password,String res) {
		
	try {
		logger.info("tc__0002loginTest has started");
		homePage hPage=new homePage(driver);	
		hPage.clickmyaccount();
		hPage.clicklogin();
			
		loginacc lg=new loginacc(driver);
		lg.setloginemal(username);
		lg.setloginpswd(password);
		lg.clickloginn();
		
     Myaccount myacc=new Myaccount(driver);
		
		boolean status=myacc.created();
		
		 if (res.equalsIgnoreCase("Valid")) 
		 {
			if (status==true) 
			{
					myacc.clicklogout();
					System.out.println("test passed");
				     Assert.assertTrue(true);
		    }
			 else
			 {
				 System.out.println("test failed");
			     Assert.assertTrue(false);
			 }
			 
		 }
		 
		 
		 
		 if (res.equalsIgnoreCase("Invalid")) 
		 {
			if (status==false) 
			{
				 System.out.println("test passed");
			     Assert.assertTrue(true);
		    }
			 else
			 {   myacc.clicklogout();
				 System.out.println("test failed");
			     Assert.assertTrue(false);
				
			 }
			 
		 }
		
			logger.info("tc__0002loginTest has finished");

	    } 
	catch (Exception e) 
	    {
       System.out.println(e.getMessage());  
         }	
	
	
	
	
	
	
	
	
	
		
	}
	
}	