package com.craft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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
import com.resources.craftable.tools.DiamondPickaxe;
import com.resources.craftable.tools.DiamondSword;
import com.resources.craftable.tools.GoldAxe;
import com.resources.craftable.tools.GoldPickaxe;
import com.resources.craftable.tools.GoldSword;
import com.resources.craftable.tools.IronAxe;
import com.resources.craftable.tools.IronPickaxe;
import com.resources.craftable.tools.IronSword;
import com.resources.craftable.tools.StoneAxe;
import com.resources.craftable.tools.StonePickaxe;
import com.resources.craftable.tools.StoneSword;
import com.resources.craftable.tools.WoodAxe;
import com.resources.craftable.tools.WoodPickaxe;
import com.resources.craftable.tools.WoodSword;

public class Craftingbook{

	
	//used to return the resource that can be crafted in addition to the amount you get
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
	//the map used to search what resource can be crafted
	public HashMap<Resource, ArrayList<String>> craftMap;
	
	//-------------------------------------------------------------------------- methods ----------------------------------------------------------
	
	public Craftingbook(){
		initialiseCraftMap();
	}
	
	/**
	 * checking for a possible craftings
	 * @param resources (we want to craft into smth)
	 * @return the Resource that can be crafted
	 */
	private Resource craftsInto(ArrayList<String> resources){
		
		Set<Resource> keySet = craftMap.keySet();
		Object[] keys = keySet.toArray();
		
		// go through possible resources that we can craft (the amount of keys of the craftMap)
		for(int i=0; i<keys.length; i++){
			Resource crafting = (Resource) keys[i];
			ArrayList<String> comparedWithArr = crafting.neededToCraft();
			int checkIfNull = comparedWithArr.size(); //checks if we really have ALL the resources needed
			
			//the resources we get as a parameter as an Array
			Object[] given = resources.toArray();
			
			/**
			 * as we got the resources that we need to craft the resource we are currently checking on (i-for loop) we now
			 * go through the array of resources needed and check if we have exactly those resources as a parameter
			 */
			for(int j=0; j<comparedWithArr.size(); j++){
				String compareWithStr = comparedWithArr.get(j); //we compare the strings so we need the name of the resource
				
				// go through the parameter array to check which resources match and set them to null
				for(int c=0; c<given.length; c++){
					String compareToRes = (String)given[c];
					if(given[c]!=null){
						if(compareToRes.equalsIgnoreCase(compareWithStr)){
							given[c] = null;
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
	
	/**
	 * calls craftsInto and returns the data craftsInto returns as an ReturnForCraftObject
	 * @param resources
	 * @return an object of ReturnForCraft
	 */
	public ReturnForCraft craft(ArrayList<String> resources){
		Resource craft = craftsInto(resources);
		if(craft == null) return null;
		return new ReturnForCraft(craft.getAmount(), craft);
	}
	
	public HashMap<Resource, ArrayList<String>> getCraftingMap(){
		return this.craftMap;
	}
	
	/**
	 * used to add the resources with their recipes so we can use it for identifying the resource that can be crafted out of the given resources
	 */
	private void initialiseCraftMap(){
		
		craftMap = new HashMap<Resource, ArrayList<String>>();
		
		ArrayList<Resource> listOfCraftables = new ArrayList<Resource>();
		
		//Initialising listOfCraftables
		listOfCraftables.add(new DiamondAxe());
		listOfCraftables.add(new DiamondPickaxe());
		listOfCraftables.add(new DiamondPlate());
		listOfCraftables.add(new DiamondSword());
		listOfCraftables.add(new GoldAxe());
		listOfCraftables.add(new GoldPickaxe());
		listOfCraftables.add(new GoldPlate());
		listOfCraftables.add(new GoldSword());
		listOfCraftables.add(new IronAxe());
		listOfCraftables.add(new IronPickaxe());
		listOfCraftables.add(new IronPlate());
		listOfCraftables.add(new IronSword());
		listOfCraftables.add(new StoneAxe());
		listOfCraftables.add(new StonePickaxe());
		listOfCraftables.add(new StonePlate());
		listOfCraftables.add(new StoneSword());
		listOfCraftables.add(new WoodAxe());
		listOfCraftables.add(new WoodPickaxe());
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