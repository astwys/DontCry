package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Resource;
import com.resources.Tool;

public class GoldPickaxe extends Resource implements Tool {

	public GoldPickaxe() {
		super("GoldPickaxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("GoldPlate");
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}
}
