package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class OpeningScreen implements Screen, InputProcessor {

	private DontCry game;
	
	//textures
	private Texture texture;
	
	//variables for blinking
	private boolean increase;
	private float alpha;
	
	public OpeningScreen(final DontCry dontcry){
		game = dontcry;		
	}


	//------------------------------------------------------ methods from Screen ------------------------------------------------------------
	@Override
	public void show() {
		texture = Settings.logo;
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		game.batch.draw(texture, 900/2-128, 600/2-100);
		game.font.setColor(1, 1, 1, alpha);
		game.font.draw(game.batch, "Click anywhere to continue", 900/2-85, 120);
		game.batch.end();
		
		if(increase) alpha += 0.02f;
		else if(!increase) alpha -= 0.02f;
		
		if(alpha < 0.1f) increase = true;
		else if(alpha > 0.9f) increase = false;
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {}


	// ---------------------------------------------------------- methods from InputProcessor -----------------------------------------------------------
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		goAhead();
		return true;
	}


	@Override
	public boolean keyTyped(char character) {
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		goAhead();
		return true;
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
	
	//---------------------------------------------------------- my methods -------------------------------
	
	private void goAhead(){
		this.dispose();
		game.setScreen(new MainMenuScreen(game));
	}

}
