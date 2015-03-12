/**
 * 
 */
package com.resources.craftable;

import java.util.ArrayList;

import com.resources.Resource;
import com.resources.ToString;

/**
 * @author Franz
 *
 */
public class DiamondAxe extends Resource{

	/**
	 * @param name
	 */
	public DiamondAxe() {
		super("DiamondAxe");
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
