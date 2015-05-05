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

	public StoneSword() {
		super("StoneSword", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("StonePlate");
		resourcesNeeded.add("StonePlate");
		resourcesNeeded.add("StonePlate");
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}

	@Override
	public int dealsDamage() {
		return 10;
	}
}
