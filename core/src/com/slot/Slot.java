package com.slot;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.game.Settings;
import com.resources.Resource;

/*
 * author jonas
 */

public class Slot extends Actor {

	//the type of resource in the SLOT
	private Resource resource;
	//the name of the resource
	private Label label;
	
	//amount = how much the SLOT contains
	private int amount;
	
	//is set to true if selected (via scrolling)
	private boolean selected;
	
	//used if the item is taken for replacing
	private boolean taken;
	
	//size = the max size of the SLOT
	public static int size = 32;
	
	
	/**
	 * default constructor
	 * 		sets the SIZE of the SLOT
	 * 		sets the type of RESOURCE
	 * 		sets the AMOUNT of resources
	 * @param r
	 * @param a
	 */
	public Slot(Resource r, int a) {
		super();
		setSize(Slot.size);
		setResource(r);
		setAmount(a);
		
		label = new Label(r.getName()+" x"+getAmount(), Settings.skin);
	}
	
	/**
	 * constructor without parameter
	 */
	public Slot(){
		super();
		label = new Label("- - -", Settings.skin);
	}

	/**
	 * checks if the SLOT is empty or not
	 * @return
	 */
	public boolean isEmpty() {
		if(getAmount()==0 || resource == null) {
			return true;
		}
		return false;
	}

	/**
	 * returns the size of the SLOT
	 * @return
	 */
	public int getSize() {
		return Slot.size;
	}

	/**
	 * sets the max size of the SLOT --> default value
	 * @param size
	 */
	public void setSize(int size) {
		Slot.size = size;
	}
	
	/**
	 * returns how much resources are in the SLOT
	 * @return
	 */
	public int getAmount() {
		return this.amount;
	}

	/**
	 * sets the amount of the resource in the SLOT precisely
	 * @param amount
	 */
	public int setAmountPrecise(int amount) {
		if(amount <= 0){
			resource = null;
			label.setText("- - -");
			return 0;
		}else if(getAmount()+amount > 32){
			amount -= resourcesToAdd();
			this.amount = 32;
			label.setText(getResource().getName()+" x"+getAmount());
			return amount;
		}
		this.amount = amount;
		label.setText(getResource().getName()+" x"+getAmount());
		return 0;
	}
	
	/**
	 * sets the amount of the resource in the SLOT
	 */
	public void setAmount(int amount){
		if(amount <= 0){
			resource = null;
			label.setText("- - -");
			return;
		}
		this.amount = amount;
		label.setText(getResource().getName()+" x"+getAmount());
		return;
	}
	
	/**
	 * 
	 * @return true if selected, false if not
	 */
	public boolean isSelected(){
		return this.selected;
	}
	
	/**
	 * 
	 * @param b sets if it is selected
	 */
	public void setSelected(boolean b){
		this.selected = b;
	}

	/**
	 * returns how much resource you can add to the SLOT
	 * @return
	 */
	public int resourcesToAdd() {
		return getSize()-getAmount();
		//return this.size-this.amount;
	}

	/**
	 * returns the type of the resource
	 * @return
	 */
	public Resource getResource() {
		return this.resource;
	}

	/**
	 * sets the type of resource
	 * @param r
	 */
	public void setResource(Resource r) {
		this.resource = r;
		if(this.resource == null){
			label.setText("- - -");
			return;
		}
		label.setText(r.getName()+" x"+getAmount());
	}
	
	/**
	 * 
	 * @returns the text-label
	 */
	public Label getLabel(){
		return this.label;
	}
	
	public void setTaken(boolean taken){
		this.taken = taken;
		
		if(taken){
			label.setColor(0, 0, 1, 1);
		}else{
			label.setColor(0, 0, 0, 1);
		}
		
	}
	
	/**
	 * 
	 * @returns true if it is taken, false if not
	 */
	public boolean isTaken(){
		return this.taken;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Slot [resource=" + this.resource + ", amount=" + this.amount + "size=" + Slot.size +"]";
	}
	
	// --------------------------------------- graphical stuff -------------------------------------------

	public void act(float delta){
		super.act(delta);
		label.act(delta);
	}
	
	public void draw(Batch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
		label.draw(batch, parentAlpha);
	}
	
	public void setPosition(float x, float y){
		super.setPosition(x, y);
		label.setPosition(x, y);
	}
	
	public void setColor(float r, float g, float b, float a){
		if(taken) return;
		super.setColor(r, g, b, a);
		label.setColor(r, g, b, a);
	}
	//-----------------------------------------------------------------------------------------------
	
	
}
