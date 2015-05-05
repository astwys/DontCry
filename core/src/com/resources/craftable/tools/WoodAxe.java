/**
 * 
 */
package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Resource;
import com.resources.Tool;

/**
 * @author michael
 * used to cut down trees
 * 
 */
public class WoodAxe extends Resource implements Tool{
	
	public WoodAxe() {
		super("WoodAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("WoodPlate");
		resourcesNeeded.add("WoodPlate");
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}
}
