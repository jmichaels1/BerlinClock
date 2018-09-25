package com.everis.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author J Michael
 *
 */
public abstract class Lamp {
	
	private static AtomicInteger countID = new AtomicInteger(-1);
	protected int id; 
	protected boolean isTop; // position
	protected int value;  // 5 or 1
	protected String representation;  // "R" or "Y"
	protected boolean isOff;

	/**
	 * Método Constructor
	 * 
	 * @param format
	 * @param value
	 * @param representation
	 */
	public Lamp(boolean isTop) {
		id = countID.incrementAndGet();
		this.isTop = isTop;
		value = isTop? 5 : 1;
		isOff = true;
	}

	/***** Getters And Setters *****/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isTop() {
		return isTop;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	public boolean isOff() {
		return isOff;
	}

	public void setOff(boolean isOff) {
		this.isOff = isOff;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Lamp other = (Lamp) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
