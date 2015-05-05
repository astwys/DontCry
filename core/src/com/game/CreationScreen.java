package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
	
	private Texture preview; //shows wether male or female character
	
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
		tf_name.setMaxLength(15);
		
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
				game.setScreen(new PlayScreen(game, mainmenu, name));
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
		cb_male.addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Settings.setMaleFemale("male");
				changePreview();
			}
			
		});
		
		cb_female = new CheckBox("Female", Settings.skin);
		cb_female.setName("female");
		cb_female.setPosition(445, 190);
		cb_female.addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Settings.setMaleFemale("female");
				changePreview();
			}
			
		});
		
		btng_male = new ButtonGroup<CheckBox>(cb_male, cb_female);
		
		stage.addActor(tf_name);
		stage.addActor(l_name);
		stage.addActor(txtbtn_start);
		stage.addActor(txtbtn_back);
		stage.addActor(cb_male);
		stage.addActor(cb_female);
		
		preview = Settings.playerFront;
		
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
		
		game.batch.begin();
		game.batch.draw(preview, 423, 350);
		game.batch.end();
		
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
	
	private void changePreview(){ //true -> change to male, false -> change to female
		preview.dispose();
		preview = Settings.playerFront;
	}

}
