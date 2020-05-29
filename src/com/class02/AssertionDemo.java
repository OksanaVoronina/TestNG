package com.class02;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPageElement;
import com.pages.LoginPageElement;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AssertionDemo extends CommonMethods {

	


	@Test
		public static void logoPageElement() {
		LoginPageElement login = new LoginPageElement();
		sendText(login.username, ConfigsReader.getPropery("username"));
		sendText(login.password, ConfigsReader.getPropery("passworrd"));
		click(login.loginBtn);
		
		//logo assertion
		LoginPageElement logo = new LoginPageElement();
		boolean displayed = logo.logo.isDisplayed();
		// Assert.assertEquals(displayed, true);
		// or
		Assert.assertTrue(displayed, "logo is not displayed");
		
		//welcome mgs assert
	      DashboardPageElement dashboard= new DashboardPageElement();
	      boolean mgsDisplayed=dashboard.welcome.isDisplayed();
	      Assert.assertTrue(mgsDisplayed);
	}
	//this is hard code, use loginPageElement or dashBoardPage
	public static void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		// Assert.assertEquals(expectedTitle,actualTitle);
		// or
		Assert.assertEquals(expectedTitle, actualTitle, "title does not match");
	}

	
}
