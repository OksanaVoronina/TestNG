package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;


public class AddEmployeePageElement  {

	@FindBy(xpath= "//input[@id='firstName']")
	public WebElement firstName;
	
	@FindBy(id="middleName")
	public WebElement middleName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="photofile")
	public  WebElement photoFile;
	
	@FindBy(id = "employeeId")
	public WebElement employeeId;
	
	@FindBy(id = "chkLogin")
	public WebElement checkboxLoginDetails;
	
	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;

	@FindBy(xpath="//span[text()='Required']")
	public WebElement errorMsg;
	
	public AddEmployeePageElement() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
