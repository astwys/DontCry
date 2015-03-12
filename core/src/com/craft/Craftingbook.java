package com.craft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.resources.Axe;
import com.resources.Craftable;
import com.resources.Diamondsword;
import com.resources.Goldaxe;
import com.resources.Goldsword;
import com.resources.Ironaxe;
import com.resources.Ironsword;
import com.resources.Resource;
import com.resources.Stoneaxe;
import com.resources.Stonesword;

public class Craftingbook{

	
	public class ReturnForCraft{
		int amount;
		Craftable craftable;
		
		public ReturnForCraft(int amount, Craftable craftable){
			this.amount = amount;
			this.craftable = craftable;
		}
	}
	
	private int totalEntries, entries;
	private Craft[] craftings;
	
	public HashMap<Craftable, ArrayList<String>> craftMap;
	
	public Craftingbook(){
		initialiseCraftMap();
		totalEntries = craftMap.size();
		entries = 0;
		craftings = new Craft[totalEntries];
	}
	
	public boolean newEntry(ArrayList<String> resources, Craftable crafting){
		
		
		return false;
	}
	
	//checking for a possible crafting
	private Craftable craftsInto(ArrayList<String> resources){
		
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
						}
					}
				}// c for
				
			}// j for
			
			if(checkIfNull == 0){
				return (Craftable)keys[i];
			}
			
		}// i for
		
		return null;
		
	}
	
	public ReturnForCraft craft(ArrayList<String> resources){
		Craftable craft = craftsInto(resources);
		return new ReturnForCraft(craft.getAmount(), craft);
	}
	
	
	private void initialiseCraftMap(){
		
		craftMap = new HashMap<Craftable, ArrayList<String>>();
		
		ArrayList<Craftable> listOfCraftables = new ArrayList<Craftable>();
		
		//Initialising listOfCraftables
		listOfCraftables.add(new Axe("axe"));
//		listOfCraftables.add(new Diamondaxe());
//		listOfCraftables.add(new Diamondsword());
//		listOfCraftables.add(new Goldaxe());
//		listOfCraftables.add(new Goldsword());
//		listOfCraftables.add(new Ironaxe());
//		listOfCraftables.add(new Ironsword());
//		listOfCraftables.add(new Stoneaxe());
//		listOfCraftables.add(new Stonesword());
//		listOfCraftables.add(new Axe());
//		listOfCraftables.add(new Axe());
		
		//initialising the actual craftMap
		for(int i=0; i<listOfCraftables.size(); i++){
			craftMap.put(listOfCraftables.get(i), listOfCraftables.get(i).neededToCraft());
		}
	}


}