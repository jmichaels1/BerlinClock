package com.everis.principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.everis.controller.ClockController;
import com.everis.model.ClockException;
import com.everis.view.ClockPrinterConsole;

/**
 * 
 * @author J Michael
 *
 */
public class Main {
	
	private static Logger log = LogManager.getLogger("Main");

	
	 public static void main(String[] args) {
		 
		 try {
			 
			 ClockController controller = new ClockController(new ClockPrinterConsole());
			 controller.printTime("22:55:12");
			
		} catch (ClockException e) {
			
			log.fatal(e.getMessage());

		}
	}

}
