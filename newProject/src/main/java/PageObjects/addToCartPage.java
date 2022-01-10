package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class addToCartPage extends baseClass {
	
	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(name = "group_1")
	WebElement size;
	
	@FindBy(xpath="//p[@id='add_to_cart']//span")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2/text()")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']//span")
	WebElement proceedToCheckout;
	
	public  addToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void enterquntity(String qty)  throws Throwable {
		Action.type(quantity, qty);
	}
	public void selectsize(String size1)  {
		Action.selectByVisibleText(size1, size);
		
	}
	public void addTocartbtn() throws InterruptedException {
		Thread.sleep(3000);
		Action.click(getDriver(), addtocartbtn);
	}
	public boolean displaymessage() throws InterruptedException {
		Thread.sleep(3000);
		return Action.isDisplayed(getDriver(), addToCartMessage);
		
	}
	public orderPage checkOut() {
		Action.fluentWait(getDriver(), proceedToCheckout, 40);
		Action.JSClick(getDriver(),proceedToCheckout );
		return new orderPage();
	}
	
}
