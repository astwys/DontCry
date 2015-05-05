package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Resource;
import com.resources.Tool;

/**
 * @author michael
 * 
 * Used to mine stone
 */
public class StoneAxe extends Resource implements Tool{
	
	public StoneAxe() {
		super("StoneAxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("StonePlate");
		resourcesNeeded.add("StonePlate");
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}
}
