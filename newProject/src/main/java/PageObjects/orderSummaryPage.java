package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class orderSummaryPage extends baseClass {
	
	@FindBy(xpath="//button/span[text()='I confirm my order']")
	WebElement conirmOrderbtn;
	
	public orderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public orderConfirmationPage clickconirmOrderbtn() {
		Action.click(getDriver(),conirmOrderbtn);
		return new orderConfirmationPage();
	}
}
