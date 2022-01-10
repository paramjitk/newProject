package testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.homePage;
import PageObjects.loginPage;
import PageObjects.pageIndex;
import actionDriver.Action;
import base.baseClass;
import dataProviders.dataProvider;
import utilityComponents.log;

public class loginTestPage extends baseClass {
	
	pageIndex pageindex;
	loginPage loginpage;
	homePage homepage;
	
	@Parameters("browser")
	@BeforeTest(groups= {"smoke","sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterTest(groups= {"smoke","sanity"})
	public void teardown() {
		getDriver().quit();
	}
	@Test(dataProvider ="Sheet1",dataProviderClass=dataProvider.class, groups= {"smoke","sanity"})
	public void verifylogin(String uname, String pswd) throws Throwable{
		log.startTestCase("verifylogin");
		pageindex=new pageIndex();
		log.info("loginng in");
		loginpage=pageindex.clickOnSignIn();
		log.info("Enter Username and password");
		Thread.sleep(5000);
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("login before="+homepage+uname+pswd);
		homepage = loginpage.login(uname,pswd);
		System.out.println("login success="+homepage+uname+pswd);
		String actualURL= homepage.getCurrUrl();
		System.out.println("actualURL"+actualURL);
		String url = "http://automationpractice.com/index.php?controller=my-account";
		System.out.println("expected"+url);
		log.info("login suaccessful");
		Assert.assertEquals(actualURL, url);
	}
}
