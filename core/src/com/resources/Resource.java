/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 * main class that is used to extend all resources themselves
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
}