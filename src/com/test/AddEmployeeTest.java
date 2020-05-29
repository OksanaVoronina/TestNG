package com.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.Constants;

public class AddEmployeeTest extends CommonMethods {

	@Test
	public static void addEmployeeElements(String firstName,String LastName) {

		login.login(ConfigsReader.getPropery("username"), ConfigsReader.getPropery("password"));
		dashboard.navigateToAddEmployee();
		wait(5);
		sendText(addEmp.firstName, ConfigsReader.getPropery("firstname"));
		sendText(addEmp.lastName, ConfigsReader.getPropery("lastname"));
		// sendText(addEmp.middleName, ConfigsReader.getPropery("middlename"));
		sendText(addEmp.photoFile, ConfigsReader.getPropery("photo"));
		click(addEmp.btnSave);
		String actual = "Oksana Voronina";
		Assert.assertEquals(actual, pdetails.fullName.getText(),"Employee didn't added");
	//or
		String actualId=addEmp.employeeId.getAttribute("value") ;
		Assert.assertEquals(actualId,pdetails.employeeId.getAttribute("value"));
		
		takeScreenshot("addEmployee");
	}
	@Test
	/*
	 * if user didn't fielded required fields
	 */
	public static void emptyFields() {
		login.login(ConfigsReader.getPropery("username"), ConfigsReader.getPropery("password"));
		dashboard.navigateToAddEmployee();
		wait(5);
		click(addEmp.btnSave);
		Assert.assertTrue(addEmp.errorMsg.isDisplayed(),"required fields can NOT be empty ");
	}
		
}
