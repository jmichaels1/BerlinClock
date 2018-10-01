package com.everis.controller;

import org.junit.Before;
import org.junit.Test;

import com.everis.model.ClockException;
import com.everis.view.ClockPrinterConsole;

public class ClockControllerTest {
	
	private ClockController clockController1;
	private ClockController clockController2;

	@Before 
	public void setUp() {
		clockController1 = new ClockController(new ClockPrinterConsole());
	}

	// junit 4
	@Test(expected = ClockException.class)
	public void shouldThrowExceptionWhenInputNotMatchesTheFormatJunit4() throws ClockException {
		clockController1.printTime("siete y treinta");
	}

	@Test(expected = ClockException.class)
	public void shouldShowInput() throws ClockException {
		clockController1.printTime("1sw:sw:sw");
	}
	
	@Test
	public void GoodCase() throws ClockException {
		clockController2 = new ClockController(new ClockPrinterConsole());
		clockController2.printTime("10:56:12");
	}

}
