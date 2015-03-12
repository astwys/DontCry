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
public class WoodStick extends Resource {

	/**
	 * @param name
	 */
	public WoodStick() {
		super("WoodStick");
		// assign the resources needed
		resourcesNeeded.add("4");
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Wood");
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
