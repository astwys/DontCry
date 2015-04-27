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
public class WoodSword extends Resource implements Damage {

	/**
	 * @param name
	 * @param amount
	 */
	public WoodSword() {
		super("WoodSword", 1);
		// assign the resources needed
		resourcesNeeded.add("Stick");
		resourcesNeeded.add("WoodPlate");
		resourcesNeeded.add("WoodPlate");
		resourcesNeeded.add("WoodPlate");
		
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
		return 5;
	}
}
