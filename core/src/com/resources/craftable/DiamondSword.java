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
public class DiamondSword extends Resource {

	/**
	 * @param name
	 */
	public DiamondSword() {
		super("DiamondSword");
		// assign the resources needed
		resourcesNeeded.add("Wood");
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
