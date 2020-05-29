package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;

	// to make this method run before every @Test method
	@BeforeMethod(alwaysRun=true)
	public static WebDriver setUp() {
		ConfigsReader.readProperties(Constants.File_Path);

		switch (ConfigsReader.getPropery("browser").toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.Chrome_Driver);
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.cego.driver", Constants.Gego_Driver);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("browser not suported");
		}
		//to make screen big
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getPropery("url"));

		//Initialize all page Objects as part of set up
		PageInitializer.initialize();
		return driver;
	}

	@AfterMethod(alwaysRun=true)// to run after every @TestMathod
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
