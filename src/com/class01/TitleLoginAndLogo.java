package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class TitleLoginAndLogo extends CommonMethods {
	

	@Test
	public static void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("title Validation test pass");
		} else {
			System.out.println("title Validation fail");
		}
	}

	@Test
	public static void logoValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@id='branding']/a[1]/img"));
		boolean isDisplayed = logo.isDisplayed();
		if (isDisplayed) {
			System.out.println("logo validation pass");
		} else {
			System.out.println("Logo validation is fail");
		}
	}

	@Test
	public static void validLogin() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getPropery("username"));

		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getPropery("password"));
		click(driver.findElement(By.id("btnLogin")));
		wait(2000);
	}
}
