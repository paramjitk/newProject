package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class orderConfirmationPage extends baseClass{
	
	@FindBy(xpath="//p/strong[text()='Your order on My Store is complete.']")
	WebElement confirmationMsg;
	
	public orderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public String orderconfirmed() {
		String confirmedMsg=confirmationMsg.getText();
		return confirmedMsg;
	}

}
