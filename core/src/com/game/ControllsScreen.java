package com.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class ControllsScreen implements Screen {

	private OptionScreen optionScreen;
	
	private Stage stage;
	private TextButton txtbtn_back;
	
	//labels
	private Label l_move;
	
	public ControllsScreen(OptionScreen parentScreen) {
		optionScreen = parentScreen;
		l_move = new Label("Moving:", Settings.skin);
		
	}
	
	@Override
	public void show() {

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
