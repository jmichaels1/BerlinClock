package com.everis.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.everis.model.ClockException;
import com.everis.model.Row;
import com.everis.view.ClockPrinter;

/**
 * 
 * @author J Michael
 *
 */
public class ClockController {

	private int hour;
	private int minute;
	private int second;

	private String[] aTime;
	private ArrayList<Row> aListRow;

	private ClockPrinter clockPrinter;
	private Logger log = LogManager.getLogger(getClass().getName());

	private static final String TIME_REGEX = "^([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?$";

	/**
	 * Method Constructor
	 * @param clockPrinter
	 */
	public ClockController(ClockPrinter clockPrinter) {
		this.clockPrinter = clockPrinter;
	}

	/**
	 * get time for print
	 * 
	 * @throws ClockException
	 */
	public void printTime(String time) throws ClockException {

		if (!time.matches(TIME_REGEX)) throw new ClockException("time format invalid");

		aTime = time.split(":");

		hour = Integer.parseInt(aTime[0]);
		minute = Integer.parseInt(aTime[1]);
		second = Integer.parseInt(aTime[2]);

		generateLamps();
	}

	/**
	 * generates lamps
	 */
	public void generateLamps() {

		inizializeRowsAndLamps();
		manageSettingsLamps(hour, true);
		manageSettingsLamps(minute, false);
		clockPrinter.printClock(aListRow);
	}

	/***
	 * Inicializa Rows (and Lamps)
	 */
	private void inizializeRowsAndLamps() {
		aListRow = new ArrayList<>();
		for (int i = 0; i < 4; i++) aListRow.add(new Row(i));
	}

	/**
	 * manageSettingsLamps
	 * 
	 * @param hourORminute
	 * @param isHour
	 */
	private void manageSettingsLamps(int hourORminute, boolean isHour) {
		int low = hourORminute % 5;
		int top = hourORminute / 5; 
		int aux = (!isHour)?2:0;
		aListRow.get(aux).updateLamps(top);
		aListRow.get(++aux).updateLamps(low);
	}

}
