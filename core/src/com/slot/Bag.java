package com.slot;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.resources.Edible;
import com.resources.Potions;
import com.resources.Resource;
import com.resources.Tool;

/*
 * author jonas
 */

public class Bag extends Actor {

	private com.character.Character player; //the player the bag referes to
	private Slot[] resources;
	private int selectedIndex = 0;
	
	public Bag(com.character.Character character) {
		super();
		resources = new Slot[12];
		player = character;
		for(int i=0; i<resources.length; i++){
			resources[i] = new Slot();
		}
		
		setPosition(730, 550);
		setSelected(0);
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
				}else if(resources[i].getResource().equals(r)){
					if(resources[i].resourcesToAdd() < plus) {
						plus -= resources[i].resourcesToAdd();
						resources[i].setAmount(resources[i].getSize());
					}else {
						plus = 0;
						resources[i].setAmount(resources[i].getAmount() + plus);
					}
				}
			}
		}
		return plus;
	}
	
	public void useItem(){
		try{
			Resource touse = resources[selectedIndex].getResource();
			if(!(resources[selectedIndex].getResource() instanceof Tool)){
				if(touse instanceof Edible){
					Edible e = (Edible)touse;
					player.increaseHunger(e.restoreHungerBy());
				}else if(touse instanceof Potions){
					Potions p = (Potions)touse;
					player.increaseHealth(p.restoreHealthBy());
				}
			}else{
				//TODO a tool can increase the amount of resources u get from farming, ... whatever --> number is not decreased
				return;
			}
			resources[selectedIndex].setAmount(resources[selectedIndex].getAmount()-1);
		}catch(ArrayIndexOutOfBoundsException aioobe){
			System.out.println("OUT OF BOUNDS");
			return;
		}
		
		return;
	}
	
	/**
	 * deletes certain type of resources and
	 * returns the amount which couldn't be deleted
	 * 		(5 wood and you want to delete 6, it return 1)
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

	public Slot[] getResources() {
		return resources;
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
	
	public void setColor(float r, float g, float b, float a){
		//TODO
	}
	
	
	
	
	
}
