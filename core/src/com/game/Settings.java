package com.game;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Settings {
	
	public static float volume 				= 1.0f;
	
	public static Skin skin 				= new Skin(new FileHandle("../core/assets/skins/mainmenu/uiskin.json"));
	
	public static Texture halfheart			= new Texture("../core/assets/icons/hearts/halfheart.png");
	public static Texture fullheart 		= new Texture("../core/assets/icons/hearts/fullheart.png");
	
	public static Texture halfchickenleg 	= new Texture("../core/assets/icons/chickenlegs/halfchickenleg.png");
	public static Texture fullchickenleg 	= new Texture("../core/assets/icons/chickenlegs/fullchickenleg.png");
	
	public static Texture playerBack 		= new Texture(new FileHandle("../core/assets/player/p_back.png"));
	public static Texture playerFront 		= new Texture(new FileHandle("../core/assets/player/p_front.png"));
	public static Texture playerLeft 		= new Texture(new FileHandle("../core/assets/player/p_left.png"));
	public static Texture playerRight 		= new Texture(new FileHandle("../core/assets/player/p_right.png"));
	
	public static void setVolume(float vol){
		volume = vol;
	}
	
}
