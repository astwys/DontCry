package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
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
		texture = new Texture("../core/assets/openingscreen/badlogic.jpg");
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
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}


	// ---------------------------------------------------------- methods from InputProcessor -----------------------------------------------------------
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		goAhead();
		return true;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		goAhead();
		return true;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//---------------------------------------------------------- my methods -------------------------------
	
	private void goAhead(){
		this.dispose();
		game.setScreen(new MainMenuScreen(game));
	}

}
