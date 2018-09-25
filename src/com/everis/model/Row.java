package com.everis.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author J Michael
 *
 */
public class Row {
	
	private static AtomicInteger countID = new AtomicInteger(-1);
	private int rowID;
	private ArrayList<Lamp> aLamp;
	
//	private Logger log = LogManager.getLogger(getClass().getName());
	
	/**
	 * Método Constructor
	 * @param numRow
	 * @param aLamp
	 */
	public Row(boolean isTop) {
		this.rowID = countID.incrementAndGet();
		initializeLamps(isTop);
	}
	
	/***** Getters and Setters ******/

	public int getNumRow() {
		return rowID;
	}

	public void setNumRow(int numRow) {
		this.rowID = numRow;
	}
	
	public ArrayList<Lamp> getaLamp() {
		return aLamp;
	}

	public void setaLamp(ArrayList<Lamp> aLamp) {
		this.aLamp = aLamp;
	}
	
	/******* Métodos Agregados ********/
	 
	
	/**
	 * initialize lamps
	 * @param isTop
	 * @param cantLamps
	 * @param lastIDLamp
	 */
	public void initializeLamps(boolean isTop) {
		int valueLamp = -1;
		int cantLamp = 4;
		
		aLamp = new ArrayList<>();
		
		if (rowID == 0 || rowID == 1)  // for hour lamps
			for (int i = 0; i < cantLamp; i++) 
				aLamp.add(new HourLamp(isTop));
		else { 							// for minute lamps
			if (isTop) cantLamp = 11;
			for (int i = 0; i < cantLamp; i++) {
				boolean isRed = false;
				if (isTop && (i == 2 || i == 5 || i == 8)) isRed = true;
				aLamp.add(new MinuteLamp(isTop, isRed));
			}
		}
	}
	
	/**
	 * update isOFF 
	 * value of Lamp
	 * @param cantUpdate
	 */
	public void updateLamps(int cantUpdate) {
		for (int i = 0; i < cantUpdate; i++) aLamp.get(i).setOff(false);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rowID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Row other = (Row) obj;
		if (rowID != other.rowID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Row [rowID=" + rowID + ", aLamp=" + aLamp + "]";
	}
	
}
