package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.CommonMethods;

public class sauceDemoLoginPage extends CommonMethods {

	@FindBy(id="user-name")
	public  WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@class='btn_action']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//h3[@data-test='error']")
	public WebElement errorMsg;
	
	@FindBy(xpath="//div[@class='app_logo']")
	public WebElement logo;
	public sauceDemoLoginPage() {
		PageFactory.initElements(driver, this);
		
		
		
		
	}
	public void loginToSaurseDemo(String uid,String pass) {
		sendText(username,uid);
		sendText(password,pass);
		click(loginBtn);
	}
	
}
