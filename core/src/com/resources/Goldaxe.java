/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public class Goldaxe extends Resource {

	/**
	 * @param name
	 */
	public Goldaxe(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Gold");
	}

	/* (non-Javadoc)
	 * @see com.resources.Craftable#neededToCraft()
	 */
	@Override
	public ArrayList<String> neededToCraft() {
		// TODO Auto-generated method stub
		return resourcesNeeded;
	}

}
