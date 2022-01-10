package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.baseClass;

public class pageIndex extends baseClass {
	Action Action=new Action();
	
	@FindBy(xpath = "//a[@class='login']") 
	 WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	 WebElement myStoreLogo;
	
	@FindBy(xpath = "//a[@title='My Store']")
	WebElement myStoretitle;
	
	@FindBy(id="search_query_top")
	 WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	 WebElement searchButton;
	
	public pageIndex() {
	PageFactory.initElements(getDriver(), this);
	}
	

	public  loginPage clickOnSignIn() throws Throwable {
		Action.fluentWait(getDriver(),signInBtn, 10);
		Action.click(getDriver(), signInBtn);
		return new loginPage();
	}
	public boolean logo() {
		return Action.isDisplayed(getDriver(), myStoreLogo);		
	}
	public String storetitle() {
		String storeTitle= Action.getTitle(getDriver());
		System.out.println("storeTitle="+storeTitle);
		return storeTitle;
	}
	public searchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new searchResultPage();
	}
}
