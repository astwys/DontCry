package com.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.DontCry;

public class DesktopLauncher {
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = WIDTH;
		config.height = HEIGHT;
		config.vSyncEnabled = true;
		config.resizable = false;
		config.fullscreen = false;
		new LwjglApplication(new DontCry(), config);
	}
	
	//SOME NOTES FOR BETTER UNDERSTANDING
	/*s
	 * 1 tile = 20.803711f units
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
}
