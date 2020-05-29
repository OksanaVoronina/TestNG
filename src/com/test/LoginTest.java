package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.ConfigMethodArguments;

import com.pages.DashboardPageElement;
import com.pages.LoginPageElement;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class LoginTest extends CommonMethods {


	
	@Test
	public static void login() {
		login.login(ConfigsReader.getPropery("username"),ConfigsReader.getPropery("password"));
		//LoginPageElement login = new LoginPageElement();
//		sendText(login.username, ConfigsReader.getPropery("username"));
//		sendText(login.password, ConfigsReader.getPropery("password"));
//		click(login.loginBtn);

		//DashboardPageElement dashboard= new DashboardPageElement();
		// String expectedUser="Welcome Admin";
		String actualUser = dashboard.welcome.getText();
		// Assert.assertEquals(expectedUser, actualUser,"Admin is NOT logged in");
		// or this one without using expected
		Assert.assertTrue(actualUser.contains(ConfigsReader.getPropery("username")));
	}

	@Test
	public static void invalidPasswordLogin() {
		//LoginPageElement login = new LoginPageElement();
		sendText(login.username, ConfigsReader.getPropery("username"));
		sendText(login.password, "passwo");
		click(login.loginBtn);
		String expected="Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text is not matched");
	}
	@Test
	public static void emptyUserName() {
		//LoginPageElement login = new LoginPageElement();
		sendText(login.password, ConfigsReader.getPropery("password"));
		click(login.loginBtn);
		String expected="Username cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text is not matched");
	}
	@Test
	public static void invalid() {
	//LoginPageElement login = new LoginPageElement();
	sendText(login.username, ConfigsReader.getPropery("username"));
	sendText(login.password, "passwo");
	click(login.loginBtn);
	String expected="Invalid credentials";
	Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text is not match");
}
}
