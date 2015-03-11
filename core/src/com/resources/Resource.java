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
	ArrayList<String> resourcesNeeded;
	
	public Resource(String name) {
		name=name;
		resourcesNeeded=new ArrayList<String>();
	}
}