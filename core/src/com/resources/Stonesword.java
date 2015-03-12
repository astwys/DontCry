/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public class Stonesword extends Resource {

	/**
	 * @param name
	 */
	public Stonesword(String name) {
		super(name);
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Stone");
		resourcesNeeded.add("Stone");
		resourcesNeeded.add("Stone");
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
