/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 * used to cut trees
 * used to
 */
public class Axe extends Resource{
	/**
	 * @param name
	 */
	public Axe(String name) {
		super(name);
		// assign the resources needed
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Stone");
		resourcesNeeded.add("Stone");
	}

	/* (non-Javadoc)
	 * @see com.resources.IfCraftable#neededToCraft()
	 */
	@Override
	public ArrayList<String> neededToCraft() {
		// TODO Auto-generated method stub
		return resourcesNeeded;
	}
}
