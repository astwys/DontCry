/**
 * 
 */
package com.resources.craftable;

import java.util.ArrayList;

import com.resources.Resource;

/**
 * @author Franz
 *
 */
public class DiamondAxe extends Resource{

	/**
	 * @param name
	 */
	public DiamondAxe() {
		super("DiamondAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("Stick");
		resourcesNeeded.add("DiamondPlate");
		resourcesNeeded.add("DiamondPlate");
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
