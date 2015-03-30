/**
 * 
 */
package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Damage;
import com.resources.Resource;

/**
 * @author michael
 *
 */
public class DiamondSword extends Resource implements Damage {

	/**
	 * @param name
	 */
	public DiamondSword() {
		super("DiamondSword", 1);
		// assign the resources needed
		resourcesNeeded.add("Stick");
		resourcesNeeded.add("DiamondPlate");
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

	@Override
	public int dealsDamage() {
		return 25;
	}
}
