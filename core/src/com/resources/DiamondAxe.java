/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author Franz
 *
 */
public class DiamondAxe extends Resource {

	/**
	 * @param name
	 */
	public DiamondAxe(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Diamnond");
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
