package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class searchResultPage extends baseClass{
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public searchResultPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean productAvaialability() throws Throwable{
		return Action.isDisplayed(getDriver(), productResult);	
	}
	public  addToCartPage clickOnProduct() {
		Action.click(getDriver(), productResult);
		return new addToCartPage();
	}
}
