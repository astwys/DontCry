package com.craft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.resources.Craftable;
import com.resources.Resource;
import com.resources.craftable.DiamondPlate;
import com.resources.craftable.Fire;
import com.resources.craftable.GoldPlate;
import com.resources.craftable.IronPlate;
import com.resources.craftable.StonePlate;
import com.resources.craftable.WoodPlate;
import com.resources.craftable.WoodStick;
import com.resources.craftable.edible.Chips;
import com.resources.craftable.potions.HealthPotionBig;
import com.resources.craftable.potions.HealthPotionSmall;
import com.resources.craftable.tools.DiamondAxe;
import com.resources.craftable.tools.DiamondSword;
import com.resources.craftable.tools.GoldAxe;
import com.resources.craftable.tools.GoldSword;
import com.resources.craftable.tools.IronAxe;
import com.resources.craftable.tools.IronSword;
import com.resources.craftable.tools.StoneAxe;
import com.resources.craftable.tools.StoneSword;
import com.resources.craftable.tools.WoodAxe;
import com.resources.craftable.tools.WoodSword;

public class Craftingbook{

	
	//special class for returning the craft (out of some resources) and the amount that is crafted
	public class ReturnForCraft{
		int amount;
		Resource craftable;
		
		public ReturnForCraft(int amount, Resource craftable){
			this.amount = amount;
			this.craftable = craftable;
		}
		
		public Resource getResource(){
			return craftable;
		}
		
		public int getAmount(){
			return amount;
		}
		
		public String toString(){
			return craftable.toString()+" x"+amount;
		}
		
	}
	
	
	//-------------------------------------------------------------------------- fields -----------------------------------------------------------
	
	public HashMap<Resource, ArrayList<String>> craftMap;
	
	//-------------------------------------------------------------------------- methods ----------------------------------------------------------
	
	public Craftingbook(){
		initialiseCraftMap();
	}
	
	//checking for a possible crafting
	private Resource craftsInto(ArrayList<String> resources){
		
		Set<Resource> keySet = craftMap.keySet();
		Object[] keys = keySet.toArray();
		
		// go through possible crafts
		for(int i=0; i<keys.length; i++){
			Resource crafting = (Resource) keys[i];
			ArrayList<String> comparedWithArr = crafting.neededToCraft();
			
			Object[] required = resources.toArray();
			int checkIfNull = comparedWithArr.size();
			
			// go through the resources needed for crafting
			for(int j=0; j<comparedWithArr.size(); j++){
				String compareWithStr = comparedWithArr.get(j);
				
				// go through the parameter array to check which resources match and set them to null
				for(int c=0; c<required.length; c++){
					String compareToRes = (String)required[c];
					if(required[c]!=null){
						if(compareToRes.equalsIgnoreCase(compareWithStr)){
							required[c] = null;
							checkIfNull--;
							break;
						}
					}
				}// c for
				
			}// j for
			
			if(checkIfNull == 0){
				return (Resource) keys[i];
			}
			
		}// i for
		
		return null;
		
	}
	
	public ReturnForCraft craft(ArrayList<String> resources){
		Resource craft = craftsInto(resources);
		if(craft == null) return null;
		return new ReturnForCraft(craft.getAmount(), craft);
	}
	
	public HashMap<Resource, ArrayList<String>> getCraftingMap(){
		return this.craftMap;
	}
	
	private void initialiseCraftMap(){
		
		craftMap = new HashMap<Resource, ArrayList<String>>();
		
		ArrayList<Resource> listOfCraftables = new ArrayList<Resource>();
		
		//Initialising listOfCraftables
		listOfCraftables.add(new DiamondAxe());
		listOfCraftables.add(new DiamondPlate());
		listOfCraftables.add(new DiamondSword());
		listOfCraftables.add(new GoldAxe());
		listOfCraftables.add(new GoldPlate());
		listOfCraftables.add(new GoldSword());
		listOfCraftables.add(new IronAxe());
		listOfCraftables.add(new IronPlate());
		listOfCraftables.add(new IronSword());
		listOfCraftables.add(new StoneAxe());
		listOfCraftables.add(new StonePlate());
		listOfCraftables.add(new StoneSword());
		listOfCraftables.add(new WoodAxe());
		listOfCraftables.add(new WoodPlate());
		listOfCraftables.add(new WoodStick());
		listOfCraftables.add(new WoodSword());
		listOfCraftables.add(new Fire());
		listOfCraftables.add(new Chips());
		listOfCraftables.add(new HealthPotionBig());
		listOfCraftables.add(new HealthPotionSmall());

		
		//initialising the actual craftMap
		for(int i=0; i<listOfCraftables.size(); i++){
			craftMap.put(listOfCraftables.get(i), listOfCraftables.get(i).neededToCraft());
		}
	}


}