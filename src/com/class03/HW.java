package com.class03;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.ExcelUtility;

public class HW extends CommonMethods {
	@Test(dataProvider = "userData")
	public void test(String firstName, String lastName, String username, String password) {
		// System.out.println(firstName + " " + lastName + " " + username + " " +
		// password);

		// login into HRMS
		login.login(ConfigsReader.getPropery("username"), ConfigsReader.getPropery("password"));

		// navigate to Add Employee page
		dashboard.navigateToAddEmployee();
		wait(1);

		// add employee information
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
		// get EmployeeID
		String expectedEmpId = addEmp.employeeId.getAttribute("value");

		// click on Create Login Details
		click(addEmp.checkboxLoginDetails);
		wait(1);
		sendText(addEmp.username, username);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPassword, password);
		wait(1);
		jsClick(addEmp.btnSave);
		wait(1);

		// validation
		waitForVisibility(pdetails.lblPersonalDetails);
		String actualEmpId = pdetails.employeeId.getAttribute("value");
		Assert.assertEquals( actualEmpId,expectedEmpId, "Employee ID did not match!");

		// take screeshot
		takeScreenshot(firstName+"_"+lastName);
	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = {
				{ "rom", "Caoor", "rajkkk993", "AmirKhan_@123" }, 
				{ "bob", "Smth", "jolmlhn673", "AmirKhan_@123" }, 
				{ "taras", "Annn", "mmlmary333","AmirKhan_@123" }, 
				{ "Roh", "Saki", "rohlani153", "AmirKhan_@123" },
				{ "Alex", "Taras", "amlli183", "AmirKhan_@123" },
		};
		return data;
	}
	@DataProvider(name="userDataFromExcel")
	public Object[][] getDataExcel(){
		return ExcelUtility.excelIntoArray(("user.dir")+"/DataTest/info2.xlsx", "Employee");
		
	}

}

