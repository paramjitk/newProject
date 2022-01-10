package PageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class shippingPAge extends baseClass {
	
	@FindBy(id="cgv")
	WebElement terms;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement proceedtocheckoutbtn;
	
	public shippingPAge() {
		PageFactory.initElements(getDriver(), this);
	}
	public void clickTerms() {
		Action.fluentWait(getDriver(), terms, 10);
		Action.click(getDriver(), terms);
	}
	public paymentPage checkoutbtn() {
		Action.click(getDriver(), proceedtocheckoutbtn);
		return new paymentPage();
	}
	
}
