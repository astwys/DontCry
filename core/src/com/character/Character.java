/**
 * 
 */
package com.character;

import com.craft.Craftingbook;
import com.slot.Bag;
import com.sun.xml.internal.bind.v2.TODO;

/**
 * @author michael
 *
 */
public class Character {
	private String name;
	private int hunger = 100, health = 100; //default starting values
	
	private Bag bag;
	private Craftingbook craftingbook;
	
	
//---------------------------------------------------Constructor---------------------------------------------------

	public Character(String name) {
		setName(name);
		bag=new Bag();
		craftingbook=new Craftingbook();
	}
	
	
//---------------------------------------------------Hunger---------------------------------------------------
/**
 * hunger is inverted:
 * 	decreaseHunger: character has more hunger
 * 	increaseHunger: character has less hunger 
 */
	
	/**
	 * default reduction of hunger by 1
	 * @return 
	 */
	public int decreaseHungerDef() {
		setHunger(getHunger()-1);
		return getHunger();
	}
	
	/**
	 * reduction of hunger by a certain number
	 * @param dec (decrement)
	 * @return
	 */
	public int decreaseHunger (int dec) {
		setHunger(getHunger()-dec);
		return getHunger();
	}
	
	/**
	 * increase hunger by a certain number
	 * @param inc (increment)
	 * @return
	 */
	public int increaseHunger (int inc) {
		setHunger(getHunger()+inc);
		return getHealth();
	}
	
	
//---------------------------------------------------Health---------------------------------------------------
	
	/**
	 * default reduction of health by 1 of hunger is at 0
	 * @return
	 */
	public int decreaseHealthDef() {
		setHealth(getHealth()-1);
		return getHealth();
	} 
	
	/**
	 * reduction of health by a certain number
	 * @param dec (decrement)
	 * @return
	 */
	public int decreaseHealth (int dec) {
		setHealth(getHealth()-dec);
		return getHealth();
	}
	
	/**
	 * increase health by a certain number
	 * @param inc (increment)
	 * @return
	 */
	public int increaseHealth (int inc) {
		setHealth(getHealth()+inc);
		return getHealth();
	}
	
	
//---------------------------------------------------Getters/Setters---------------------------------------------------
	
//-------------------------------Name-------------------------------
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

	
//-------------------------------Hunger-------------------------------
	/**
	 * has to be between 100 (no hunger) and 1 (at 0 you loose live points)
	 * @return the hunger
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * @param hunger the hunger to set
	 */
	public void setHunger(int hunger) {
		if (hunger<=100 && hunger>0) {
			
			// if the new hunger value is > 100 set hunger to 100 and discard everything else 
			if (getHunger()+hunger >= 100) {
				this.health=100;
			}
			else {
				this.hunger = hunger;
			}
		}
		else {
			// method to decrease life if hunger = 0
		}
	}
	
	
//-------------------------------Health-------------------------------
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * has to be between 100 (full health) and 1 (at 0 you die)
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		if (health <= 100 && health > 0) {
			
			// if the new health value is > 100 set health to 100 and discard everything else
			if (getHealth()+health >= 100) {
				this.health=100;
			}
			else {
				this.health = health;
			}
		}
		else {
			// method to "die" / restart the game if health = 0
		}
	}
}
