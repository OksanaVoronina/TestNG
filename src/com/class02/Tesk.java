package com.class02;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class Tesk extends CommonMethods{
	
	@Test(priority=4)
	public void firstMethod() {
		System.out.println("firstMethod");
}
	@Test(enabled=false)
	public void firstMethod1() {
		System.out.println("firstMethod1");
}
	@Test(priority=3)
	public void secondMethod() {
		System.out.println("secondMethod");
}
	@Test(priority=2)
	public void thirdMethod() {
		System.out.println("thirdMethod");
}
	@Test(priority=1)
	public void fourhMethod() {
		System.out.println("fourhMethod");
}                               
}
