/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public class Ironaxe extends Resource {

	/**
	 * @param name
	 */
	public Ironaxe(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Iron");
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
