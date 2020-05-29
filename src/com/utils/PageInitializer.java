package com.utils;

import com.pages.AddEmployeePageElement;
import com.pages.DashboardPageElement;
import com.pages.LoginPageElement;
import com.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass{

		public static LoginPageElement login;
		public static AddEmployeePageElement addEmp;
		public static DashboardPageElement dashboard;
		public static PersonalDetailsPageElements pdetails;
		
		public static void initialize() {
			
			login=new LoginPageElement();
			dashboard=new DashboardPageElement();
			addEmp=new AddEmployeePageElement();
			pdetails=new PersonalDetailsPageElements();
		}
	}

