package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	//base steps for obj class
	//a.instantite Webdriver
	//b.create Constructor of obj class
	//c.use PageFactory class 
	//d.write all Locators of webpage (which page u need to test and what are the elements of that page for using in testcase
	//e.Write all Action methods for all locators
	
	WebDriver driver;
	//create constructor
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//Locators of first home page
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkmy_acct;
	
	@FindBy(linkText="Register")
	WebElement lnk_register;
	
	@FindBy(linkText="Login")
	WebElement lnk_login;

	//Action methods for homepage webelements
	
	public void clickmyacct()
	{
		lnkmy_acct.click();
	}
	
	public void clickreg()
	{
		lnk_register.click();
	}
	
	public void clicklogin()
	{
		lnk_login.click();
	}
}
