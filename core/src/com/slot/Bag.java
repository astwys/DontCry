package com.slot;

import javax.annotation.Resource;

/*
 * author jonas
 */

public class Bag {

	private Slot[] resource;
	
	public Bag() {
		super();
		resource = new Slot[12];
	}
	
	
	/*	
	 * adds resources to a slot and 
	 * returns the resources, which couldn't be added
	 * 
	 * checks if
	 *  	you add the same resource
	 *  	it has enough free space
	 *  	if you add a valid resource
	 */
	public void add(Resource r, int plus) {
			
	}
	
	/*
	 * deletes certain resource
	 *
	 * checks if
	 * 		the SLOT contains the resource
	 */
	public void dispose(Resource r, int amount) {
		
	}
		
	public boolean clearSlot(int index) {
		if(resource[index].isEmpty())
		return false;
	}
		
}
