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

	public WoodSword() {
		super("WoodSword", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("WoodPlate");
		resourcesNeeded.add("WoodPlate");
		resourcesNeeded.add("WoodPlate");
		
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}

	@Override
	public int dealsDamage() {
		return 5;
	}
}
