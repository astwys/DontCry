package com.slot;

import javax.annotation.Resource;

/*
 * date 23/03
 * author jonas
 */

public class Slot {

	private Resource resource;
	private int amount;
	private static int full = 32;
	
	
	
	public Slot(Resource r, int a, int plus) {
		super();
		setSlot(r,a);
		add(plus);
		// TODO Auto-generated constructor stub
	}

	public int setSlot(Resource r, int amount) {
		return amount;
	}
	
	public Resource getResource() {
		return this.resource;
	}
	
	public int add(int plus) {
		//if there is something to add
		if (plus > 0) {
			//if the SLOT is empty, it doesn't matter which resource you add
			if(resource) {
				this.resource.getName() = re
			}
			return plus;
		}
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
