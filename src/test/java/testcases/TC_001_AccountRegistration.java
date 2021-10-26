package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.AcctRegistration;
import pageobjects.Homepage;
import testbase.Baseclass;

public class TC_001_AccountRegistration extends Baseclass{  //act reg extends the baseclass methods here
	
	//steps for testcases
	//Each testcase extends from the Parent "Baseclass" for use all common methods in baseclass
	//write logger msgs for all statements
	//open url  and get some common values by using resourcebundle class from config properties file
	//write all test methods in try-catch block for handeling Exceptions
	//after finish testmethod we have to add testcase class name in xml file for run the testcase through xml 
	
	
	
	
	//logger.info("ACT registration testcase started");
		
	@Test(groups= {"Sanity","Master"})
	public void test_act_reg() throws IOException
		{
		
		logger.info("Act Registration testcase started");
		
		try
		{
			
		
	  //driver.get("https://demo.opencart.com/");  //we can use this before creating config properties file
			driver.get(rb.getString("appURL"));  //now use rb(rsourcebundle obj) get the (any we need) value from config file
			
		driver.manage().window().maximize();
		logger.info("Opencart Webpage launched");
		
		Homepage hp=new Homepage(driver);    //create object for homepage pageobect class
		logger.info("Home page obj class created");
		
		hp.clickmyacct();
		logger.info("click on My Account");
		
		hp.clickreg();
		logger.info("click on Register Link");
		
		AcctRegistration reg_page=new AcctRegistration(driver);
		
		reg_page.enterfirst("abcd");
		logger.info("Enter first name");
		
		reg_page.enterlast("xyz");
		logger.info("Enter last name");
		
		reg_page.entertelph("123456789");
		logger.info("Enter Telephone number");
		
		reg_page.enteremail(randomestring()+"@gmail.com");
		logger.info("random generate email");
		
		reg_page.setpw("abcdxyz");
		logger.info("setting password");
		
		reg_page.confirmpw("abcdxyz");
		logger.info("confirm password entered");
		
		reg_page.rdclick();
		logger.info("click the radio button yes");
		
		reg_page.privacycheck();
		logger.info("click the Privacy Policy Checkbox");
		
		reg_page.contbtnclick();
		logger.info("click continue button");
		
		
		String confirm_msg=reg_page.getconfmsg();
		//if(confirm_msg.equals("Your Account Has Been Created!"))  // correct
			if(confirm_msg.equals("Your Account Has Been Created!"))  //we did fail for getting report and screen shot
		{
			logger.info("Account created");
			Assert.assertTrue(true);
		}
	
		else
		{
			logger.info("Account creation failed");
			capturescreenshot(driver,"TC_001_AccountRegistration");
			Assert.assertTrue(false);
		}
	}
		catch(Exception e)
		{
			logger.fatal("Account registration failed");
			capturescreenshot(driver,"TC_001_AccountRegistration");  //exception also failure so we cal the capturescreenshot method
			Assert.fail();
		}
	
		logger.info("Acct registration Finished");
	}
	

}

