package com.slot;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.resources.Edible;
import com.resources.Potions;
import com.resources.Resource;
import com.resources.Tool;
import com.resources.craftable.edible.Chips;
import com.resources.craftable.potions.HealthPotionBig;
import com.resources.craftable.potions.HealthPotionSmall;
import com.resources.natural.edible.Apple;
import com.resources.natural.edible.Potato;
import com.resources.natural.edible.RedFlower;
import com.resources.natural.edible.YellowFlower;

/*
 * author jonas
 */

public class Bag extends Actor {

	private com.character.Character player; //the player the bag refers to
	private Slot[] resources;
	private int selectedIndex = 0;
	
	//for moving items
	private Slot itemTaken;
	private int indexTaken;
	
	/**
	 * 
	 * @param character
	 */
	public Bag(com.character.Character character) {
		super();
		resources = new Slot[12];
		player = character;
		for(int i=0; i<resources.length; i++){
			resources[i] = new Slot();
		}
		
		setSelected(0);
		indexTaken = -1;
		itemTaken = null;
	}
	
	/**
	 * adds resources to a slot and 
	 * returns the resources, which couldn't be added
	 * 
	 * checks if
	 * 		you add a valid resource OR amount
	 *  	you add the same resource OR the SLOT is empty
	 *  	it has enough free space
	 *  	
	 *  returns how many objects couldn't be added
	 *  
	 * @param r
	 * @param plus
	 * @return
	 */
	public int add(Resource r, int plus) {
		if(plus > Slot.size) plus = Slot.size;
		
		if(r != null && plus > 0) {
			
			for(int i = 0; i < resources.length && plus > 0; i++) {
				if(resources[i].isEmpty()) {
					resources[i].setResource(r);
					resources[i].setAmount(plus);
					plus = 0;
					return plus;
				}else if(resources[i].getResource().equals(r)){
					if(resources[i].resourcesToAdd() < plus) {
						plus -= resources[i].resourcesToAdd();
						resources[i].setAmount(resources[i].getSize());
					}else {
						resources[i].setAmount(resources[i].getAmount() + plus);
						plus = 0;
					}
				}
			}
		}
		return plus;
	}
	
	/**
	 * places the item if you want to change the place in the slot
	 * 		
	 * 		if you change with the same slot, nothing will be changed
	 * 
	 * 		if the selected spot is empty, the empty one gets replaced with the filled one and the filled one will be empty
	 * 
	 * 		if the selected spot is not empty, the two slots are replaced by each other
	 * 		
	 */
	public void placeItem(){
		if(itemTaken != null && itemTaken.getResource() != null && itemTaken.getAmount() > 0){
			
			if(selectedIndex == indexTaken){
				resources[selectedIndex].setTaken(false);
				itemTaken = null;
				indexTaken = -1;
				return;
			}
			
			if(resources[selectedIndex].isEmpty()){
				
				resources[selectedIndex].setResource(itemTaken.getResource());
				resources[selectedIndex].setAmount(itemTaken.getAmount());
				
				resources[indexTaken].setResource(null);
				resources[indexTaken].setAmount(0);
				resources[indexTaken].setTaken(false);
				
				itemTaken = null;
				indexTaken = -1;
				
			}else if(resources[selectedIndex].getResource().equals(itemTaken.getResource())){
				
				int rest = resources[selectedIndex].setAmountPrecise(itemTaken.getAmount());
				if(rest != 0){
					resources[indexTaken].setAmount(rest);
					return;
				}
				resources[indexTaken].setTaken(false);
				resources[indexTaken].setColor(0, 0, 0, 1);
				indexTaken = -1;
				
			}
			
		}
		
	}
	
	public void takeItem(){
		if(resources[selectedIndex].getResource() == null) return;
		resources[selectedIndex].setColor(0, 0, 1, 1);
		resources[selectedIndex].setTaken(true);
		itemTaken = resources[selectedIndex];
		indexTaken = selectedIndex;
	}
	
	public int getIndexTaken(){
		return indexTaken;
	}
	
	public void useItem(){
		try{
			
			Resource touse = getSelectedItem();
			if(touse instanceof Edible){
				int plus = getSelectedItemValue(touse.getName());
				player.increaseHunger(plus);
				resources[selectedIndex].setAmount(resources[selectedIndex].getAmount()-1);
			}else if(touse instanceof Potions){
				int plus = getSelectedItemValue(touse.getName());
				player.increaseHealth(plus);
				resources[selectedIndex].setAmount(resources[selectedIndex].getAmount()-1);
			}

		}catch(ArrayIndexOutOfBoundsException aioobe){
			System.out.println("OUT OF BOUNDS");
			return;
		}
		
		return;
	}
	
	public void addSelectedItemToCraft(){
		resources[selectedIndex].setAmount(resources[selectedIndex].getAmount()-1);
	}
	
	private int getSelectedItemValue(String name){
		switch(name){
			//for hunger
			case "Chips"		: 	return new Chips().restoreHungerBy();
			
			case "Apple"		: 	return new Apple().restoreHungerBy();
			
			case "Potato"		: 	return new Potato().restoreHungerBy();
			
			case "RedFlower"	: 	return new RedFlower().restoreHungerBy();
			
			case "YellowFlower"	: 	return new YellowFlower().restoreHungerBy();
			
			//for health
			case "HealthPotionSmall":	return new HealthPotionSmall().restoreHealthBy();
			
			case "HealthPotionBig"	:	return new HealthPotionBig().restoreHealthBy();
			
			//deafult
			default				: 	return 0;
		}
	}
	
	/**
	 * deletes certain type of resources and
	 * returns the amount which couldn't be deleted
	 * 		(5 wood and you want to delete 6, it returns 1)
	 * 
	 *
	 * checks if
	 * 		the input is valid
	 * 		the SLOT contains the resource
	 * 		and if the amount is greater or smaller than the amount in the SLOT
	 * 		
	 * 
	 * @param index
	 * @return
	 */

	public int dispose(Resource r, int amount) {
		
		if(r != null && amount > 0) {
			for(int i = 0; i < resources.length; i++) {
				if(resources[i].getResource() == r) {
					if(resources[i].getAmount() < amount) {
						amount -= resources[i].getAmount();
						resources[i].setAmount(0);
						resources[i].setResource(null);
					}
					else {
						resources[i].setAmount(resources[i].getAmount() - amount);
						amount = 0;
						return amount;
					}
				}
			}
		}
		return amount;//only if resource doesn't exist or invalid input
	}


	/**
	 * deletes all resources in a specified SLOT
	 * @param index
	 * @return
	 */
	public boolean clearSlot(int index) {
		if(!resources[index].isEmpty()) {
			resources[index].setResource(null);
			resources[index].setAmount(0);
			return true;
		}
		return false;
	}

	/**
	 * deletes all resources in the whole backpack
	 */
	public void clearBackpack() {
		for(int i = 0; i<resources.length; i++) {
			if(!resources[i].isEmpty()) {
				resources[i].setResource(null);
				resources[i].setAmount(0);
			}
		}
	}
	
	/**
	 * searches for the first empty space in the SLOT
	 */
	public boolean isEmpty(){
		for(int i=0; i<resources.length; i++){
			if(!resources[i].isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * responsible for changing the place [index] in the BAG
	 */
	public void setSelected(int plus){
		resources[selectedIndex].setColor(1, 1, 1, 1);
		int index = selectedIndex + plus;
		
		if(index >= resources.length){
			selectedIndex = resources.length-1;
		}else if(index < 0){
			selectedIndex = 0;
		}else{
			selectedIndex = index;
		}
		
		resources[selectedIndex].setColor(0.32f, 0.11f, 0.11f, 1);
	}
	
	public Resource getSelectedItem(){
		return resources[selectedIndex].getResource();
	}
	
	public int getSelectedIndex(){
		return this.selectedIndex;
	}

	public Slot[] getResources() {
		return resources;
	}
	
	public void setSize(int size){
		Slot[] copy = resources;
		clearBackpack();
		resources = new Slot[size];
		for(int i=0; i<resources.length; i++){
			resources[i] = new Slot();
			resources[i].setResource(copy[i].getResource());
			resources[i].setAmount(copy[i].getAmount());
		}
	}
	
	public String toString(){
		StringBuilder strb = new StringBuilder();
		for(int i=0; i<resources.length; i++){
			if(!resources[i].isEmpty()){
				strb.append(resources[i].getResource().toString());
			}
		}
		return strb.toString();
	}
	
	//------------------------------------------------- stuff for actor ---------------------------------------------------
	
	public void act(float delta){
		for(int i=0; i<resources.length; i++){
			if(resources[i].getResource() != null){
				resources[i].act(delta);
			}
		}
	}
	
	public void draw(Batch batch, float parentAlpha){
		for(int i=0; i<resources.length; i++){
			resources[i].draw(batch, parentAlpha);
		}
	}
	
	public void setPosition(float x, float y){
		super.setPosition(x, y);
		for(int i=0; i<resources.length; i++){
			resources[i].setPosition(x, y-20*i);
		}
	}
	
	
	
	
	
}
