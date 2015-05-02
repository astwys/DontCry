package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class OptionScreen implements Screen {

	private DontCry game;
	private MainMenuScreen mainmenu;
	
	private Stage stage;
	private Label l_volume, l_volAmount;
	private Slider s_volume;
	private TextButton txtbtn_ok;
	
	public OptionScreen(final DontCry game, MainMenuScreen parentScreen){
		this.game = game;
		mainmenu = parentScreen;
		stage = new Stage();
	}
	
	@Override
	public void show() {
		l_volume = new Label("Volume: ", Settings.skin);
		l_volume.setPosition(290, 370);
		
		l_volAmount = new Label(Settings.volume*100+"", Settings.skin);
		l_volAmount.setPosition(390, 370);
		
		s_volume = new Slider(0, 100, 5, false, Settings.skin);
		s_volume.setValue(Settings.volume*100);
		s_volume.setPosition(460, 375);
		
		txtbtn_ok = new TextButton("Return to menu", Settings.skin);
		txtbtn_ok.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				Settings.setVolume(s_volume.getValue()/100.0f);
				game.setScreen(mainmenu);
			}
			
		});
		txtbtn_ok.setSize(150, 50);
		txtbtn_ok.setPosition(375, 50);
		
		stage.addActor(l_volume);
		stage.addActor(l_volAmount);
		stage.addActor(s_volume);
		stage.addActor(txtbtn_ok);
		
		Gdx.input.setInputProcessor(stage);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		int amount = (int)(s_volume.getValue());
		l_volAmount.setText(amount+"");
		
		stage.act();
		stage.draw();

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

}
