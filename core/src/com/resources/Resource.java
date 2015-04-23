/**
 * 
 */
package com.resources;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.game.PlayScreen;

/**
 * @author michael
 * main class that is used to extend all resources themselves
 * 
 * resources are seperated into natural and craftable resources
 * 
 * natural: these resourcese can only be found in nature which means you can't craft them
 * craftable: you cannot find these resources in nature; they have to be crafted
 */
public abstract class Resource extends Actor implements Craftable{
	protected ArrayList<String> resourcesNeeded;
	private String name;
	private Label l_name;
	private int amount;

	public Resource(String name, int amount) {
		this.name=name;
		this.l_name = new Label(name, PlayScreen.skin);
		this.amount=amount;
		resourcesNeeded=new ArrayList<String>();
	}
	//TODO TODO TODO TODO TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! every time a new resource is created the position needs to be set TODO TODO TODO TODO
	/*
	 * get name of current resource
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * amount of items of the resource you are currently crafting
	 */
	public int getAmount() {
		return this.amount;
	}
	
	//----------------------------------- graphical stuff -------------------------------------------
	public void act(float delta){
		super.act(delta);
		l_name.act(delta);
	}
	
	public void draw(Batch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
	}
	
	public void setPosition(float x, float y){
		super.setPosition(x, y);
	}
	
	public void setColor(float r, float g, float b, float a){
		super.setColor(r, g, b, a);
	}
	//-----------------------------------------------------------------------------------------------
	
	// ---------------------------------- 0815 methods ----------------------------------------------
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
	
	public boolean equals(Object obj){
		Resource r = (Resource)obj;
		return this.getName().equals(r.getName()) ? true : false;
	}
	
}