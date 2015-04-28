package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class OptionScreen implements Screen {

	private MainMenuScreen mainmenu;
	
	private Stage stage;
	private Label l_volume;
	private Slider s_volume;
	private TextButton txtbtn_ok;
	
	public OptionScreen(MainMenuScreen parentScreen){
		mainmenu = parentScreen;
		stage = new Stage();
	}
	
	@Override
	public void show() {
		l_volume = new Label("Volume", Settings.skin);
		l_volume.setPosition(100, 100);
		s_volume = new Slider(0, 100, 5, true, Settings.skin);
		s_volume.setValue(Settings.volume*100);
		s_volume.setPosition(200, 200);
		txtbtn_ok = new TextButton("Return to menu", Settings.skin);
		txtbtn_ok.setSize(100, 30);
		txtbtn_ok.setPosition(50, 375);
		
		stage.addActor(l_volume);
		stage.addActor(s_volume);
		stage.addActor(txtbtn_ok);
		
		Gdx.input.setInputProcessor(stage);
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

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
