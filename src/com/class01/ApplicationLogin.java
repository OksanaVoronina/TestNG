package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPageElement;
import com.pages.LoginPageElement;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class  ApplicationLogin extends CommonMethods {
	//Open chrome browser
	//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	//3.Enter valid username and password
	//4.Click on login button
	//5.Then verify Syntax Logo is displayed
	//6.Close the browser

	
	@Test
	public static void validLogin() {
		//WebElement username = driver.findElement(By.id("txtUsername"));
	//	sendText(username, ConfigsReader.getPropery("username"));

		//WebElement password = driver.findElement(By.id("txtPassword"));
		//sendText(password, ConfigsReader.getPropery("password"));
		//click(driver.findElement(By.id("btnLogin")));
		
		//second way
		LoginPageElement login=new LoginPageElement();
		sendText(login.username, ConfigsReader.getPropery("username"));
		sendText(login.password, ConfigsReader.getPropery("password"));
		click(login.loginBtn);
		wait(2);
		DashboardPageElement dashboard=new DashboardPageElement();
		boolean displayed=dashboard.login.isDisplayed();
		if(displayed) {
			System.out.println("test is displayed");
		}else {
			System.out.println("logo is not display, test fail");
		}
	}
	
	
}
	
	
	

