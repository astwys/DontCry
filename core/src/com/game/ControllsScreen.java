package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ControllsScreen implements Screen {

	private DontCry game;
	private OptionScreen optionScreen;
	
	private Stage stage;
	private TextButton txtbtn_back;
	
	//labels
	
	// movement
	private Label l_move_up;
	private Label l_move_down;
	private Label l_move_right;
	private Label l_move_left;
	private Label l_move_run;

	// crafting & collecting
	private Label cc_collect;
	private Label cc_inventory;
	private Label cc_scroll;
	private Label cc_moveItem;
	private Label cc_dropItem;
	
	// eating & healing
	private Label eh_eat; 
	
	public ControllsScreen(final DontCry dontcry, OptionScreen parentScreen) {
		game = dontcry;
		optionScreen = parentScreen;
		
		stage = new Stage();
		
		l_move_up = new Label("Move Up:     W or Arrow Key Up", Settings.skin);
		l_move_up.setPosition(200, 500);
		l_move_down = new Label("Move Down:     S or Arrow Key Down", Settings.skin);
		l_move_down.setPosition(200, 470);
		l_move_right = new Label("Move Right:     D or Arrow Key Right", Settings.skin);
		l_move_right.setPosition(200, 440);
		l_move_left = new Label("Move Left:     A or Arrow Key Left", Settings.skin);
		l_move_left.setPosition(200, 410);
		l_move_run = new Label("Run:     Press shift and move", Settings.skin);
		l_move_run.setPosition(200, 380);
		
		cc_collect = new Label("Collect Resources:     Hold Space", Settings.skin);
		cc_collect.setPosition(200, 350);
		cc_inventory = new Label("Open Inventory:     Tab or Inventory Button", Settings.skin);
		cc_inventory.setPosition(200, 320);
		cc_scroll = new Label("Select Inventory Item:     Mouse Scroll-Wheel", Settings.skin);
		cc_scroll.setPosition(200, 290);
		cc_moveItem = new Label("Rearange Items in the Inventory:     Right-Click Item - Select new position - Right-Click", Settings.skin);
		cc_moveItem.setPosition(200, 260);
		cc_dropItem = new Label("Drop Item:     Q", Settings.skin);
		cc_dropItem.setPosition(200, 230);
		
		eh_eat = new Label("Eat & Heal:     Left Click with edible resource selected", Settings.skin);
		eh_eat.setPosition(200, 200);
		
		txtbtn_back = new TextButton("Back", Settings.skin);
		txtbtn_back.addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(optionScreen);
			}
			
		});
		txtbtn_back.setSize(150, 50);
		txtbtn_back.setPosition(375, 50);
		
		stage.addActor(l_move_up);
		stage.addActor(l_move_down);
		stage.addActor(l_move_right);
		stage.addActor(l_move_left);
		stage.addActor(l_move_run);
		
		stage.addActor(cc_collect);
		stage.addActor(cc_inventory);
		stage.addActor(cc_scroll);
		stage.addActor(cc_moveItem);
		stage.addActor(cc_dropItem);
		
		stage.addActor(eh_eat);
		
		stage.addActor(txtbtn_back);
		
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
