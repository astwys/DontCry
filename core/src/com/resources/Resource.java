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

	public Resource(String name) {
		this.name=name;
		resourcesNeeded=new ArrayList<String>();
	}
	
	public String getName() {
		return this.name;
	}
}