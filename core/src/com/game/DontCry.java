package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class DontCry extends Game implements Disposable {
	
	SpriteBatch batch;
	BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new OpeningScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	public void dispose(){
		batch.dispose();
		font.dispose();
	}
}
