/**
 * 
 */
package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Resource;

/**
 * @author michael
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
