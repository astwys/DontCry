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
public class DiamondPlate extends Resource {

	/**
	 * @param name
	 */
	public DiamondPlate() {
		super("DiamondPlate");
		resourcesNeeded.add("2");
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
