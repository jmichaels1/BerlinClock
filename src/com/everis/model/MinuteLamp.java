package com.everis.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinuteLamp extends Lamp {
	
	/**
	 * Método Constructor
	 * @param isTop
	 * @param isRed
	 */
	public MinuteLamp(boolean isTop, boolean isRed) {
		super(isTop);
		if (isRed) representation = "R";
		else representation = "Y";
	}


}
