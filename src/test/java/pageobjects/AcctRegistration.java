package pageobjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcctRegistration {
	
	WebDriver driver;
	
	//create constructor
	public AcctRegistration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Locators for acctregistration page(page 2)
	
	@FindBy(id="input-firstname")
	WebElement txt_firstname;
	
	@FindBy(id="input-lastname")
	WebElement txt_lastname;
	
	@FindBy(id="input-email")
	WebElement txt_email;
	
	@FindBy(id="input-telephone")
	WebElement txt_telephone;
	

	@FindBy(id="input-password")
	WebElement txt_password;

	@FindBy(id="input-confirm")
	WebElement txt_confirm_pw;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement rdbtn_yes;
	
	@FindBy(xpath="//label[normalize-space()='No']")
	WebElement rdbtn_no;
	
	@FindBy(name="agree")
	WebElement chkbtn;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncont;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cnfm_msg;
	
	//Action Methods of Acctregistrtion page webelements
	
	public void enterfirst(String name)
	{
		txt_firstname.sendKeys(name);
	}
	
	public void enterlast(String ltname)
	{
		txt_lastname.sendKeys(ltname);
	}
	
	public void enteremail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void entertelph(String tel)
	{
		txt_telephone.sendKeys(tel);
	}
	
	public void setpw(String pw)
	{
		txt_password.sendKeys(pw);
	}
	
	public void confirmpw(String conpw)
	{
		txt_confirm_pw.sendKeys(conpw);
	}
	
	public void rdclick()
	{
	 rdbtn_yes.click();	
	}
	
	public void privacycheck()
	{
		chkbtn.click();
	}
	
   public void contbtnclick()
   {
	   btncont.click();
   }
   
   public String getconfmsg()
   {
	   try
	   {
		   return (cnfm_msg.getText());
	   }
	   catch(Exception e)
	   {
		   return(e.getMessage());
	   }
   }
	
}
