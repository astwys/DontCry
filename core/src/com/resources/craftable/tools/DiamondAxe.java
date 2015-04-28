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
public class DiamondAxe extends Resource implements Tool{

	/**
	 * @param name
	 */
	public DiamondAxe() {
		super("DiamondAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("DiamondPlate");
		resourcesNeeded.add("DiamondPlate");
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
