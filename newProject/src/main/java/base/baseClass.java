package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

import utilityComponents.log;

public class baseClass {
	public static Properties prop;
	//for single browser run
	//public static WebDriver driver;
	
	//for multiple browser run we user threadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();
		
	@BeforeSuite(groups= {"smoke","Sanity"})
	public void loadConfig() {
		DOMConfigurator.configure("log4j.xml");
		
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\nConfiguration\\nconfig.properties");

		prop.load(ip);
	}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public  void launchApp(String br) {
		log.info("driver launching="+br);
		//WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		
		if(br.equalsIgnoreCase("Chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();   for single browser
			driver.set(new ChromeDriver());  //for multi browser
			log.info("Chrome driver launched");
		}
		else if (br.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
			log.info("furefox driver launched");
		}
		
		getDriver().manage().deleteAllCookies();
		log.info("all cookies deleted");
		getDriver().get(prop.getProperty("url"));
		Action.implicitWait(getDriver(),20);
	}
	
}
