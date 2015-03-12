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
public class GoldSword extends Resource {

	/**
	 * @param name
	 */
	public GoldSword() {
		super("GoldSword");
		// assign the resources needed
		resourcesNeeded.add("Wood");
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
