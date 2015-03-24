package com.slot;

import com.resources.*;

/*
 * author jonas
 */

public class Slot {

	//the type of resource in the SLOT
	private Resource resource;
	
	//amount = how much the SLOT contains
	private int amount;
	
	//size = the max size of the SLOT
	private static int size = 32;
	
	
	
	/*
	 * default constructor
	 * 		sets the SIZE of the SLOT
	 * 		sets the type of RESOURCE
	 * 		sets the AMOUNT of resources
	 */
	public Slot(Resource r, int a) {
		super();
		setSize(Slot.size);
		setResource(r);
		setAmount(a);
		// TODO Auto-generated constructor stub
	}

	/*
	 * returns the size of the SLOT
	 */
	public int getSize() {
		return Slot.size;
	}
	
	/*
	 * sets the max size of the SLOT --> default value
	 */
	public void setSize(int size) {
		Slot.size = size;
	}

	/*
	 * returns how much resources are in the SLOT
	 */
	public int getAmount() {
		return this.amount;
	}
	
	/*
	 * sets the amount of the resource in the SLOT
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/*
	 * returns how much resource you can add to the SLOT
	*/
	public int resourcesToAdd() {
		return getSize()-getAmount();
		//return this.size-this.amount;
	}
	
	/*
	 * returns the type of the resource
	 */
	public Resource getResource() {
		return this.resource;
	}
	
	/*
	 * sets the type of resource
	 */
	public void setResource(Resource r) {
		this.resource = r;
	}

	@Override
	public String toString() {
		return "Slot [resource=" + this.resource + ", amount=" + this.amount + "size=" + Slot.size +"]";
	}
	
	
}
