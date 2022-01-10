package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class addressPage extends baseClass{
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut; 
	
	public  addressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public shippingPAge clickCheckOut() {
		Action.rightclick(getDriver(), proceedToCheckOut);
		return new shippingPAge();
	}
	
}