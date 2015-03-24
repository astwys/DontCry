package com.slot;

import com.resources.*;

/*
 * author jonas
 */

public class Bag {

	private Slot[] resources;
	
	public Bag() {
		super();
		resources = new Slot[12];
	}
	
	
	/*	
	 * adds resources to a slot and 
	 * returns the resources, which couldn't be added
	 * 
	 * checks if
	 *  	you add the same resource
	 *  	it has enough free space
	 *  	if you add a valid resource OR amount
	 */
	public int add(Resource r, int plus) {
		if(r != null || plus > 0) {
			for(int i = 0; i < resources.length || plus==0; i++) {
				if(resources[i].getResource() == r) {
					if(resources[i].resourcesToAdd() < plus) {
						plus -= resources[i].resourcesToAdd();
						resources[i].setAmount(resources[i].getSize());
					}
					else {
						plus = 0;
						resources[i].setAmount(resources[i].getAmount()+plus);
					}
				}
			}
		}
		return plus;
	}
	
	/*
	 * deletes certain type of resources and
	 * returns true if sth is deleted
	 * 		(5 wood and you want to delete 6, it doesn't care and deletes all 5)
	 * returns false if resource is not existent
	 *
	 * checks if
	 * 		the SLOT contains the resource
	 */
//	public boolean dispose(Resource r, int amount) {
//		
//		if(r != null || amount != 0) {
//			for(int i = 0; i < resources.length; i++) {
//				if(resources[i].getResource() == r) {
//					if(resources[i].getAmount() < amount) {
//						
//					}
//				}
//			}
//		}
//		return false;//only if resource doesn't exist
//	}
	
	/*
	 * deletes all resources in a specified SLOT
	 */
	public boolean clearSlot(int index) {
		if(!resources[index].isEmpty()) {
			resources[index].setAmount(0);
			return true;
		}
		return false;
	}

	
	/*
	 * deletes all resources in the whole backpack
	 */
	public void clearBackpack() {
		for(int i = 0; i<resources.length; i++) {
			if(!resources[i].isEmpty()) {
				resources[i].setAmount(0);
			}
		}
	}
}
