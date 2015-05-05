/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 * main class that is used to extend all resources themselves
 * 
 * resources are seperated into natural and craftable resources
 * 
 * natural: these resourcese can only be found in nature which means you can't craft them
 * craftable: you cannot find these resources in nature; they have to be crafted
 */
public abstract class Resource implements Craftable{
	protected ArrayList<String> resourcesNeeded;
	private String name;
	private int amount;

	public Resource(String name, int amount) {
		this.name=name;
		this.amount=amount;
		resourcesNeeded=new ArrayList<String>();
	}
	
	/*
	 * get name of current resource
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * amount of items of the resource you are currently crafting
	 */
	public int getAmount() {
		return this.amount;
	}
	
	public ArrayList<String> getResourcesNeeded(){
		return resourcesNeeded;
	}
	
	// ---------------------------------- 0815 methods ----------------------------------------------
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName();
	}
	
	public boolean equals(Object obj){
		Resource r = (Resource)obj;
		return this.getName().equals(r.getName()) ? true : false;
	}
	
}