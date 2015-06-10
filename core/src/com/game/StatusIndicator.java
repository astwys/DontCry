package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class StatusIndicator extends Actor {
	
	//the player the status referes to
	private Player player;
	private boolean hunger; //defines if the status is used for hunger (true) or health (false)
	
	//Labels
	private Label indicator;
	private int currentAmount;
	private int maxAmount;
	
	//images of full and half indicators
	private Image[] full = new Image[10];
	private Image half;
	
	public StatusIndicator(Player p, boolean hunger, int currentAmount, int maxAmount, Skin skin, Texture fullImage, Texture halfImage){
		indicator = new Label(currentAmount+"/"+maxAmount, skin);
		player = p;
		this.hunger = hunger;
		this.currentAmount = currentAmount;
		this.maxAmount = maxAmount;
		
		//initialise the texture
		Texture image = fullImage;
		int x = 10;
		int y = 530;
		for(int i=0; i<full.length; i++){
			full[i] = new Image(image);
			full[i].setPosition(x, y);
			x += 40;
		}
		
		image = halfImage;
		half = new Image(image);
		
	}
	
	/**
	 * update the indicators
	 */
	public void act(float delta){
		if(hunger) currentAmount = player.getCharacter().getHunger();
		else currentAmount = player.getCharacter().getHealth();
		
		super.act(delta);
		indicator.act(delta);
		
		for(int i=0; i<currentAmount/10; i++){
			full[i].act(delta); 
		}
		
		if(currentAmount%10 != 0){
			half.setPosition(((currentAmount/10)*40)+getX(), getY());
			half.act(delta);
		}

	}
	
	/**
	 * draw the indicators according to the current amount
	 */
	public void draw(Batch batch, float parentAlpha){
		if(hunger) currentAmount = player.getCharacter().getHunger();
		else currentAmount = player.getCharacter().getHealth();
		
		indicator.setText(currentAmount+"/"+maxAmount);
		
		super.draw(batch, parentAlpha);
		indicator.draw(batch, parentAlpha);
		
		for(int i=0; i<currentAmount/10; i++){
			full[i].draw(batch, parentAlpha);
		}
		
		if(currentAmount%10 != 0){
			half.draw(batch, parentAlpha);
		}

	}
	
	public void setPosition(float x, float y){
		super.setPosition(x, y);
		indicator.setPosition(x, y+35);
		
		for(int i=0; i<full.length; i++){
			full[i].setPosition(x+i*40, y);
		}
		
	}
	
	public void setColor(float r, float g, float b, float a){
		indicator.setColor(r, g, b, a);
	}
	
	/**
	 * following methods are used to modify the indicators amount predefined, by a specific amount or totally new 
	 * @return
	 */
	
	public int decreaseByOne(){
		indicator.setText((currentAmount-1)+"/"+maxAmount);
		currentAmount--;
		return currentAmount;
	}
	
	public int increaseByOne(){
		indicator.setText((currentAmount+1)+"/"+maxAmount);
		currentAmount++;
		return currentAmount;
	}
	
	public int decrease(int amount){
		indicator.setText((currentAmount-amount)+"/"+maxAmount);
		currentAmount-=amount;
		return currentAmount;
	}
	
	public int increase(int amount){
		indicator.setText((currentAmount+amount)+"/"+maxAmount);
		currentAmount+=amount;
		return currentAmount;
	}
	
	public void setStatus(int currentAmount){
		this.currentAmount = currentAmount;
		indicator.setText(this.currentAmount+"/"+maxAmount);
		
	}
	
}
