package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;
import com.utils.CommonMethods;


public class DashboardPageElement extends CommonMethods{

	@FindBy(id="welcome")
	public WebElement welcome;
	
	@FindBy(xpath="//div[@id='branding']/a[1]/img")
	public WebElement login;
	
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmp;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	public WebElement PIM;
	
	public DashboardPageElement() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	public void navigateToAddEmployee() {
		jsClick(PIM);
		jsClick(addEmp);
	}
}

