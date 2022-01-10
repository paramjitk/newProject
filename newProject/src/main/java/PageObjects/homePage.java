package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class homePage extends baseClass {
	
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement wishlist;

	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderhistory;
	
	public homePage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean  validateWishlist() throws Throwable{
		return Action.isDisplayed(getDriver(), wishlist);	
	}
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), orderhistory);
	}
	public String getCurrUrl() {
		String currurl = getDriver().getCurrentUrl();
		return currurl;
	}
}
