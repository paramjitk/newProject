package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class accountCreationPage extends baseClass {
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
	public accountCreationPage(){
		PageFactory.initElements(getDriver(), this);
	}
	public boolean  validAccountCreatePage() {
		return Action.isDisplayed(getDriver(), formTitle);
		
	}
}
