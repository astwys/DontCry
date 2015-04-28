/**
 * 
 */
package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Resource;
import com.resources.Tool;

/**
 * @author michael
 *
 */
public class GoldAxe extends Resource implements Tool{

	/**
	 * @param name
	 */
	public GoldAxe() {
		super("GoldAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
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
