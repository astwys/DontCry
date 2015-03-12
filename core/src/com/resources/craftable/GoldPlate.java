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
public class GoldPlate extends Resource {

	/**
	 * @param name
	 */
	public GoldPlate() {
		super("GoldPlate");
		resourcesNeeded.add("2");
		resourcesNeeded.add("Gold");
		resourcesNeeded.add("Gold");
		resourcesNeeded.add("Gold");
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
