package com.everis.view;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.everis.model.Lamp;
import com.everis.model.Row;

/**
 * 
 * @author J Michael
 *
 */
public class ClockPrinter {
	
	private static final String TOP_LAMP = "Y";
	private static final String LAMP_OFF = "O";
	private StringBuilder r;
	
	private Logger log = LogManager.getLogger(getClass().getName());

	/**
	 * print Berlin Clock
	 */
	public void printBerlinClock(ArrayList<Row> aListRows) {

		System.out.printf("\t\t\t %s\n\n", TOP_LAMP);
		for (int i = 0; i < aListRows.size(); i++)
			printRow(aListRows.get(i).getaLamp(), i);
		
		log.info("the time has been printed");

	}
	
	/**
	 * print row
	 * 
	 * @param aListLamp
	 */
	private void printRow(ArrayList<Lamp> aListLamp, int numRow) {

		r = new StringBuilder();
		
		aListLamp.stream().forEach((lamp) -> {
			r.append(lamp.isOff()? LAMP_OFF : lamp.getRepresentation());
			r.append(String.format(" %" + (numRow != 2? "14" : "3") + "s", ""));
		});
		
		System.out.print(r.append("\n\n"));
	}

}
