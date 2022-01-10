package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.accountCreationPage;
import PageObjects.homePage;
import PageObjects.loginPage;
import PageObjects.pageIndex;
import base.baseClass;
import dataProviders.dataProvider;

public class accountCreationTestPage extends baseClass{
	pageIndex pageindex;
	loginPage loginpage;
	homePage homepage;
	accountCreationPage accountCreationpage;
	
	@Parameters("browser")
	@BeforeTest(groups= {"smoke","sanity"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterTest(groups= {"smoke","sanity"})
	public void teardown() {
		getDriver().quit();
	}
	@Test(dataProvider="Sheet2", dataProviderClass=dataProvider.class,groups= {"smoke"})
	public void accountCreation(String acc) throws Throwable {
		pageindex=new pageIndex();
		loginpage=pageindex.clickOnSignIn();
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//System.out.println("login success"+homepage);
		accountCreationpage=loginpage.createNewAccount(acc);
		boolean titleavailable =accountCreationpage.validAccountCreatePage();
		Assert.assertTrue(titleavailable);
	}

}
