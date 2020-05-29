package com.class03;

import org.junit.Assert;
import org.testng.annotations.Test;

public class ListenerDemo {

	@Test
	public void testOne() {
		System.out.println("Test One");
		Assert.assertTrue(true);
	}
	@Test
	public void testTwo() {
		System.out.println("Test Two");
		Assert.assertTrue(false);
	}
}
