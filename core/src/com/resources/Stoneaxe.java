/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 * 
 * Used to mine stone
 */
public class Stoneaxe extends Resource{
	private String name="Stoneaxe";
	
	public Stoneaxe(String name) {
		super(name);
		// assign the resources needed
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Wood");
		resourcesNeeded.add("Stone");
	}

	/* (non-Javadoc)
	 * @see com.resources.IfCraftable#neededToCraft()
	 */
	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}
}
