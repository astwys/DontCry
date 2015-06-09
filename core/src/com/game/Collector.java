package com.game;

import java.util.Random;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.resources.natural.edible.Apple;
import com.resources.natural.edible.Potato;
import com.resources.natural.edible.RedFlower;
import com.resources.natural.edible.YellowFlower;
import com.resources.natural.minerals.Coal;
import com.resources.natural.minerals.Diamond;
import com.resources.natural.minerals.Gold;
import com.resources.natural.minerals.Iron;
import com.resources.natural.minerals.Stone;
import com.resources.natural.minerals.Wood;

public class Collector {
	
	/**
	 * responsible for collecting the items
	 */
	
	private Player player;
	private TiledMapTileLayer blockedLayer; //all resources we can collect are in the blocking layer
	
	//defines if the end of the game was found
	public boolean finishFound = false;
		
	//important variables regarding the map for collision detection
	private float tileWidth = 20.8f, tileHeight = 20.8f;
	
	private Random r; //to generate the random number
	
	public Collector(Player p, TiledMapTileLayer blocking){
		player = p;
		r = new Random();
		blockedLayer = blocking;
	}
	
	/**
	 * called when we press space
	 * @return if we found the finish
	 */
	public boolean collect(){ //returns true if the end of the game was reached
		
		//the position of the player
		float x = player.getX();
		float y = player.getY();
		
		boolean collect = false;
		
		/**
		 * check in the blocked layer all around the player
		 */
		//top left
		collect = checkForKey(blockedLayer, x-2, y+player.getHeight());
		if(collect) return false;
		//top middle
		collect = checkForKey(blockedLayer, x+player.getWidth()/2, y+player.getHeight()+2);
		if(collect) return false;
		//top right
		collect = checkForKey(blockedLayer, x+player.getWidth()+2, y+player.getHeight()+2);
		if(collect) return false;
		
		//left middle
		collect = checkForKey(blockedLayer, x+2, y+player.getHeight()/2);
		if(collect) return false;
		//right middle
		collect = checkForKey(blockedLayer, x+player.getWidth()-2, y+player.getHeight()/2);
		if(collect) return false;
		
		//bottom left
		collect = checkForKey(blockedLayer, x-2, y-2);
		if(collect) return false;
		//bottom middle
		collect = checkForKey(blockedLayer, x+player.getWidth()/2, y-2);
		if(collect) return false;
		//bottom right
		collect = checkForKey(blockedLayer, x+player.getWidth()+2, y-2);
		if(collect) return false;
		
		if(finishFound) return true;
		
		return false;
		
	}
	
	/**
	 * @param layer
	 * @param x
	 * @param y
	 * @return if we found the end or a tile with a resource
	 */
	private boolean checkForKey(TiledMapTileLayer layer, float x, float y){
		try{
			
			TiledMapTile tile = layer.getCell((int)(x/tileWidth),(int)(y/tileHeight)).getTile();

			if(tile.getProperties().containsKey("action")){
				this.finishFound = true;
				return true;
			}
			
			if(tile.getProperties().containsKey("Resource")){
				decideResource(tile);
				return true;
			}
			
			return false;
			
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * if we found a tile with a resource we need to find out which resource and how many we get from that kind
	 * @param tile
	 */
	private void decideResource(TiledMapTile tile){
		
		int num = r.nextInt();
		if(num%16 != 0) return;
		
		boolean collected = false;
		
		String name = (String)tile.getProperties().get("Resource");
		
		switch(name){
			case "Apple": 		player.getCharacter().getBag().add(new Apple(), 1); collected = true; return;
			
			case "Potato": 		player.getCharacter().getBag().add(new Potato(), 1); collected = true; return;
			
			case "RedFlower": 	player.getCharacter().getBag().add(new RedFlower(), 1); collected = true; return;
			
			case "YellowFlower":player.getCharacter().getBag().add(new YellowFlower(), 1); collected = true; return;
		}
		
		//if we want to collect wood, stone, diamond, ...
		String inUse = player.getCharacter().getBag().getSelectedItem().getName();
		
		int categoryAxe = 0; //for getting wood and coal
		int categoryPick = 0; //for getting stone, iron, ...
		
		//find out the category of the tool we have equipped
		switch(inUse){
		
			case "WoodAxe": 	categoryAxe = 1; break;
			case "StoneAxe": 	categoryAxe = 2; break;
			case "IronAxe": 	categoryAxe = 3; break;
			case "GoldAxe": 	categoryAxe = 4; break;
			case "DiamondAxe": 	categoryAxe = 5; break;
		
			case "WoodPickaxe":		categoryPick = 1; break;
			case "StonePickaxe": 	categoryPick = 2; break;
			case "IronPickaxe": 	categoryPick = 3; break;
			case "GoldPickaxe": 	categoryPick = 4; break;
			case "DiamondPickaxe": 	categoryPick = 5; break;
			
			default: categoryAxe = 0; categoryPick = 0;
		}
		
		if(name.equals("Stone")){
			player.getCharacter().getBag().add(new Stone(), 1);
			collected = true;
			
			//reduce the probability
			num = r.nextInt();
			if(num%4 != 0){
			
				if(categoryPick == 1){
					player.getCharacter().getBag().add(new Stone(), 1);
				}else if(categoryPick == 2){
					player.getCharacter().getBag().add(new Iron(), 1);
				}else if(categoryPick == 3){
					player.getCharacter().getBag().add(new Gold(), 1);
				}else if(categoryPick >= 4){
					player.getCharacter().getBag().add(new Diamond(), 1);
				}
			
			}
		}else if(name.equals("Coal")){
			player.getCharacter().getBag().add(new Coal(), categoryAxe+1);
			collected = true;
			
		}else if(name.equals("Wood")){
			player.getCharacter().getBag().add(new Wood(), categoryAxe+1);
			collected = true;
		}
		
		if(collected){
			//play sound so we know we found something
			Settings.sound.play(Settings.volume);
		}
		
	}	
	
	
	
}
