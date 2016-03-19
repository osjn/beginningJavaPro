package com.leclex;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUitTest {
	static Scanner scan;
	int myIntA, myIntB, myIntC;
	int[] myArrayA = {0, 1, 2};
	Object myObject;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// access resources for use in the tests
		scan = new Scanner(System.in);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// close resources after all tests complete
		scan.close();
	}

	@Before
	public void setUp() throws Exception {
		// assign some values to the variables
		// before beginning each test
		myIntA = 5;
		myIntB = 6;
		myIntC = 7;
	}

	@After
	public void tearDown() throws Exception {
		// nothing needs to be torn down
	}
	
	@Test
	public void testAssertEquals() {
		// (5 + 1) equals 6
		assertEquals((myIntA + 1), myIntB);
	}
	
	@Test
	public void testAssertArrayEquals() {
		int[] myNewArray = {0, 2, 1};
		// the elements in both arrays are 0, 1, and 2
		// order matters: {0, 1, 2} != {0, 2, 1}
		assertArrayEquals(myArrayA, myNewArray);
	}
	
	@Test
	public void testAssertTrue() {
		// 7 > 5
		assertTrue(myIntC > myIntA);
	}
	
	@Test
	public void testAssertFalse() {
		// myArrayA.length == 3, 3 != 4
		assertFalse(myArrayA.length == 4);
	}
	
	@Test
	public void testAssertNull() {
		// myObject has not been initialized
		assertNull(myObject);
	}
	
	@Test
	public void testAssertNotNull() {
		String newString = "Hello";
		// newString is initialized
		assertNotNull(newString);
	}
	
	@Test
	public void testAssertSame() {
		myObject = new Object();
		Object pointerA = myObject;
		Object pointerB = myObject;
		// both pointerA and pointerB reference myObject
		assertSame(pointerA, pointerB);
	}

	@Test
	public void testAssertNotSame() {
		myObject = new Object();
		Object pointerA = new Object();
		Object pointerB = myObject;
		// poinerA is a new Object
		// pointerB references myObject
		assertNotSame(pointerA, pointerB);
	}

}
