package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class orderPage extends baseClass {
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement cartUnitPrice;
	
	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut; 
	
	
	public  orderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public double unitPrice() {
		Action.fluentWait(getDriver(), cartUnitPrice, 20);
		String unitprice = cartUnitPrice.getText();
		String unitprice1 = unitprice.replaceAll("[^a-zA-Z0-9]","");
		double finalPrice=Double.parseDouble(unitprice1);
		return finalPrice/100;
	}
	public double totalprice() {
		String finalprice = totalPrice.getText();
		String finalprice1 = finalprice.replaceAll("[^a-zA-Z0-9]","");
		double totalprice= Double.parseDouble(finalprice1);
		return totalprice/100;
	}
	public loginPage checkOut() {
		Action.click(getDriver(), proceedToCheckOut);
		return new loginPage();
	}

}
