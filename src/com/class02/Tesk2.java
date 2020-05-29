package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class Tesk2 extends CommonMethods {

	
	public static void Login() {
		setUp();
		WebElement username = driver.findElement(By.id("user-name"));
		sendText(username, ConfigsReader.getPropery("username"));
		WebElement password = driver.findElement(By.id("password"));
		sendText(password, ConfigsReader.getPropery("password"));
		click(driver.findElement(By.xpath("//input[@value='LOGIN']")));
	}

	@Test
	public static void logoValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='product_label']"));
		boolean isDisplyed = logo.isDisplayed();
		if (isDisplyed) {
			System.out.println("test pass");
		} else {
			System.out.println("test fail");
		}
	}

	// or comper using asse
	@Test
	public static void select() {

		WebElement dDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

		Select select = new Select(dDown);
		select.selectByVisibleText("Price (low to high)");
		wait(2);
	}

}
