package com.simplilearn.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitLifecycleStandardMethodsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("-- Before all ---");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("-- After all ---");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Before each test !");
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("After each test !");
	}
	
	@Test
	void testOne() {
		System.out.println("Test 1 is executed !");
	}
	
	@Test
	void testTwo() {
		System.out.println("Test 2 is executed !");
	}
	
	@Test
	void testThree() {
		System.out.println("Test 3 is executed !");
	}
}
