package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;
import utilityComponents.log;

public class loginPage extends baseClass {
	
	@FindBy(xpath="//input[@name='email']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement Password;
	
	@FindBy(id="SubmitLogin")
	WebElement SubmitLogin;
	
	@FindBy(name="email_create")
	WebElement emailfornewaccount;
	
	@FindBy(name="SubmitCreate")
	WebElement createAccountBtn;
	
	public loginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public homePage login(String uname, String pswd) throws Throwable{
		Action.type(Username, uname);
		log.info("Username="+uname);
		Action.type(Password, pswd);
		log.info("password="+pswd);
		Action.click(getDriver(), SubmitLogin);
		return new homePage();
	}
	public addressPage login1(String uname, String pword) throws Throwable{
		Action.type(Username, uname);
		Action.type(Password, pword);
		Action.click(getDriver(), SubmitLogin);
		return new addressPage();
	}
	public accountCreationPage createNewAccount(String newaccount) {
		Action.type(emailfornewaccount, newaccount);
		return new accountCreationPage();
	}
	
}
