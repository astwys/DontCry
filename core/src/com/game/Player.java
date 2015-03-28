package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.character.Character;

public class Player extends Sprite implements InputProcessor{

	//character reference
	private Character character;
	
	//movement velocity
	private Vector2 velocity;
	
	//spped of player when walking
	private float normalSpeed = 60*2;
	
	//speed of player when running
	private float runSpeed = 60*3;
	
	// current speed of the player
		private float speed = normalSpeed;
	
	//reference to the collisionlayer
	private TiledMapTileLayer collisionLayer;
	
	
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
		//tile dimensions
		float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
		//boolean collision
		boolean collisionX = false, collisionY = false;
		
		//moving on both axis
		setY(getY()+velocity.y*deltaTime);
		setX(getX()+velocity.x*deltaTime);
		
		//when moving up
		//Cell for checking if a "blocking" tile is in our way
		Cell cell;
		if(velocity.y > 0){
			
			//top left
			cell = collisionLayer.getCell((int)(getX() / tileWidth),(int)((getY()+getHeight()) / tileHeight));
			collisionY = checkForCollision(cell);
			
			if(!collisionY){
				//top middle
				cell = collisionLayer.getCell((int)((getX()+getWidth() / 2) / tileWidth),(int)((getY()+getHeight()) / tileHeight));
				collisionY = checkForCollision(cell);
			}
			
			if(!collisionY){
			//top right
				cell = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth),(int)((getY()+getHeight()) / tileHeight));
				collisionY = checkForCollision(cell);
			}
			
		//when moving down
		}else if(velocity.y < 0){
			//bottom left
			cell = collisionLayer.getCell((int)(getX() / tileWidth),(int)(getY() / tileHeight));
			collisionY = checkForCollision(cell);
			
			if(!collisionY){
			//bottom middle
				cell = collisionLayer.getCell((int)((getX()+getWidth() / 2) / tileWidth),(int)(getY() / tileHeight));
				collisionY = checkForCollision(cell);
			}
			
			if(!collisionY){
			//bottom right
				cell = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth),(int)(getY() / tileHeight));
				collisionY = checkForCollision(cell);
			}
		}
		
		
		//when moving right
		if(velocity.x > 0){
			//right top
			
			
			if(!collisionX){
				//right middle
				
			}
			//right bottom
			if(!collisionX){
				
			}
		
		//when moving left
		}else if(velocity.x < 0){
			//left top
			
			if(!collisionX){
			//left middle
				
			}
			
			if(!collisionX){
			//right bottom	
				
			}
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
	
	private boolean checkForCollision(Cell cell){
		if(cell == null){
			return false;
		}else{
			return true;
		}
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
		}else if(keycode == Keys.D || keycode == Keys.RIGHT){
			velocity.x = speed;
		}else if(keycode == Keys.SHIFT_LEFT)
			speed = runSpeed;
		
		if(keycode == Keys.SPACE){
			//method for collecting
		}
		
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		if(keycode == Keys.W || keycode == Keys.UP){
			velocity.y = 0;
		}else if(keycode == Keys.S || keycode == Keys.DOWN){
			velocity.y = 0;
		}else if(keycode == Keys.A || keycode == Keys.LEFT){
			velocity.x = 0;
		}else if(keycode == Keys.D || keycode == Keys.RIGHT){
			velocity.x = 0;
		}else if(keycode == Keys.SHIFT_LEFT)
			speed = normalSpeed;
		
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//-------------------------------------------- Miscellaneous -----------------------------------
	
	
	//another method for collision detection --> not working with this settings but if we change something it might get usefull and i am to lazy to write it again	
//	if(velocity.y > 0){
//		//top left
//		collisionY = collisionLayer.getCell((int)(getX() / tileWidth),(int)((getY()+getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
//		
//		if(!collisionY){
//		//top middle
//			collisionY = collisionLayer.getCell((int)((getX()+getWidth() / 2) / tileWidth),(int)((getY()+getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
//		}
//		
//		if(!collisionY){
//		//top right
//			collisionY = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth),(int)((getY()+getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
//		}
//		
//	}else if(velocity.y < 0){
//		//bottom left
//		collisionY = collisionLayer.getCell((int)(getX() / tileWidth),(int)(getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
//		
//		if(!collisionY){
//		//bottom middle
//			collisionY = collisionLayer.getCell((int)((getX()+getWidth() / 2) / tileWidth),(int)(getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
//		}
//		
//		if(!collisionY){
//		//bottom right
//			collisionY = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth),(int)(getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
//		}
//	}
//	
//	
//	
//	if(velocity.x > 0){
//		//right top
//		
//		//right middle
//		
//		//right bottom
//		
//	}else if(velocity.x < 0){
//		//left top
//		
//		//left middle
//		
//		//left bottom
//		
//	}
}
