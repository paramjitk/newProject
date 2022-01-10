package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.addToCartPage;
import PageObjects.addressPage;
import PageObjects.loginPage;
import PageObjects.orderPage;
import PageObjects.orderSummaryPage;
import PageObjects.pageIndex;
import PageObjects.paymentPage;
import PageObjects.searchResultPage;
import PageObjects.shippingPAge;
import base.baseClass;
import utilityComponents.log;

public class endToendtest extends baseClass{
	pageIndex pageindex;
	searchResultPage searchresultpage;
	addToCartPage addtocartpage;
	orderPage orderpage;
	loginPage loginpage;
	addressPage addresspage;
	shippingPAge shippingpage;
	paymentPage paymentpage;
	orderSummaryPage ordersummarypage;
	
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
		loginpage = orderpage.checkOut();
		addresspage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		log.info("username"+"password");
		shippingpage = addresspage.clickCheckOut();
		log.info("shippingpage");
		shippingpage.clickTerms();
		log.info("shipping");
		paymentpage = shippingpage.checkoutbtn();
		ordersummarypage = paymentpage.paymentPagebank();
		
	}

}
