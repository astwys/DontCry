/**
 * 
 */
package com.character;

import java.util.ArrayList;

import com.craft.Craftingbook;
import com.craft.Craftingbook.ReturnForCraft;
import com.resources.Resource;
import com.slot.Bag;

/**
 * @author michael
 *
 */
public class Character {
	private String name;
	
		// default starting values
	private int hunger=100;
	private int health=100;
		// only makes sense as soon as enemies/bots are implemented
	private int strength=3;

	private Bag bag;
	private Craftingbook craftingbook;
	
	
//---------------------------------------------------Constructor---------------------------------------------------
	/**
	 * set the desired name of the character and create new Bag & Craftingbook objects
	 * @param name
	 */
	public Character(String name) {
		setName(name);

		bag=new Bag(this);
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
	 * @return hunger
	 */
	public int decreaseHungerDef() {
		setHunger(getHunger() - 1);
		return getHunger();
	}
	
	/**
	 * reduction of hunger by a certain number
	 * @param dec (decrement)
	 * @return hunger
	 */
	public int decreaseHunger (int dec) {
		setHunger(getHunger() - dec);
		return getHunger();
	}
	
	/**
	 * increase hunger by a certain number
	 * @param inc (increment)
	 * @return hunger
	 */
	public int increaseHunger (int inc) {
		setHunger(getHunger() + inc);
		return getHunger();
	}
	
	
//---------------------------------------------------Health---------------------------------------------------
	
	/**
	 * default reduction of health by 1 of hunger is at 0
	 * @return health
	 */
	public int decreaseHealthDef() {
		setHealth(getHealth() - 1);
		return getHealth();
	} 
	
	/**
	 * reduction of health by a certain number
	 * @param dec (decrement)
	 * @return health
	 */
	public int decreaseHealth (int dec) {
		setHealth(getHealth() - dec);
		return getHealth();
	}
	
	/**
	 * increase health by a certain number
	 * @param inc (increment)
	 * @return health
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
	 * @return if the character is able to run
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
		int remainder = bag.add(r, plus);
		if(remainder > 0) return false;
		return true;
	}
	
	
//---------------------------------------------------Getters/Setters---------------------------------------------------
	
//-------------------------------Name-------------------------------
	/**
	 * @return the name of the character
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param set the name of the character
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
	 * has to be between 100 (no hunger) and 0 (full hunger --> health gets decreased)
	 * @param set the hunger of the character
	 */
	public void setHunger(int hunger) {
		if (hunger>=0 && hunger <= 100) {
			this.hunger = hunger;
		}else if(hunger > 100){
			this.hunger = 100;
		}else {
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
	 * @param set the health of the character
	 */
	public void setHealth(int health) {
		if (health >= 0 && health <= 100) {
			this.health = health;
		}else if(health > 100){
			this.health = 100;
		}else{
			// method to "die" / restart the game if health = 0
			this.health = 0;
		}
	}


//-------------------------------Strength-------------------------------

	/**
	 * get the strength of the character
	 * @return strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * set the strength of the character
	 * @param strength
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
//---------------------------- Bag ------------------------------------
	/**
	 * 
	 * @return this.bag
	 */
	public Bag getBag(){
		return this.bag;
	}

	/**
	 * 
	 * @param bag
	 * @return boolean
	 */
	public boolean setBag(Bag bag){
		if(bag != null){
			return false;
		}else{
			this.bag = bag;
			return true;
		}
	}
	
//------------------------- CraftingBook ----------------------------
	/**
	 * 
	 * @param from
	 * @return craftable resource
	 */
	public String craftsInto(ArrayList<String> from){
		ReturnForCraft rfc = craftingbook.craft(from);
		if(rfc != null) return rfc.getResource().toString();
		else return "Nothing :(";
	}
	
	/**
	 * 
	 * @return this.craftingbook
	 */
	public Craftingbook getCraftingBook(){
		return this.craftingbook;
	}
}
