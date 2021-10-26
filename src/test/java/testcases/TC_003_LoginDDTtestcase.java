package testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Myactpage;
import pageobjects.login_pageobj;
import testbase.Baseclass;
import utilities.XLUtility;

public class TC_003_LoginDDTtestcase extends Baseclass {
	
			
		@Test(dataProvider ="Logindata")
		public void test_LoginDDT(String email,String pw,String expres) throws IOException

		{
			 logger.info("Log in DDT Test Started");
			 
			 try
			 {
				 driver.get(rb.getString("appURL"));
				 logger.info("Home page Opened");
				 driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 
				 Homepage hp=new Homepage(driver);  //homepage obj class obj creted for access Homepage class methods
				 
				 hp.clickmyacct();
				 logger.info("click the MyAccount option");
				 
				 hp.clicklogin();
				 logger.info("click the Login option");
				 
				 System.out.println("Entering login data........");
				 
				 login_pageobj lp=new login_pageobj(driver);  //create variable for "login_pageobj" pageobjclass
				 
				 System.out.println("email address is:"+email);
				 System.out.println("password is:"+pw);
			 
						 
				  lp.enter_id(email);
				  logger.info("TAke the email from xl sheet");
				  
				  lp.enter_pw(pw);
				  logger.info("Take the pw from xl sheet");
				  
				  		  
				  				  
				 lp.clklogin();
				 logger.info("Click the login button");
				 
				 boolean msgst=lp.IsmsgDisplayed();
				 System.out.println(msgst);
				 
			 if(expres.equals("Valid"))
			 {
					 
				  if(msgst==true)
				 {
					 
					logger.info("Login Success");
					
					Myactpage mp=new Myactpage(driver);
					
					mp.clklogout();
					logger.info("Logout from page");
					
					Assert.assertTrue(true);
				 }
			 	 
				
			    else
				 {
					 capturescreenshot(driver, "test_LoginDDT");
					 logger.info("Login failed");
					 Assert.assertTrue(false);
				 }
			 }
			 
			 if(expres.equals("InValid"))
			 {
					 
				  if(msgst==true)
				 {
					 
					logger.info("Login Success");
					capturescreenshot(driver,"test_LoginDDT");
					
					Myactpage mp=new Myactpage(driver);
					mp.clklogout();
					
					logger.info("Logout from page");
					
					Assert.assertTrue(false);
				 }
			 	 
				
			    else
				 {
					
					 logger.info("Login failed");
					 Assert.assertTrue(true);
				 }
			 }
			 
		 }
			 
			 catch(Exception e)
			 {
				 capturescreenshot(driver, "test_LoginDDT");
				 logger.info("Login failed");
			 }
			logger.info("TC_003_LoginDDTtest finished");
		}
		
		
	@DataProvider(name="Logindata")	
    public String[][] getData() throws IOException
    {
		String path=".\\testData\\Opencart_LoginData.xlsx";  //or "C:\\eclipeworkspace\\opencartproj1\\testData\\Opencart_LoginData.xlsx"
		XLUtility xlutil=new XLUtility(path);
		int rowcount=xlutil.getRowCount("Sheet1");
		int colcount=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[rowcount][colcount];
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
				
			}
		}
		
		return logindata;
     }
}



