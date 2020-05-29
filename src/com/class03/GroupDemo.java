package com.class03;

import org.testng.annotations.Test;

public class GroupDemo {

	@Test
	public void test1() {
		System.out.println("test1");
	}
	@Test(groups="smoke")
	public void test2() {
		System.out.println("test2");
	}
	@Test(groups= {"regression"})
	public void test3() {
		System.out.println("test3");
	}
	@Test(groups= {"smoke","regression"})
	public void test4() {
		System.out.println("test4");
	}
	@Test(groups="smoke")
	public void test5() {
		System.out.println("test5");
	}
}
