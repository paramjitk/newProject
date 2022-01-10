package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.homePage;
import PageObjects.loginPage;
import PageObjects.pageIndex;
import base.baseClass;

public class homePageTest extends baseClass {
	
	pageIndex pageindex;
	loginPage loginpage;
	homePage homepage;
	
	@Parameters("browser")
	@BeforeTest(groups= {"smoke","sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterTest
	public void teardown() {
		getDriver().quit();
	}
	@Test(groups= {"sanity"})
	public void wishlist() throws Throwable {
		pageindex=new pageIndex();
		loginpage=pageindex.clickOnSignIn();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login success"+homepage);
		boolean result = homepage.validateWishlist();
		Assert.assertTrue(result);
	}
	@Test(groups= {"smoke"})
	public void orderHistry() throws Throwable {
		pageindex=new pageIndex();
		loginpage=pageindex.clickOnSignIn();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login success1="+homepage);
		boolean result1 = homepage.validateOrderHistory();
		Assert.assertTrue(result1);
	}
}
