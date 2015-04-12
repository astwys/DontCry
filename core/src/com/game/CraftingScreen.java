package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.slot.Bag;

public class CraftingScreen implements Screen {

	private DontCry game;
	private Player player;
	private Bag bag;
	
	//Stage
	private Stage stage;
	private TextButton txtbtn_craft;
	private TextButton txtbtn_cancle;
	private TextButton txtbtn_returnToGame;
	
	public CraftingScreen(Player player, final DontCry dontcry){
		game = dontcry;
		this.player = player;
		this.bag = player.getCharacter().getBag();
	}
	
	@Override
	public void show() {
		stage = new Stage();
		
		txtbtn_craft = new TextButton("Craft", PlayScreen.skin);
		txtbtn_craft.setPosition(650, 200);
		txtbtn_craft.setSize(120, 40);
		txtbtn_craft.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				txtbtn_craft.setText("Crafted");
			}
			
		});
		
		txtbtn_cancle = new TextButton("Cancle", PlayScreen.skin);
		txtbtn_cancle.setPosition(150, 10);
		txtbtn_cancle.setSize(120, 40);
		txtbtn_cancle.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				txtbtn_cancle.setText("Canceled");
			}
			
		});
		
		txtbtn_returnToGame = new TextButton("Return to game", PlayScreen.skin);
		txtbtn_returnToGame.setPosition(10, 10);
		txtbtn_returnToGame.setSize(120, 40);
		txtbtn_returnToGame.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				txtbtn_returnToGame.setText("Returned");
			}
			
		});
		
		stage.addActor(txtbtn_craft);
		stage.addActor(txtbtn_cancle);
		stage.addActor(txtbtn_returnToGame);
		
		Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		stage.act();
		stage.draw();
		game.batch.end();
		
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
