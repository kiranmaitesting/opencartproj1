package testbase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
//create one base class for all common methods what are we using in all testcases we can store methods in this class and 
// call these for each testcases by extends this class
public class Baseclass {
	
	//steps for-- Baseclass--
	//What are the common methods for all test cases we can create here and call these methods in testcases
	//create driver setup method here and add parameters annotation with browser object
	//run through xml file our specific browser by passing parameter to setup methodps
	//for Group tests you have to add groups here at Before class annotation
	
	
	//Add annotation of before calss after class for driver setup
	
public WebDriver driver;  //create driver as publicbcz it is in parent class for access in all testcases
public Logger logger;   //create logger object
public ResourceBundle rb;  //create Resourebundle(class) obj for read values from config.properties 

    
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"browser"})  //get the browser parameter form xml file
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");  //pass the resource file name here to the obj rb
		
		//logging
		logger=LogManager.getLogger(this.getClass());  //pass the class here
		
		if(br.equals("chrome"))  //through xml get which driver is we need to execute
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		logger.info("Chrome browser Launched");
		}
		
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			logger.info("Edge browser Launched");
		}
		
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("Firefox browser Launched");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	

	@AfterClass(groups= {"Sanity","Regression","Master"})
	 public void teardown()
	{
		driver.close();
	}
	
	//create method for generate random string(randomlygenerate mail string each execution) eachtime
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);  //randomstringutilsclass
		return generatedstring;
	}
	public int randomenumber()
	{
		String generatenum=RandomStringUtils.randomNumeric(5);
		return Integer.parseInt(generatenum);
	}
	
	public void capturescreenshot(WebDriver driver,String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		
	}

}
