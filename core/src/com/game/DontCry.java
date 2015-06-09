package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class DontCry extends Game implements Disposable {
	
	/**
	 * the basis of the whole game, starts the processes
	 */
	
	SpriteBatch batch;
	BitmapFont font;
	
	//music
	public static Music music;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		//starting the music
		music = Gdx.audio.newMusic(Settings.music);
		music.setVolume(Settings.volume);
		music.setLooping(true);
		music.play();
		
		//start the game with the opening screen
		this.setScreen(new OpeningScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	public void dispose(){
		batch.dispose();
		font.dispose();
		music.dispose();
	}
	
	//used if we cahnge the volume in the option screen
	public static void setVolume(){
		music.setVolume(Settings.volume);
	}
	
	
}
