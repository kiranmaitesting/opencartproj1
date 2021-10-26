package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myactpage {
	
	WebDriver driver;
	
	//constructor
	
	public Myactpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	//Locators
	
	@FindBy(linkText="Logout")
	WebElement lnklogout;
	
	@FindBy(linkText="Logout")
	WebElement btnlogout2;
	
	//Action Method
	
	
	public void clklogout()
	{
		lnklogout.click();
	}

	public void Clk_logout2()
	{
		btnlogout2.click();
	}
	
}
