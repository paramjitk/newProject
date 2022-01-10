package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class paymentPage extends baseClass{
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement paywithbank;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement paywithcheque;
	
	public paymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public  orderSummaryPage paymentPagebank() {
		Action.click(getDriver(), paywithbank); 
		return new orderSummaryPage();
	}
}
