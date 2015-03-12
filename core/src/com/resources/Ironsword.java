/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public class Ironsword extends Resource {

	/**
	 * @param name
	 */
	public Ironsword(String name) {
		super(name);
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Iron");
		resourcesNeeded.add("Iron");
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
