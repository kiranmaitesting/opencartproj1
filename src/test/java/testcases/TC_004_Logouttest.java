package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Logoutpage;
import pageobjects.Myactpage;
import pageobjects.login_pageobj;
import testbase.Baseclass;

public class TC_004_Logouttest extends Baseclass{
	
	   @Test
	   public void tc_logout()
	   {
		 logger.info("TC_004 Started");  
	  	
	try
	{
		driver.get(rb.getString("appURL"));
		logger.info("Launch the WebPage");
		driver.manage().window().maximize();
		
		login_pageobj lgin=new login_pageobj(driver);
		driver.get(rb.getString("email"));
		
		driver.get(rb.getString("password"));
		
		logger.info("login into WebPage");
		
		Myactpage mp=new Myactpage(driver);
		mp.Clk_logout2();
		
		Logoutpage lpg=new Logoutpage(driver);
		boolean msgst=lpg.Ismsgdisplays();
		
		if(msgst==true)
		{
			Assert.assertTrue(true);
			logger.info("Logout success");
			
		}
	}
	catch(Exception e)
	{
	   Assert.assertTrue(false);
	   logger.info("Logout failed");
	}
	   }
}
