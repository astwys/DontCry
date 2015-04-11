/**
 * 
 */
package com.character;

import com.craft.Craftingbook;
import com.resources.Resource;
import com.slot.Bag;
import com.sun.xml.internal.bind.v2.TODO;

/**
 * @author michael
 *
 */
public class Character {
	private String name;

	/**
	 * default starting values
	 */
	private int hunger=100;
	private int health=100;
	private int strength=3;

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
		setHunger(getHunger() - 1);
		return getHunger();
	}
	
	/**
	 * reduction of hunger by a certain number
	 * @param dec (decrement)
	 * @return
	 */
	public int decreaseHunger (int dec) {
		setHunger(getHunger() - dec);
		return getHunger();
	}
	
	/**
	 * increase hunger by a certain number
	 * @param inc (increment)
	 * @return
	 */
	public int increaseHunger (int inc) {
		setHunger(getHunger() + inc);
		return getHealth();
	}
	
	
//---------------------------------------------------Health---------------------------------------------------
	
	/**
	 * default reduction of health by 1 of hunger is at 0
	 * @return
	 */
	public int decreaseHealthDef() {
		setHealth(getHealth() - 1);
		return getHealth();
	} 
	
	/**
	 * reduction of health by a certain number
	 * @param dec (decrement)
	 * @return
	 */
	public int decreaseHealth (int dec) {
		setHealth(getHealth() - dec);
		return getHealth();
	}
	
	/**
	 * increase health by a certain number
	 * @param inc (increment)
	 * @return
	 */
	public int increaseHealth (int inc) {
		setHealth(getHealth() + inc);
		return getHealth();
	}


//---------------------------------------------------Methods---------------------------------------------------

	/**
	 * @return Bag with all the resources stored in it
	 */
	public Bag showInventory() {
		return bag;
	}

	/**
	 * the character is only able to run if his hunger is >= 30
	 * @return
	 */
	public boolean canRun() {
		return (getHunger() >= 30);
	}

	/**
	 * only returns true if a minimum of one of the specified resource could be added
	 * returns false if not
	 * @param r
	 * @param plus
	 * @return if a resource with a specified amount could be added
	 */
	public boolean addResource(Resource r, int plus) {
		if (bag.add(r, plus) < plus) {
			bag.add(r, plus);
			return true;
		}
		return false;
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
		if (hunger<=100 && hunger>=0) {
			this.hunger = hunger;
		}
		else {
			decreaseHealthDef();
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
		if (health <= 100 && health >= 0) {
			this.health = health;
		}
		else {
			// method to "die" / restart the game if health = 0
		}
	}


//-------------------------------Strength-------------------------------

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
}
