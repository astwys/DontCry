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
	
	public String getName() {
		return this.name;
	}
	
	public int getAmount() {
		return this.amount;
	}
}