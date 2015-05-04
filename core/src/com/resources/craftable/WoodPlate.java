/**
 * 
 */
package com.resources.craftable;

import java.util.ArrayList;

import com.resources.Resource;

/**
 * @author michael
 *
 */
public class WoodPlate extends Resource {

	/**
	 * @param name
	 */
	public WoodPlate() {
		super("WoodPlate", 2);
		// assign the resources needed
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("WoodStick");
	}

	/* (non-Javadoc)
	 * @see com.resources.Craftable#neededToCraft()
	 */
	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}

}
