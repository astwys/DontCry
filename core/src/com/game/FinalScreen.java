package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class FinalScreen implements Screen {

	private DontCry game;
	private MainMenuScreen mainmenu;
	
	private Stage stage;
	private Label l_text;
	private TextButton txtbtn_mainmenu;
	private TextButton txtbtn_restart;
	
	//for changing the background colour on the screen
	private boolean up = true;
	private float multiplicator = 100.f;
	
	public FinalScreen(final DontCry dontcry, MainMenuScreen screen, String text) {
		game = dontcry;
		mainmenu = screen;
		
		stage = new Stage();
		
		l_text = new Label(text, Settings.skin);
		l_text.setFontScale(3.0f);
		l_text.setPosition(225, 400);
		
		txtbtn_mainmenu = new TextButton("Main menu", Settings.skin);
		txtbtn_mainmenu.setSize(100, 30);
		txtbtn_mainmenu.setPosition(325, 250);
		txtbtn_mainmenu.addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				dispose();
				game.setScreen(mainmenu);
				
			}
			
		});
		
		txtbtn_restart = new TextButton("Play again", Settings.skin);
		txtbtn_restart.setSize(100, 30);
		txtbtn_restart.setPosition(450, 250);
		txtbtn_restart.addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				dispose();
				game.setScreen(new CreationScreen(game, mainmenu));
				
			}
			
		});
		
		stage.addActor(l_text);
		stage.addActor(txtbtn_mainmenu);
		stage.addActor(txtbtn_restart);
		
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1-delta*multiplicator, 0+delta*multiplicator, 0+delta*multiplicator, 1); //different background colour
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		stage.draw();
		
		if(up) multiplicator += 2.0f;
		else if(!up) multiplicator -= 2.0f;
		
		if(multiplicator >= 100.0f) up = false;
		else if(multiplicator <= 3.0f) up = true;
		
		
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
	public void dispose() {
		stage.dispose();
	}

}
