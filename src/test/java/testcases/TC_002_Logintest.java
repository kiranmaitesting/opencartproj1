package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.login_pageobj;
import testbase.Baseclass;
//this is file is modified
public class TC_002_Logintest extends Baseclass {
	
	@Test(groups= {"Regression","Master"})
	public void test_Login() throws IOException
	{
		 logger.info("Log in Test Started");
		 
		 try
		 {
			 driver.get(rb.getString("appURL"));
			 logger.info("Home page Opened");
			 driver.manage().window().maximize();
			 
			 Homepage hp=new Homepage(driver);  //homepage obj class obj creted for access Homepage class methods
			 
			 hp.clickmyacct();
			 logger.info("click the MyAccount option");
			 
			 hp.clicklogin();
			 logger.info("click the Login option");
			 
			 login_pageobj lp=new login_pageobj(driver);  //create variable for "login_pageobj" pageobjclass
			 
			 lp.enter_id(rb.getString("email"));
			 logger.info("Enter the email id");
			 
			 lp.enter_pw(rb.getString("password"));
			 logger.info("Enter the password");
			 
			 lp.clklogin();
			 logger.info("Click the login button");
			 
			 boolean msgst=lp.IsmsgDisplayed();
			 if(msgst)
			 {
				Assert.assertTrue(true); 
				logger.info("Login Success");
			 }
			 
			 else
			 {
				 capturescreenshot(driver, "test_Login");
				 logger.info("Login failed");
				 Assert.assertTrue(false);
			 }
						 
			 
		 }
		catch(Exception e)
		 {
			 capturescreenshot(driver, "test_Login");
			 logger.info("Login failed");
		 }
		logger.info("TC_002_Logintest finished");
	}
	

}
