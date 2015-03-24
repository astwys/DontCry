package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite{

	//character reference
	private Character character;
	
	//movement velocity
	private Vector2 velocity;
	
	//speed of the player
	private float speed = 60*2;
	
	//reference to the collisionlayer
	private TiledMapTileLayer collisionLayer;
	
	
	public Player(Sprite sprite, TiledMapTileLayer tiledMapLayer){
		super(sprite);
		velocity = new Vector2();
		collisionLayer = tiledMapLayer;
	}
	
	public void draw(SpriteBatch spriteBatch){
		update(Gdx.graphics.getDeltaTime());
		super.draw(spriteBatch);
	}
	
	public void update(float deltaTime){
		
		//collision detection
		//old positions
		float oldX = getX(), oldY = getY();
		//tile dimensions
		float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
		
	}
	
}
