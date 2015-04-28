/**
 * 
 */
package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Resource;
import com.resources.Tool;

/**
 * @author michael
 * used to cut down trees
 * 
 */
public class WoodAxe extends Resource implements Tool{
	/**
	 * @param name
	 */
	public WoodAxe() {
		super("WoodAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
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
