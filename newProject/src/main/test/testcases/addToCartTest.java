package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.addToCartPage;
import PageObjects.pageIndex;
import PageObjects.searchResultPage;
import base.baseClass;

public class addToCartTest extends baseClass {

	pageIndex pageindex;
	searchResultPage searchresultpage;
	addToCartPage addtocartpage;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		launchApp(browser);
	}
//	@AfterTest
//	public void teardown() {
//	driver.quit();
//	}
	@Test
	public void addtoCart() throws Throwable {
		pageindex=new pageIndex();
		searchresultpage=pageindex.searchProduct("t-shirt");
		addtocartpage=searchresultpage.clickOnProduct();
		System.out.println("searchresultpage"+searchresultpage);
		addtocartpage.enterquntity("2");
		System.out.println("enterquntity");
		addtocartpage.selectsize("M");
		System.out.println("size");
		addtocartpage.addTocartbtn();
		System.out.println("called");
		Thread.sleep(5000);
		System.out.println("addtocartpage="+addtocartpage.displaymessage());
		//boolean validateMessage=addtocartpage.displaymessage();
		//Assert.assertTrue(validateMessage);
	}
}
