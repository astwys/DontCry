package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CreationScreen implements Screen {

	private DontCry game;
	private MainMenuScreen mainmenu;
	
	private Stage stage;
	private TextField tf_name;
	private Label l_name;
	private TextButton txtbtn_back;
	private TextButton txtbtn_start;
	private CheckBox cb_male;
	private CheckBox cb_female;
	private ButtonGroup<CheckBox> btng_male;
	
	public CreationScreen(final DontCry dontcry, final MainMenuScreen screen){
		game = dontcry;
		mainmenu = screen;
		
		stage = new Stage();
		
		tf_name = new TextField("", Settings.skin);
		tf_name.setPosition(360, 250);
		
		l_name = new Label("Name:", Settings.skin);
		l_name.setPosition(410, 280);
		
		txtbtn_start = new TextButton("Let\'s go", Settings.skin);
		txtbtn_start.setSize(80, 30);
		txtbtn_start.setPosition(345, 100);
		txtbtn_start.addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				String name = tf_name.getText();
				if(btng_male.getChecked().getName().equals("male")) Settings.setMaleFemale("male");
				else Settings.setMaleFemale("female");
				
				dispose();
				game.setScreen(new PlayScreen(game, name));
			}
			
		});
		
		txtbtn_back = new TextButton("Back", Settings.skin);
		txtbtn_back.setSize(80, 30);
		txtbtn_back.setPosition(445, 100);
		txtbtn_back.addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(mainmenu);
			}
			
		});
		
		cb_male = new CheckBox("Male", Settings.skin);
		cb_male.setChecked(true);
		cb_male.setName("male");
		cb_male.setPosition(375, 190);
		
		cb_female = new CheckBox("Female", Settings.skin);
		cb_female.setName("female");
		cb_female.setPosition(445, 190);
		
		btng_male = new ButtonGroup<CheckBox>(cb_male, cb_female);
		
		stage.addActor(tf_name);
		stage.addActor(l_name);
		stage.addActor(txtbtn_start);
		stage.addActor(txtbtn_back);
		stage.addActor(cb_male);
		stage.addActor(cb_female);
		
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		

	}

	@Override
	public void pause() {
		

	}

	@Override
	public void resume() {
		

	}

	@Override
	public void hide() {
		

	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}
