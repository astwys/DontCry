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
		//boolean collision
		boolean collisionX = false, collisionY = false;
		
		//moving on both axis
		setY(getY()+velocity.y*deltaTime);
		setX(getX()+velocity.x*deltaTime);
		
		
		
		if(velocity.y > 0){
			//top left
			collisionY = collisionLayer.getCell((int)(getX() / tileWidth),(int)((getY()+getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			if(!collisionY){
			//top middle
				collisionY = collisionLayer.getCell((int)((getX()+getWidth() / 2) / tileWidth),(int)((getY()+getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			}
			
			if(!collisionY){
			//top right
				collisionY = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth),(int)((getY()+getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			}
			
		}else if(velocity.y < 0){
			//bottom left
			collisionY = collisionLayer.getCell((int)(getX() / tileWidth),(int)(getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			if(!collisionY){
			//bottom middle
				collisionY = collisionLayer.getCell((int)((getX()+getWidth() / 2) / tileWidth),(int)(getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
			}
			
			if(!collisionY){
			//bottom right
				collisionY = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth),(int)(getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
			}
		}
		
		
		
		if(velocity.x > 0){
			//right top
			
			//right middle
			
			//right bottom
			
		}else if(velocity.x < 0){
			//left top
			
			//left middle
			
			//left bottom
			
		}
		
		
		//reaction to collision
		if(collisionY){
			setY(oldY);
			velocity.y = 0;
		}
		
		if(collisionX){
			setX(oldX);
			velocity.x = 0;
		}
	}
	
	public TiledMapTileLayer getCollisionLayer(){
		return collisionLayer;
	}
	
}
