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
public class IronAxe extends Resource implements Tool{

	/**
	 * @param name
	 */
	public IronAxe() {
		super("IronAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("Stick");
		resourcesNeeded.add("IronPlate");
		resourcesNeeded.add("IronPlate");
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
