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
public class IronPlate extends Resource {

	/**
	 * @param name
	 */
	public IronPlate() {
		super("IronPlate", 2);
		// assign the resources needed
		resourcesNeeded.add("Iron");
		resourcesNeeded.add("Iron");
		resourcesNeeded.add("Iron");
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
