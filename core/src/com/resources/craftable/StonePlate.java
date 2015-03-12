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
public class StonePlate extends Resource {

	/**
	 * @param name
	 */
	public StonePlate() {
		super("StonePlate", 2);
		// assign the resources needed
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
