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
	 * get time for print
	 * @throws ClockException 
	 */
	public void printTime(String time) throws ClockException {
		
		try {
			if (!time.matches(TIME_REGEX)) throw new ClockException("time format invalid");
			
			aTime = time.split(":");
			
			hour = Integer.parseInt(aTime[0]);
			minute = Integer.parseInt(aTime[1]);
			second = Integer.parseInt(aTime[2]);
			
			validarTime();
			generateLamps();
			
		} catch (NumberFormatException e) {
			log.fatal(e.getMessage() + "-" + "Formato de Hora no válida !!");
		
		} catch (ClockException e) {
			log.fatal(e.getMessage());
		}
	}
	
	/**
	 * validate time
	 */
	private void validarTime() throws ClockException {
		if (hour < 0 || hour > 24) throw new ClockException("Invalid Hour");
		if (minute < 0 || minute > 59) throw new ClockException("Invalid Minute");
		if (second < 0 || second > 59) throw new ClockException("Invalid Second");
	//	log.debug("Valid time");
	}

	/**
	 * generates lamps
	 */
	public void generateLamps() {
		clockPrinter = new ClockPrinter();
		
		inizializeRowsAndLamps();
		manageSettingsLamps(hour, true);
		manageSettingsLamps(minute, false);
		clockPrinter.printBerlinClock(aListRow);
	}
	
	/***
	 * Inicializa Rows (and Lamps)
	 */
	private void inizializeRowsAndLamps() {
		aListRow = new ArrayList<>();
		for (int i = 0; i < 4; i++) aListRow.add(new Row(i % 2 == 0));
	}
	
	/**
	 * manageSettingsLamps
	 * @param hourORminute
	 * @param isHour
	 */
	private void manageSettingsLamps(int hourORminute, boolean isHour) {
		int low = hourORminute % 5;
		int top = (hourORminute - low) / 5;
		int aux = 0;
		
		if (!isHour) aux = 2;
		aListRow.get(aux++).updateLamps(top);
		aListRow.get(aux++).updateLamps(low);
	}

}
