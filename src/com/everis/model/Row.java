package com.everis.model;

import java.util.ArrayList;


/**
 * 
 * @author J Michael
 *
 */
public class Row {
	
	private int rowID;
	private ArrayList<Lamp> aLamp;
	
//	private Logger log = LogManager.getLogger(getClass().getName());
	
	/**
	 * Método Constructor
	 * @param numRow
	 * @param aLamp
	 */
	public Row(int rowID) {
		this.rowID = rowID;
		initializeLamps(rowID == 0 || rowID ==2);
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
		aLamp = new ArrayList<>();
		for (int i = 0; i < quantLamp(isTop); i++) {
			if (rowID == 0 || rowID == 1) aLamp.add(new HourLamp(isTop));
			else aLamp.add(new MinuteLamp(isTop, isTop && (i == 2 || i == 5 || i == 8)));
		}
	}
	
	/***
	 * quantitat Lamps for Row
	 * @param isTop
	 * @return
	 */
	public int quantLamp(boolean isTop) {
		return isTop && (rowID == 2) ? 11 : 4;
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
