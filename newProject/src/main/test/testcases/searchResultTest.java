package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.pageIndex;
import PageObjects.searchResultPage;
import base.baseClass;

public class searchResultTest extends baseClass {
	
	pageIndex pageindex;
	searchResultPage searchresultpage;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterTest
	public void teardown() {
		getDriver().quit();
	}
	@Test
	public void searchResult() throws Throwable {
		pageindex=new pageIndex();
		searchresultpage = pageindex.searchProduct("t-shirt");
		boolean result = searchresultpage.productAvaialability();
		Assert.assertTrue(result);
	}
	
}
