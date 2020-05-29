package com.utils;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer{
	/**
	 * method that clear and sends key
	 * @param element
	 * @param text
	 */
public static void sendText(WebElement element,String text) {
	element.clear();
	element.sendKeys(text);
}
/**
 * method checks if radio/checkbox is enabled and click
 * @param radioOrCheckbox
 * @param value
 */
public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckbox,String value) {
	for(WebElement element:radioOrCheckbox) {
	String actualValue=element.getAttribute("value");
	if(element.isEnabled() && actualValue.equals(value)) {
		element.click();
		break;
	}
}
}
/**
 * select dropDown by visible text
 * @param element
 * @param textToSelect
 */
	public static void selectDdValue (WebElement element,String textToSelect) {
		try {
		Select select=new Select(element);
		List<WebElement>option=select.getOptions();
		for(WebElement el:option) {
			if(el.getText().equals(textToSelect)) {
				select.selectByVisibleText(textToSelect);
				break;
			}
		}
		}catch(	UnexpectedTagNameException e) {
			e.printStackTrace();
		}
}
	/**
	 * select dropDown by index

	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element,int index) {
		try {
		Select select=new Select(element);
		List<WebElement>option=select.getOptions();
		int size=option.size();
		if(size>index) {
			select.selectByIndex(index);
			
		}
		
		}catch(	UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	/**
	 * accept Alert
	 */
	 public static void acceptAlert() {
		try{
		 Alert alert= driver.switchTo().alert();
		alert.accept();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();	
		}	
		}
	 /**
	  * dismiss Alert
	  */
	 public static void dismissAlert() {
			try{
			 Alert alert= driver.switchTo().alert();
			alert.dismiss();
			}catch(NoAlertPresentException e) {
				e.printStackTrace();	
			}
	 }
	 public static String getAlertText() {
		String alertText=null;
		 try {
		 Alert alert=driver.switchTo().alert();
		  alertText=alert.getText();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();	
		} 
		 return alertText;
		 
	 }
	 public static void sendAlertText(String text) {
			 try {
			 Alert alert=driver.switchTo().alert();
			 alert.sendKeys(text);
			}catch(NoAlertPresentException e) {
				e.printStackTrace();	
			}
	 }
	 
	 public static void switchToFrame(String nameOrId) {
		 try {
			 driver.switchTo().frame(nameOrId);
		 }catch(NoSuchFrameException e) {
			 e.printStackTrace();
		 }
	 }
	 public static void switchToFrame(WebElement element) {
		 try {
			 driver.switchTo().frame(element);
		 }catch(NoSuchFrameException e) {
			 e.printStackTrace();
		 }
	 }
	 public static void switchToFrame(int index) {
		 try {
			 driver.switchTo().frame(index);
		 }catch(NoSuchFrameException e) {
			 e.printStackTrace();
		 }
	 }
	 public static 	String switchToWindowGetTitle(String window) {
		String title=null;
		 window= driver.getWindowHandle();
		return title=driver.switchTo().window(window).getTitle();
		  
	 }
	 public static void switchToChildWindow() {
			String mainWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			for (String window : windows) {
				if (!window.equals(mainWindow)) {
					driver.switchTo().window(window);
					break;
				}
			}
		}

	 public static void getWindowsTitle() {
		String mainWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		for(String window:allWindows) {
			if(!window.equals(mainWindow)){
				driver.switchTo().window(window);
				break;
		}
		}
	 }
	 
	 public static WebDriverWait getWaitsObject() {
		 WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT_TIME);
		 return wait; 
	 }
	 public static void wait(int seconds) {
		
			try {
				Thread.sleep(seconds*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 }
	 public static void waitForClickability(WebElement element) {
		 getWaitsObject().until(ExpectedConditions.elementToBeClickable(element));
	 }
	 
	 public static void click(WebElement element) {
		 		 waitForClickability(element);
		 element.click();
	 }
	 public static void waitForVisibility(WebElement element) {
		 getWaitsObject().until(ExpectedConditions.visibilityOf(element));
	 }
	 /**
	  * Methods that will scroll down or up
	  * @return
	  */
	 public static JavascriptExecutor getJSObject() {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 return js;
	 }
	 public static void jsClick(WebElement element) {
		 getJSObject().executeScript("arguments[0].click();", element);
	 }
	 public static void scrollToElement(WebElement element) {
		 getJSObject().executeScript("arguments[0].scrollIntoView(true);",element);
	 }
	 public static void scrollDown(int pexsel) {
		 getJSObject().executeScript("window.scrollBy(0,"+pexsel+")");
	 }
	 public static void scrollUP(int pexsel) {
		 getJSObject().executeScript("window.scrollBy(0,-"+pexsel+")");	
		 }
	 
	 public static void selectCalendarDate(List<WebElement> element, String text) {
			for (WebElement pickDate : element) {
				if (pickDate.isEnabled()) {
					if (pickDate.getText().equals(text)) {
						pickDate.click();
						break;
					}
				}
			}
	 }
	 /**
	  * This is Method for screenshot
	  */
	 public static void takeScreenshot(String filename) {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File file=ts.getScreenshotAs(OutputType.FILE);
		 try {
		 FileUtils.copyFile(file, new File("screenshots/HRMS/"+filename+".png"));
		 }catch(Exception ex) {
			 System.out.println("we can't take screenshot");
		 }
		 
	 }
}
				
			

