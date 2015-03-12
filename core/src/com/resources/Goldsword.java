/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public class Goldsword extends Resource {

	/**
	 * @param name
	 */
	public Goldsword(String name) {
		super(name);
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Gold");
		resourcesNeeded.add("Gold");
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
