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
	
	private Player player;
	private TiledMapTileLayer blockedLayer;
	private TiledMapTileLayer groundLayer;
	
	//important variables regarding the map for collision detection
	private float tileWidth = 20.8f, tileHeight = 20.8f;
	
	private Random r; //togenerate the random number
	
	public Collector(Player p, TiledMapTileLayer blocking, TiledMapTileLayer ground){
		player = p;
		r = new Random();
		blockedLayer = blocking;
		groundLayer = ground;
	}
	
	public void collect(){
		
		//the position of the player
		float x = player.getX();
		float y = player.getY();
		
		boolean collect = false;
		
		/**
		 * check in the blocked layer
		 */
		//top left
		collect = checkForKey(blockedLayer, x-2, y+player.getHeight());
		if(collect) return;
		//top middle
		collect = checkForKey(blockedLayer, x+player.getWidth()/2, y+player.getHeight()+2);
		if(collect) return;
		//top right
		collect = checkForKey(blockedLayer, x+player.getWidth()+2, y+player.getHeight()+2);
		if(collect) return;
		
		//left middle
		collect = checkForKey(blockedLayer, x+2, y+player.getHeight()/2);
		if(collect) return;
		//right middle
		collect = checkForKey(blockedLayer, x+player.getWidth()-2, y+player.getHeight()/2);
		if(collect) return;
		
		//bottom left
		collect = checkForKey(blockedLayer, x-2, y-2);
		if(collect) return;
		//bottom middle
		collect = checkForKey(blockedLayer, x+player.getWidth()/2, y-2);
		if(collect) return;
		//bottom right
		collect = checkForKey(blockedLayer, x+player.getWidth()+2, y-2);

		
		/**
		 * check in the ground layer
		 */
		collect = checkForKey(groundLayer, x/*+player.getWidth()/2*/, y/*+player.getHeight()/2*/);
		if(collect) return;
		
	}
	
	private boolean checkForKey(TiledMapTileLayer layer, float x, float y){
		try{
			
			TiledMapTile tile = layer.getCell((int)(x/tileWidth),(int)(y/tileHeight)).getTile();

			if(tile.getProperties().containsKey("Resource")){
				decideResource(tile);
				return true;
			}
			
			return false;
			
		}catch(Exception e){
			return false;
		}
	}
	
	private void decideResource(TiledMapTile tile){
		
		int num = r.nextInt();
		if(num%16 != 0) return;
		
		String name = (String)tile.getProperties().get("Resource");
		
		switch(name){
			case "Apple": 		player.getCharacter().getBag().add(new Apple(), 1); break;
			
			case "Potato": 		player.getCharacter().getBag().add(new Potato(), 1); break;
			
			case "RedFlower": 	player.getCharacter().getBag().add(new RedFlower(), 1); break;
			
			case "YellowFlower":player.getCharacter().getBag().add(new YellowFlower(), 1); break;
		}
		
		//if we want to collect wood, stone, diamond, ...
		String inUse = player.getCharacter().getBag().getSelectedItem().getName();
		
		int categoryAxe = 0; //for geting wood and coal
		int categoryPick = 0; //for getting stone, iron, ...
		
		switch(inUse){
		
			case "WoodAxe": 	categoryAxe = 1; break;
			case "StoneAxe": 	categoryAxe = 2; break;
			case "IronAxe": 	categoryAxe = 3; break;
			case "GoldAxe": 	categoryAxe = 4; break;
			case "DiamondAxe": 	categoryAxe = 5; break;
		
			case "a": return;
			case "b": return;
			case "c": return; //TODO pickaxe
			case "d": return;
			case "e": return;
			
			default: categoryAxe = 0; categoryPick = 0;
		}
		
		if(name.equals("Stone")){
			player.getCharacter().getBag().add(new Stone(), 1);
			
			//reduce the propability
			num = r.nextInt();
			if(num%4 != 0) return;
			
			if(categoryPick == 1){
				player.getCharacter().getBag().add(new Stone(), 1);
			}else if(categoryPick == 2){
				player.getCharacter().getBag().add(new Iron(), 1);
			}else if(categoryPick == 3){
				player.getCharacter().getBag().add(new Gold(), 1);
			}else if(categoryPick >= 4){
				player.getCharacter().getBag().add(new Diamond(), 1);
			}
		}else if(name.equals("Coal")){
			player.getCharacter().getBag().add(new Coal(), categoryAxe+1);
			
		}else if(name.equals("Wood")){
			player.getCharacter().getBag().add(new Wood(), categoryAxe+1);
		}
		
	}
	
	
	
	
	
	
}
