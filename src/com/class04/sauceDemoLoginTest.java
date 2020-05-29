package com.class04;


import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.sauceDemoLoginPage;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class sauceDemoLoginTest extends CommonMethods {

	@Test(dataProvider="dataProvider",groups= {"sprint"})
	public void loginToSauceDemo(String username,String password) {
		sauceDemoLoginPage login=new sauceDemoLoginPage();
		login.loginToSaurseDemo(username, password);
		wait(5);
	boolean logo=login.logo.isDisplayed();
	if(username.equals("locked_out_user")) {
				Assert.assertTrue(login.errorMsg.isDisplayed());

	}else {
		Assert.assertTrue(logo);
		
	}
	}
	@DataProvider(name="dataProvider")
	public  Object[][] setUpData(){
		Object[][] data=new Object[4][2];
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";

		data[1][0]="problem_user";
		data[1][1]="secret_sauce";
		
		
		data[2][0]="locked_out_user";
		data[2][1]="secret_sauce";
		
		data[3][0]="performance_glitch_user";
		data[3][1]="secret_sauce";
		
		return data;
		
	}
	
	
}
