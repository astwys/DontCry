package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.character.Character;
import com.resources.craftable.GoldPlate;
import com.resources.craftable.edible.Chips;
import com.resources.craftable.tools.WoodAxe;
import com.resources.natural.minerals.Wood;

public class Player extends Sprite implements InputProcessor{

	private DontCry game;
	private PlayScreen screen;
	
	//character reference
	private Character character;
	
	//the collector to compute the items we collect
	private Collector collector;
	
	//movement velocity
	private Vector2 velocity;
	
	//speed of player when walking
	private float normalSpeed = 40*2;
	
	//speed of player when running
	private float runSpeed = 50*3;
	
	// current speed of the player
	private float speed = normalSpeed;
	
	//reference to the collisionlayer
	private TiledMapTileLayer collisionLayer;
	
	//important variables regarding the map for collision detection
	private float tileWidth = 20.8f, tileHeight = 20.8f;
	
	//the array of different textures
	private Texture[] skins = {Settings.playerBack, Settings.playerFront, Settings.playerRight, Settings.playerLeft};
	
	
	public Player(final DontCry dontcry, String name, PlayScreen playscreen, Sprite sprite, TiledMapTileLayer blocking){
		super(sprite);
		game = dontcry;
		collector = new Collector(this, blocking);
		screen = playscreen;
		velocity = new Vector2();
		collisionLayer = blocking;
		character = new Character(name);
		character.addResource(new Chips(), 10);
		character.addResource(new WoodAxe(), 1);
	}
	
	public void draw(SpriteBatch spriteBatch){
		update(Gdx.graphics.getDeltaTime());
		super.draw(spriteBatch);
	}
	
	
// -------------------------------------------------- graphical stuff (collision detection and stuff) -----------------------------------------------------------	
	public void update(float deltaTime){
		
		//collision detection
		//old positions
		float oldX = getX(), oldY = getY();
		
		//boolean collision
		boolean collisionX = false, collisionY = false;
		
		//moving on both axis
		setY(getY()+velocity.y*deltaTime);
		setX(getX()+velocity.x*deltaTime);
		
		//coordinates and data for position detection
		float x = getX();
		float y = getY();
		float width = getWidth();
		float height = getHeight();
		
		boolean forward = false, back = false, left = false, right = false; //used to define in which direction the way needs to be corrected
		boolean forwardP = true, backP = true, leftP = true, rightP = true; //used to define if the way can be corrected in the given direction 
		
		//when moving up
		if(velocity.y > 0){
			
			//top left
			if(collides(x, y+height/2)){
				right = true;
			}
			
			//top right
			if(collides(x+width, y+height/2)){
				left = true;
			}
			
			//top middle
			if(collides(x+width/2, y+height/2)){
				forwardP = false;
				right = false;
				left = false;
			}
			
			
		//when moving down
		}else if(velocity.y < 0){
			
			//bottom left
			if(collides(x, y)){
				right = true;
			}
			
			//bottom right
			if(collides(x+width, y)){
				left = true;
			}

			//bottom middle
			if(collides(x+width/2, y)){
				backP = false;
				right = false;
				left = false;
			}
			
		}
		
		
		//when moving right
		if(velocity.x > 0){
			
			//right bottom
			if(collides(x+width, y)){
				forward = true;
			}
			
			//right middle
			if(collides(x+width, y+height/2)){
				rightP = false;
				back = true;
				if(forward){
					forward = false;
					back = false;
				}
			}
			
			
		
		//when moving left
		}else if(velocity.x < 0){
			
			//left bottom
			if(collides(x, y)){
				forward = true;
			}
			
			//left middle
			if(collides(x, y+height/2)){
				leftP = false;
				back = true;
				if(forward){
					forward = false;
					back = false;
				}
			}	
			
		}
		
		//if player walks out of the screen
		//left
		if((x) <= 0){
			collisionX = true;
		}
		//right
		else if((x+width) >= 5325.75f*2){
			collisionX = true;
		}
		//bottom
		else if(y <= 0){
			collisionY = true;
		}
		//top
		else if((y+height) >= 5325.75f*2){
			collisionY = true;
		}
		
		//reaction to collision if the player walks out of the screen
		if(collisionY){
			setY(oldY);
			velocity.y = 0;
		}
		
		if(collisionX){
			setX(oldX);
			velocity.x = 0;
		}
		
		//way correction
		if(forward || back || right || left || !forwardP || !backP || !rightP || !leftP){
			float newX = oldX, newY = oldY;
		
			if(forward && forwardP){
				newY = oldY+0.5f;
			}
			
			if(back && backP){
				newY = oldY-0.5f;
			}
		
			if(left && leftP){
				newX = oldX-0.5f;
			}
		
			if(right && rightP){
				newX = oldX+0.5f;
			}
			
			setX(newX);
			setY(newY);
		}
		
	}
	
	private boolean collides(float x, float y){
		Cell cell = collisionLayer.getCell((int)(x/tileWidth),(int)(y/tileHeight));
		
		return cell == null ? false : true;
	}
	
	// ------------------------- some getters -------------------------------------
	public Character getCharacter(){
		return this.character;
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
		
		float x = getX();
		float y = getY();
		
		//moving
		if(keycode == Keys.W || keycode == Keys.UP){
			velocity.y = speed;
			set(new Sprite(skins[0]));
			setX(x);
			setY(y);
		}else if(keycode == Keys.S || keycode == Keys.DOWN){
			velocity.y = -speed;
			set(new Sprite(skins[1]));
			setX(x);
			setY(y);
		}else if(keycode == Keys.A || keycode == Keys.LEFT){
			velocity.x = -speed;
			set(new Sprite(skins[3]));
			setX(x);
			setY(y);
		}else if(keycode == Keys.D || keycode == Keys.RIGHT) {
			velocity.x = speed;
			set(new Sprite(skins[2]));
			setX(x);
			setY(y);
		}
		//running
		if(keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT){
			if (character.canRun()){
				speed = runSpeed;
				screen.setHungerIndicator(4.0f);
			}
		}
		//dump stuff
		if(keycode == Keys.Q){
			character.getBag().clearSlot(character.getBag().getSelectedIndex());
		}
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		if(keycode == Keys.SHIFT_LEFT){
			speed = normalSpeed;
			screen.setHungerIndicator(9.0f);
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
		
		if(keycode == Keys.TAB){
			craftingMode();
		}
		
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		
		if(character == ' '){
			boolean finish = collector.collect();
			if(collector.finishFound) screen.endGame(true);
		}		
		
		return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if(button == 0){ //left mouse button
			useItem();
			return true;
		}
		
		if(button == 1){ //right mouse button
			
			if(getCharacter().getBag().getIndexTaken() < 0){
				getCharacter().getBag().takeItem();
			}else if(getCharacter().getBag().getIndexTaken() >= 0){
				getCharacter().getBag().placeItem();
			}
			return true;
		}
		
		return true;
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
		
		character.getBag().setSelected(amount);
		
		return true;
	}
	
	//--------------------------------------- interacting methods for bag -----------------------------------------
	
	private void useItem(){
		character.getBag().useItem();
	}
	
	public void craftingMode(){
		game.setScreen(new CraftingScreen(this, screen, game));
	}

}
