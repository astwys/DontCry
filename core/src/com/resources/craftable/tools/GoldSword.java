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
public class GoldSword extends Resource {

	/**
	 * @param name
	 */
	public GoldSword() {
		super("GoldSword", 1);
		// assign the resources needed
		resourcesNeeded.add("Stick");
		resourcesNeeded.add("GoldPlate");
		resourcesNeeded.add("GoldPlate");
		resourcesNeeded.add("GoldPlate");
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
