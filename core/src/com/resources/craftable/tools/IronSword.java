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
public class IronSword extends Resource implements Damage {
	
	public IronSword() {
		super("IronSword", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("IronPlate");
		resourcesNeeded.add("IronPlate");
		resourcesNeeded.add("IronPlate");
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}

	@Override
	public int dealsDamage() {
		return 15;
	}
}
