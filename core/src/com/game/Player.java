package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite{

	//movement velocity
	private Vector2 velocity;
	
	//speed of the player
	private float speed = 60*2;
	
	public Player(Sprite sprite){
		super(sprite);
		velocity = new Vector2();
	}
	
	public void draw(SpriteBatch spriteBatch){
		update(Gdx.graphics.getDeltaTime());
		super.draw(spriteBatch);
	}
	
	public void update(float deltaTime){
		velocity.y += 100*deltaTime;
		
//		if(velocity.x > speed) velocity.x = speed;
//		else if(velocity.y < -speed) velocity.x = -speed;
		
		setX(getX()+velocity.x*deltaTime);
		setY(getY()+velocity.y*deltaTime);
	}
	
}
