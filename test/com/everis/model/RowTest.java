package com.everis.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RowTest {
	
	private Row row1;
	private Row row2;

	@Test
	void shouldShowInput1() {
		row1 = new Row(0);
		assertTrue(row1.quantLamp(true) == 4);
	}
	
	@Test
	void shouldShowInput2() {
		row1 = new Row(0);
		row2 = new Row(1);
		assertFalse(row2.quantLamp(false) == 11);
	}

}
