/**
 * 
 */
package com.character;

import com.craft.Craftingbook;
import com.slot.Bag;

/**
 * @author michael
 *
 */
public class Character {
	private String name;
	private int hunger = 100, health = 100;
	
	private Bag bag;
	private Craftingbook craftingbook;
	
	/**
	 * 
	 */
	public Character(String name) {
		setName(name);
		bag=new Bag();
		craftingbook=new Craftingbook();
	}
	
	public int decreaseHunger() {
		setHunger(getHunger()-1);
		return getHunger();
	}
	
	public int decreaseHealth() {
		setHealth(getHealth()-1);
		return getHealth();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the hunger
	 * 
	 * has to be between 100 (no hunger) and 1 (at 0 you loose live points)
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * @param hunger the hunger to set
	 */
	public void setHunger(int hunger) {
		if (hunger<=100 && hunger>0) {
			this.hunger = hunger;
		}
		else {
			// method to decrease life
		}
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * @param health the health to set
	 * 
	 * has to be between 100 (full health) and 1 (at 0 you die)
	 */
	public void setHealth(int health) {
		if (health <=100 && health>0) {
			this.health = health;
		}
		else {
			// method to "die" / restart the game
		}
	}
}
