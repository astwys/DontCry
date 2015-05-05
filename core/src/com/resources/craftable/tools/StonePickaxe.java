package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Resource;
import com.resources.Tool;

public class StonePickaxe extends Resource implements Tool {

	public StonePickaxe() {
		super("StonePickaxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("StonePlate");
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}

}
