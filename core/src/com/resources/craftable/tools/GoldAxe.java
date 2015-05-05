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
public class GoldAxe extends Resource implements Tool{

	public GoldAxe() {
		super("GoldAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("GoldPlate");
		resourcesNeeded.add("GoldPlate");
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}

}
