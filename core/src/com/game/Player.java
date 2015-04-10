package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.character.Character;

public class Player extends Sprite implements InputProcessor{

	//character reference
	private Character character;
	
	//movement velocity
	private Vector2 velocity;
	
	//speed of player when walking
	private float normalSpeed = 60*2;
	
	//speed of player when running
	private float runSpeed = 60*3;
	
	// current speed of the player
	private float speed = normalSpeed;
	
	//reference to the collisionlayer
	private TiledMapTileLayer collisionLayer;
	
	//important variables regarding the map for collision detection
	private int mapWidth = 256, mapHeight = 256;
	private float tileWidth = 20.8f, tileHeight = 20.8f;
	
	
	public Player(Sprite sprite, TiledMapTileLayer tiledMapLayer){
		super(sprite);
		velocity = new Vector2();
		collisionLayer = tiledMapLayer;
		character = new Character("Frank");
	}
	
	public void draw(SpriteBatch spriteBatch){
		update(Gdx.graphics.getDeltaTime());
		super.draw(spriteBatch);
	}
	
	public void update(float deltaTime){
		
		//collision detection
		//old positions
		float oldX = getX(), oldY = getY();
		
		//boolean collision
		boolean collisionX = false, collisionY = false;
		
		//moving on both axis
		setY(getY()+velocity.y*deltaTime);
		setX(getX()+velocity.x*deltaTime);
		
		//when moving up
		//Cell for checking if a "blocking" tile is in our way
		Cell cell;
		
		if(velocity.y >= 0){
			
			//top left
			collisionY = collides(getX(), getY()+getHeight());
			
			
			if(!collisionY){
			//top right
				collisionY = collides(getX()+getWidth(), getY()+getHeight());
			}
			
		//when moving down
		}else if(velocity.y < 0){
			//bottom left
			collisionY = collides(getX(), getY());
			
			if(!collisionY){
			//bottom right
				collisionY = collides(getX()+getWidth(), getY());
			}
		}
		
		
		//when moving right
		if(velocity.x > 0){
			//right top
			collisionX = collides(getX()+getWidth(), getY()+getHeight());
			
			//right bottom
			if(!collisionX){
				collisionX = collides(getX()+getWidth(), getY());
			}
		
		//when moving left
		}else if(velocity.x < 0){
			//left top
			collisionX = collides(getX(), getY()+getHeight());
			
			if(!collisionX){
			//left bottom	
				collisionX = collides(getX(), getY());
			}
		}
		
		//if player walks out of the screen
		//left
		if((getX()) <= 0){
			collisionX = true;
		}
		//right
		else if((getX()+getWidth()) >= 5325.75f){
			collisionX = true;
		}
		//bottom
		else if(getY() <= 0){
			collisionY = true;
		}
		//top
		else if((getY()+getHeight()) >= 5325.75f){
			collisionY = true;
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
	
	private int transformHeight(float coordinate){
		return (mapHeight - (int)coordinate);
	}
	
	private boolean collides(float x, float y){
		Cell cell;
		
		cell = collisionLayer.getCell((int)(x/tileWidth),(int)(y/tileHeight));
		
		return cell == null ? false : true;
	}
	
	public TiledMapTileLayer getCollisionLayer(){
		return collisionLayer;
	}
	
	public String getName(){
		return character.getName();
	}

	
	//---------------------------------------- for InputProcessor -----------------------------------------
	@Override
	public boolean keyDown(int keycode) {
		
		if(keycode == Keys.W || keycode == Keys.UP){
			velocity.y = speed;
		}else if(keycode == Keys.S || keycode == Keys.DOWN){
			velocity.y = -speed;
		}else if(keycode == Keys.A || keycode == Keys.LEFT){
			velocity.x = -speed;
		}else if(keycode == Keys.D || keycode == Keys.RIGHT) {
			velocity.x = speed;
		}
		
		if(keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT){
			if (character.canRun())
				speed = speed*5;
		}

		if(keycode == Keys.SPACE){
			//method for collecting
		}

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		if(keycode == Keys.SHIFT_LEFT){
			speed = normalSpeed;
		}
		
		if(keycode == Keys.W || keycode == Keys.UP){
			velocity.y = 0;
		}else if(keycode == Keys.S || keycode == Keys.DOWN){
			velocity.y = 0;
		}else if(keycode == Keys.A || keycode == Keys.LEFT){
			velocity.x = 0;
		}else if(keycode == Keys.D || keycode == Keys.RIGHT){
			velocity.x = 0;
		}
		
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		
		if(character == ' '){
			collectStuff();
		}
		
		return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {

		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {

		return false;
	}

	@Override
	public boolean scrolled(int amount) {

		return false;
	}
	
	public void collectStuff(){
		
	}

}