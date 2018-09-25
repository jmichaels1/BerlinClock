package com.everis.principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.everis.controller.ClockController;
import com.everis.model.ClockException;

/**
 * 
 * @author J Michael
 *
 */
public class Main {
	
	private static Logger log = LogManager.getLogger("Main");

	
	 public static void main(String[] args) {
		 
		 try {
			 
			 ClockController controller = new ClockController();
			 controller.printTime("05:24:00");
			
		} catch (ClockException e) {
			log.fatal(e.getMessage());
		}
	}

}
