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
public class StoneSword extends Resource implements Damage {

	/**
	 * @param name
	 */
	public StoneSword() {
		super("StoneSword", 1);
		// assign the resources needed
		resourcesNeeded.add("Stick");
		resourcesNeeded.add("StonePlate");
		resourcesNeeded.add("StonePlate");
		resourcesNeeded.add("StonePlate");
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
		return 10;
	}
}