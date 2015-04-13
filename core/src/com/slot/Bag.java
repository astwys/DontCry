package com.slot;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.resources.Resource;

/*
 * author jonas
 */

public class Bag extends Actor {

	private Slot[] resources;
	private int lastIndex; //last index that was filled (lastIndex++ -> next free slot)
	
	public Bag() {
		super();
		resources = new Slot[12];
		
		for(int i=0; i<resources.length; i++){
			resources[i] = new Slot();
		}
		
		lastIndex = -1;
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
		if(r != null && plus > 0) {
			
			if(lastIndex == -1){
				resources[lastIndex+1].setResource(r);
				resources[lastIndex+1].setAmount(plus);
				lastIndex++;
			}
			
			for(int i = 0; i < lastIndex || plus==0; i++) {
				if(resources[i].getResource() == r || resources[i].isEmpty()) {
					if(resources[i].resourcesToAdd() < plus) {
						plus -= resources[i].resourcesToAdd();
						resources[i].setAmount(resources[i].getSize());
					}
					else {
						plus = 0;
						resources[i].setAmount(resources[i].getAmount() + plus);
						lastIndex++;
					}
				}
			}
		}
		return plus;
	}
	
	/*
	 * 
	 */
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

	public Slot[] getResources() {
		return resources;
	}
	
	//------------------------------------------------- stuff for actor ---------------------------------------------------
	
	public void act(float delta){
		//TODO
	}
	
	public void draw(Batch batch, float parentAlpha){
		//TODO
	}
	
	public void setPosition(float x, float y){
		//TODO
	}
	
	public void setColor(float r, float g, float b, float a){
		//TODO
	}
	
	
	
	
	
}
