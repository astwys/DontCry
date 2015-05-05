package com.resources.craftable.tools;

import java.util.ArrayList;

import com.resources.Resource;
import com.resources.Tool;

public class DiamondPickaxe extends Resource implements Tool {

	public DiamondPickaxe() {
		super("DiamondPickaxe", 1);
		// assign the resources needed
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("WoodStick");
		resourcesNeeded.add("DiamondPlate");
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return resourcesNeeded;
	}

}
