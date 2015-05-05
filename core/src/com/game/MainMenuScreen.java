package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class MainMenuScreen implements Screen {

	private DontCry game;
	private MainMenuScreen thisScreen;
	
	//fields for main menu
	private Skin skin;
	private Stage stage;
	private TextButton txtbtn_play, txtbtn_options, txtbtn_exit;
	
	public MainMenuScreen(final DontCry dontcry){
		game = dontcry;
		thisScreen = this;
		stage = new Stage(new ExtendViewport(900, 600));
		skin = new Skin(new FileHandle("../core/assets/skins/mainmenu/uiskin.json"));
		initialiseButtons();
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		stage.act(delta);
		stage.draw();
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
		skin.dispose();
	}
	
	
	//---------------------------------------------------- my methods --------------------------------------------
	public void initialiseButtons(){
		//initialising txtbtn_play
		txtbtn_play = new TextButton("Play", skin);
		txtbtn_play.setBounds(900/2-80-80/2-40, 200, 80, 50);
		txtbtn_play.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				game.setScreen(new CreationScreen(game, thisScreen));
			}
			
		});
		
		//initialise txtbtn_options
		txtbtn_options = new TextButton("Options", skin);
		txtbtn_options.setBounds(900/2-80/2, 200, 80, 50);
		txtbtn_options.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				game.setScreen(new OptionScreen(game, getScreen()));
			}
			
		});
		
		txtbtn_exit = new TextButton("Exit", skin);
		txtbtn_exit.setBounds(900/2+80/2+40, 200, 80, 50);
		txtbtn_exit.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				Gdx.app.exit();
			}
			
		});
		
		stage.addActor(txtbtn_play);
		stage.addActor(txtbtn_options);
		stage.addActor(txtbtn_exit);
	}
	
	public MainMenuScreen getScreen(){
		return this;
	}

}