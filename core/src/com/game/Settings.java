package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Settings {
	
	/**
	 * contains the main data so it does not have to be loaded during the game
	 */
	
	private static DontCry game;
	
	public static Texture logo				= new Texture("../core/assets/openingscreen/badlogic.jpg");
	
	public static float volume 				= 1.0f;
	
	public static Skin skin 				= new Skin(new FileHandle("../core/assets/skins/mainmenu/uiskin.json"));
	
	public static FileHandle music			= new FileHandle("../core/assets/music/01.mp3");
	
	public static Sound sound				= Gdx.audio.newSound(new FileHandle("../core/assets/sounds/collect.mp3"));
	public static long soundID				= sound.play(0.0f);
	
	public static Texture halfheart			= new Texture("../core/assets/icons/hearts/halfheart.png");
	public static Texture fullheart 		= new Texture("../core/assets/icons/hearts/fullheart.png");
	
	public static Texture halfchickenleg 	= new Texture("../core/assets/icons/chickenlegs/halfchickenleg.png");
	public static Texture fullchickenleg 	= new Texture("../core/assets/icons/chickenlegs/fullchickenleg.png");
	
	public static String maleFemale 		= "male";
	public static Texture playerBack 		= new Texture(new FileHandle("../core/assets/player/"+maleFemale+"/"+maleFemale+"Back.png"));
	public static Texture playerFront 		= new Texture(new FileHandle("../core/assets/player/"+maleFemale+"/"+maleFemale+"Front.png"));
	public static Texture playerLeft 		= new Texture(new FileHandle("../core/assets/player/"+maleFemale+"/"+maleFemale+"Left.png"));
	public static Texture playerRight 		= new Texture(new FileHandle("../core/assets/player/"+maleFemale+"/"+maleFemale+"Right.png"));
	
	public void setGame(final DontCry dontcry){
		game = dontcry;
	}
	
	public static void setVolume(float vol){
		volume = vol;
		game.setVolume();
	}
	
	/**
	 * used to change the textures according to the sex of our player
	 * @param maleFemale
	 */
	public static void setMaleFemale(String maleFemale){
		Settings.maleFemale = maleFemale;
		
		playerBack.dispose();
		playerFront.dispose();
		playerLeft.dispose();
		playerRight.dispose();
		
		playerBack = new Texture(new FileHandle("../core/assets/player/"+maleFemale+"/"+maleFemale+"Back.png"));
		playerFront = new Texture(new FileHandle("../core/assets/player/"+maleFemale+"/"+maleFemale+"Front.png"));
		playerLeft = new Texture(new FileHandle("../core/assets/player/"+maleFemale+"/"+maleFemale+"Left.png"));
		playerRight = new Texture(new FileHandle("../core/assets/player/"+maleFemale+"/"+maleFemale+"Right.png"));
		
	}
	
}
