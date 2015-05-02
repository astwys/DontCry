package com.game;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Settings {
	
	public static float volume = 1.0f;
	public static Skin skin = new Skin(new FileHandle("../core/assets/skins/mainmenu/uiskin.json"));
	
	public static void setVolume(float vol){
		volume = vol;
	}
	
}
