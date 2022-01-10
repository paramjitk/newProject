package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.addToCartPage;
import PageObjects.orderPage;
import PageObjects.pageIndex;
import PageObjects.searchResultPage;
import base.baseClass;

public class orderPageTest extends baseClass {
	
	pageIndex pageindex;
	searchResultPage searchresultpage;
	addToCartPage addtocartpage;
	orderPage orderpage;
	
	@BeforeTest
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test
	public void verfytotalprice() throws Throwable {
		
		pageindex=new pageIndex();
		searchresultpage=pageindex.searchProduct("t-shirt");
		addtocartpage=searchresultpage.clickOnProduct();
		System.out.println("searchresultpage"+searchresultpage);
		addtocartpage.enterquntity("2");
		System.out.println("enterquntity");
		addtocartpage.selectsize("M");
		System.out.println("size");
		addtocartpage.addTocartbtn();
		orderpage=addtocartpage.checkOut();
		Double unitprice=orderpage.unitPrice();
		System.out.println("unitprice"+unitprice);
		Double totalprice=orderpage.totalprice();
		System.out.println("totalprice"+totalprice);
		Double expectedprice=(unitprice*2)+2;
		Assert.assertEquals(totalprice, expectedprice);
		
		
	}

}
