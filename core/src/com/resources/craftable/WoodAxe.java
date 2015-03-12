/**
 * 
 */
package com.resources.craftable;

import java.util.ArrayList;

import com.resources.Resource;

/**
 * @author michael
 * used to cut trees
 * used to
 */
public class WoodAxe extends Resource{
	/**
	 * @param name
	 */
	public WoodAxe() {
		super("WoodAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("Stick");
		resourcesNeeded.add("WoodPlate");
		resourcesNeeded.add("WoodPlate");
	}

	/* (non-Javadoc)
	 * @see com.resources.IfCraftable#neededToCraft()
	 */
	@Override
	public ArrayList<String> neededToCraft() {
		// TODO Auto-generated method stub
		return resourcesNeeded;
	}
}
