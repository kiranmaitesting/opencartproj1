package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_pageobj {
	
	WebDriver driver;  //driver
	
	//constructor
	public login_pageobj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Locators
	
	//@FindBy("//input[@id='input-email']")
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_pw;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement displaymsg;
	
	//Action methods
	
	public void enter_id(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void enter_pw(String pw)
	{
		txt_pw.sendKeys(pw);
		
	}
	
	public void clklogin()
	{
		btn_login.click();
	}
	
	public boolean IsmsgDisplayed()
	{
		try
		{
			return(displaymsg.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}

}
