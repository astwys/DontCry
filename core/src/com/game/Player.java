package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.character.Character;
import com.resources.Edible;
import com.resources.Potions;
import com.resources.Resource;
import com.resources.craftable.edible.Chips;
import com.resources.craftable.tools.WoodAxe;

public class Player extends Sprite implements InputProcessor{

	private DontCry game;
	private PlayScreen screen;
	
	//character reference
	private Character character;
	
	//movement velocity
	private Vector2 velocity;
	
	//speed of player when walking
	private float normalSpeed = 60*2;
	
	//speed of player when running
	private float runSpeed = 60*4;
	
	// current speed of the player
	private float speed = normalSpeed;
	
	//reference to the collisionlayer
	private TiledMapTileLayer collisionLayer;
	
	//important variables regarding the map for collision detection
	private int mapWidth = 256, mapHeight = 256;
	private float tileWidth = 20.8f, tileHeight = 20.8f;
	
	//the array of different textures
	private Texture[] skins = {new Texture(new FileHandle("../core/assets/player/p_back.png")), new Texture(new FileHandle("../core/assets/player/p_front.png")), new Texture(new FileHandle("../core/assets/player/p_right.png")), new Texture(new FileHandle("../core/assets/player/p_left.png"))};
	
	
	public Player(final DontCry dontcry, PlayScreen playscreen, Sprite sprite, TiledMapTileLayer tiledMapLayer){
		super(sprite);
		game = dontcry;
		screen = playscreen;
		velocity = new Vector2();
		collisionLayer = tiledMapLayer;
		character = new Character("Frank");
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
		
		//when moving up
		//Cell for checking if a "blocking" tile is in our way
		Cell cell;
		
		if(velocity.y >= 0){
			
			//top left
			collisionY = collides(getX(), getY()+getHeight()/2);
			
			if(!collisionY){
				//top middle
				collisionY = collides(getX()+getWidth()/2, getY()+getHeight()/2);
			}
			
			if(!collisionY){
			//top right
				collisionY = collides(getX()+getWidth(), getY()+getHeight()/2);
			}
			
		//when moving down
		}else if(velocity.y < 0){
			//bottom left
			collisionY = collides(getX(), getY());
			
			if(!collisionY){
				//bottom middle
				collisionY = collides(getX()+getWidth()/2, getY());
			}
			
			if(!collisionY){
				//bottom right
				collisionY = collides(getX()+getWidth(), getY());
			}
		}
		
		
		//when moving right
		if(velocity.x > 0){
			//right top
			collisionX = collides(getX()+getWidth(), getY()+getHeight()/2);
			
			//right bottom
			if(!collisionX){
				collisionX = collides(getX()+getWidth(), getY());
			}
		
		//when moving left
		}else if(velocity.x < 0){
			//left top
			collisionX = collides(getX(), getY()+getHeight()/2);
			
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
	
	private boolean collides(float x, float y){
		Cell cell;
		
		cell = collisionLayer.getCell((int)(x/tileWidth),(int)(y/tileHeight));
		
		return cell == null ? false : true;
	}
	
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
			if (character.canRun())
				speed = runSpeed;
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
		
		if(keycode == Keys.TAB){
			craftingMode();
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
		
		useItem();
		
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

		return false;
	}
	
	private void collectStuff(){
		//check around player
		
		//collect and delete stuff
		
	}
	
	private void useItem(){
		character.getBag().useItem();
	}
	
	public void craftingMode(){
		game.setScreen(new CraftingScreen(this, screen, game));
	}

}