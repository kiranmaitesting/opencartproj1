package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
	
WebDriver driver;  //driver
	
	//constructor
	public Logoutpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this.getClass());
	}
	
	//Locators
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement msglogout;
	
	public boolean Ismsgdisplays()
	{
		try
		{
			return(msglogout.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
