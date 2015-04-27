package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.slot.Bag;

public class CraftingScreen implements Screen {

	public class CSInputProcessor implements InputProcessor{

		@Override
		public boolean keyDown(int keycode) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean keyUp(int keycode) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean keyTyped(char character) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean touchDown(int screenX, int screenY, int pointer, int button) {
			
			addResourceToCraft();
			
			return true;
		}

		@Override
		public boolean touchUp(int screenX, int screenY, int pointer, int button) {
			// TODO Auto-generated method stub
			return false;
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
			bag.setSelected(amount);
			return true;
		}
		
	}
	
	private DontCry game;
	private PlayScreen screen;
	private Player player;
	private Bag bag;
	private Bag craftTo;
	
	//InputProcessor
	private CSInputProcessor inputp;
	
	//Stage
	private Stage stage;
	private TextButton txtbtn_craft;
	private TextButton txtbtn_cancle;
	private TextButton txtbtn_returnToGame;
	
	public CraftingScreen(Player player, PlayScreen playscreen, final DontCry dontcry){
		game = dontcry;
		screen = playscreen;
		this.player = player;
		this.bag = player.getCharacter().getBag();
	}
	
	public void addResourceToCraft(){
		craftTo.add(bag.getSelectedItem(), 1);
		bag.addSelectedItemToCraft();
	}
	
	public void cancle(){
		//TODO cancle the craft and return stuff to the bag
	}
	
	public void returnToGame(){
		if(!craftTo.isEmpty()){
			for(int i=0; i<craftTo.getResources().length; i++){
				if(!craftTo.getResources()[i].isEmpty()){
					bag.add(craftTo.getResources()[i].getResource(), craftTo.getResources()[i].getAmount());
				}
			}
		}
		screen.getPLayer().getCharacter().setBag(this.bag);
		screen.reinitialiseBag(this.bag);
		game.setScreen(screen);
		this.dispose();
	}
	
	
	// -------------------------------- graphical stuff ---------------------------------------
	@Override
	public void show() {
		stage = new Stage();
		inputp = new CSInputProcessor();
		
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
				cancle();
			}
			
		});
		
		txtbtn_returnToGame = new TextButton("Return to game", PlayScreen.skin);
		txtbtn_returnToGame.setPosition(10, 10);
		txtbtn_returnToGame.setSize(120, 40);
		txtbtn_returnToGame.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				returnToGame();
			}
			
		});
		
		for(int i=0; i<bag.getResources().length; i++){
			bag.getResources()[i].getLabel().setAlignment(Align.left);
		}
		bag.setPosition(100, 450);
		
		craftTo = new Bag(player.getCharacter());
		for(int i=0; i<bag.getResources().length; i++){
			craftTo.getResources()[i].getLabel().setAlignment(Align.left);
			craftTo.getResources()[i].getLabel().setColor(new Color(1, 1, 1, 1));
		}
		craftTo.setSize(4);
		craftTo.setPosition(200, 300);
		
		stage.addActor(txtbtn_craft);
		stage.addActor(txtbtn_cancle);
		stage.addActor(txtbtn_returnToGame);
		stage.addActor(bag);
		stage.addActor(craftTo);
		
		InputMultiplexer inmulti = new InputMultiplexer();
		inmulti.addProcessor(stage);
		inmulti.addProcessor(inputp);
		Gdx.input.setInputProcessor(inmulti);
		
		
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
		stage.dispose();
	}

}
