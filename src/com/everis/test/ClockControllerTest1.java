package com.everis.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import com.everis.controller.ClockController;
import com.everis.model.ClockException;

class ClockControllerTest1 {
	
	private ClockController clockController;

	@Before
	public void setUp() {
		clockController = new ClockController();
	}

	// junit 5
	@Test
	public void shouldThrowExceptionWhenInputNotMatchesTheFormatJunit5() {
		assertThrows(ClockException.class, () -> {
			clockController.printTime("siete y treinta");
		});
	}

	// junit 4
	@Test(expected = ClockException.class)
	public void shouldThrowExceptionWhenInputNotMatchesTheFormatJunit4() throws ClockException {
		clockController.printTime("siete y treinta");
	}

	@Test
	public void shouldShowInput() throws ClockException {
		clockController.printTime("00:15:00");
	}

}
