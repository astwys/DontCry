package com.game;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class StatusIndicator extends Label {
	
	private int currentAmount;
	private int maxAmount;
	
	public StatusIndicator(int currentAmount, int maxAmount, Skin skin){
		super(currentAmount+"/"+maxAmount, skin);
		this.currentAmount = currentAmount;
		this.maxAmount = maxAmount;
	}
	
	public int decreaseByOne(){
		setText((currentAmount-1)+"/"+maxAmount);
		return currentAmount--;
	}
	
	public int increaseByOne(){
		setText((currentAmount+1)+"/"+maxAmount);
		return currentAmount++;
	}
	
	public int decrease(int amount){
		setText((currentAmount-amount)+"/"+maxAmount);
		return currentAmount-=amount;
	}
	
	public int increase(int amount){
		setText((currentAmount+amount)+"/"+maxAmount);
		return currentAmount+=amount;
	}
	
	public void setStatus(int currentAmount){
		setText(currentAmount+"/"+maxAmount);
		
	}
	
}
