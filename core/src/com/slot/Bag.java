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

	private Slot[] resources;
	private int lastIndex; //last index that was filled (lastIndex++ -> next free slot) //TODO needs to be changed ... my bad
	private int selectedIndex = 0;
	
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
			//TODO write a equals
			for(int i = 0; i < resources.length && plus > 0; i++) {
				if(resources[i].getResource().equals(r) || resources[i].isEmpty()) {
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
					System.out.println(touse.toString()+" - Edible");
				}else if(touse instanceof Potions){
					System.out.println(touse.toString()+" - Potion");
				}
			}else{
				System.out.println(touse.toString()+" - Tool");
			}
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
	
	//------------------------------------------------- stuff for actor ---------------------------------------------------
	
	public void act(float delta){
		for(int i=0; i<lastIndex; i++){
			resources[i].act(delta);
		}
	}
	
	public void draw(Batch batch, float parentAlpha){
		for(int i=0; i<resources.length; i++){
			if(resources[i].getResource() != null){
				resources[i].draw(batch, parentAlpha);
			}
		}
	}
	
	public void setPosition(float x, float y){
		super.setPosition(x, y);
		for(int i=0; i<resources.length; i++){
			if(resources[i].getResource() != null){
				resources[i].setPosition(x, y+15*i);
			}
		}
	}
	
	public void setColor(float r, float g, float b, float a){
		//TODO
	}
	
	
	
	
	
}
