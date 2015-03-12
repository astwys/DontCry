/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public class Diamondsword extends Resource {

	/**
	 * @param name
	 */
	public Diamondsword(String name) {
		super(name);
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Diamond");
		resourcesNeeded.add("Diamond");
		resourcesNeeded.add("Diamond");
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
