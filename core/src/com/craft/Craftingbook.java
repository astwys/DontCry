package com.craft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.resources.*;
import com.resources.craftable.*;
import com.resources.natural.*;

public class Craftingbook{

	
	public class ReturnForCraft{
		int amount;
		Craftable craftable;
		
		public ReturnForCraft(int amount, Resource craftable){
			this.amount = amount;
			this.craftable = craftable;
		}
	}
	
	private int totalEntries, entries;
	private Craft[] craftings;
	
	public HashMap<Resource, ArrayList<String>> craftMap;
	
	public Craftingbook(){
		initialiseCraftMap();
		totalEntries = craftMap.size();
		entries = 0;
		craftings = new Craft[totalEntries];
	}
	
	public boolean newEntry(ArrayList<String> resources, Resource crafting){
		
		
		return false;
	}
	
	//checking for a possible crafting
	private Resource craftsInto(ArrayList<String> resources){
		
		Set keySet = craftMap.keySet();
		Object[] keys = keySet.toArray();
		
		// go through possible crafts
		for(int i=0; i<keys.length; i++){
			Resource crafting = (Resource) keys[i];
			ArrayList<String> comparedWithArr = crafting.neededToCraft();
			
			Object[] required = resources.toArray();
			int checkIfNull = required.length;
			
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
	
	
	private void initialiseCraftMap(){
		
		craftMap = new HashMap<Resource, ArrayList<String>>();
		
		ArrayList<Resource> listOfCraftables = new ArrayList<Resource>();
		
		//Initialising listOfCraftables
		listOfCraftables.add(new DiamondAxe());
		listOfCraftables.add(new DiamondSword());
		listOfCraftables.add(new GoldAxe());
		listOfCraftables.add(new GoldSword());
		listOfCraftables.add(new IronAxe());
		listOfCraftables.add(new IronSword());
		listOfCraftables.add(new StoneAxe());
		listOfCraftables.add(new StoneSword());

		
		//initialising the actual craftMap
		for(int i=0; i<listOfCraftables.size(); i++){
			craftMap.put(listOfCraftables.get(i), listOfCraftables.get(i).neededToCraft());
		}
	}


}