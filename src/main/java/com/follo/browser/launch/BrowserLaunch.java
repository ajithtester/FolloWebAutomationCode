package com.follo.browser.launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.follo.baseclass.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends Baseclass {


	public static void LaunchTheAppURL(String locator, String locatorfile ) throws Throwable {

		String Browser = PropertyFile("Browser", AppProperties);

		if(IsEqual(Browser, "Chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

//			options.addArguments("headless");
//			options.addArguments("window-size=1920,1080");
//		
//			driver = new ChromeDriver(options);


			driver = new ChromeDriver();

			driver.manage().window().maximize();
			Print("Chrome browser is launched");

			PropertyFile(locator, locatorfile);
			driver.get(properties);

		} 

		else if(IsEqual(Browser, "Firefox")) { 
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();

			options.addArguments("headless");
			driver = (WebDriver) new FirefoxOptions(options);

			driver.manage().window().maximize();

			//	driver = new FirefoxDriver();
			driver.manage().window().maximize();
			Print("Firefox browser is launched");

			PropertyFile(locator, locatorfile);
			driver.get(properties);

		}


		else {
			PrintError("Please try browser : Chrome or Firefox ");
		}


	}

}
