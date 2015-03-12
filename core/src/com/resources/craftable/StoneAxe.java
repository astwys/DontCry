/**
 * 
 */
package com.resources.craftable;

import java.util.ArrayList;

import com.resources.Resource;

/**
 * @author michael
 * 
 * Used to mine stone
 */
public class StoneAxe extends Resource{
	
	public StoneAxe() {
		super("StoneAxe");
		// assign the resources needed
		resourcesNeeded.add("Stick");
		resourcesNeeded.add("StonePlate");
		resourcesNeeded.add("StonePlate");
	}

	/* (non-Javadoc)
	 * @see com.resources.IfCraftable#neededToCraft()
	 */
	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}
}
