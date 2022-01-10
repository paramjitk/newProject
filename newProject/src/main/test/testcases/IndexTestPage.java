package testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.pageIndex;
import actionDriver.Action;
import base.baseClass;
import utilityComponents.log;

import org.testng.annotations.Parameters;


public class IndexTestPage extends baseClass {
	pageIndex pageindex;
	
	
	@Parameters("browser")
	@BeforeTest(groups= {"smoke","sanity"})
	public void setup(String browser) {
		launchApp(browser);
		System.out.println(browser);
	}
	@AfterTest(groups= {"smoke","sanity"})
	public void teardown() {
		getDriver().quit();
	}
	@Test(groups= {"smoke","sanity"})
	public void verifyLogo()throws Throwable{
		pageindex =new pageIndex();
		boolean result=pageindex.logo();
		Assert.assertTrue(result);
	}
	@Test(groups= {"smoke"})
	public void verifyTitle() {
		Action.implicitWait(getDriver(), 10);
		String sr=pageindex.storetitle();
		log.info("sr="+sr);
		Assert.assertEquals(sr, "My Store");
		log.info("sr="+sr);
	}
	
}
