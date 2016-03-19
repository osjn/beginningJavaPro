package com.leclex;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistanceConverterTest {
	double feet, meters, inches, cm;

	@Test
	public void testConvertFeettoMeters() {
		feet = 1;
		meters = DistanceConverter.convertFeettoMeters(feet);
		assertEquals(meters, 0.3048, 0.001);
	}

	@Test
	public void testConvertMeterstoFeet() {
		meters = 1;
		feet = DistanceConverter.convertMeterstoFeet(meters);
		assertEquals(3.281,feet,0.001);
	}

	@Test
	public void testConvertFeettoInches() {
		feet = 1;
		inches = DistanceConverter.convertFeettoInches(feet);
		assertEquals(12,inches,0.001);
	}

	@Test
	public void testConvertInchestoFeet() {
		inches = 12;
		feet = DistanceConverter.convertInchestoFeet(inches);
		assertEquals(1,feet,0.001);
	}

	@Test
	public void testConvertCmtoFeet() {
		cm = 10;
		feet = DistanceConverter.convertCmtoFeet(cm);
		assertEquals(0.3281,feet,0.001);
	}

	@Test
	public void testConvertFeettoCm() {
		feet = 1;
		cm = DistanceConverter.convertFeettoCm(feet);
		assertEquals(30.48,cm,0.001);
	}

	@Test
	public void testConvertCmtoInches() {
		cm = 10;
		inches = DistanceConverter.convertCmtoInches(cm);
		assertEquals(3.9371,inches,0.001);
	}

	@Test
	public void testConvertInchestoCm() {
		inches = 10;
		cm = DistanceConverter.convertInchestoCm(inches);
		assertEquals(25.4,cm,0.001);
	}

}
