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

	/**
	 * just a damn big class containing the different labels to tell the user what the controls are
	 */
	
	private DontCry game;
	private OptionScreen optionScreen;
	
	private Stage stage;
	private TextButton txtbtn_back;
	
	//labels
	
	// movement
	private Label l_move_up;
	private Label l_move_up_cmd;
	private Label l_move_down;
	private Label l_move_down_cmd;
	private Label l_move_right;
	private Label l_move_right_cmd;
	private Label l_move_left;
	private Label l_move_left_cmd;
	private Label l_move_run;
	private Label l_move_run_cmd;

	// crafting & collecting
	private Label cc_collect;
	private Label cc_collect_cmd;
	private Label cc_inventory;
	private Label cc_inventory_cmd;
	private Label cc_scroll;
	private Label cc_scroll_cmd;
	private Label cc_moveItem;
	private Label cc_moveItem_cmd;
	private Label cc_dropItem;
	private Label cc_dropItem_cmd;
	// eating & healing
	private Label eh_eat;
	private Label eh_eat_cmd;
	
	public ControllsScreen(final DontCry dontcry, OptionScreen parentScreen) {
		game = dontcry;
		optionScreen = parentScreen;
		
		stage = new Stage();
		
		l_move_up = new Label("Move Up:", Settings.skin);
		l_move_up.setPosition(200, 500, Align.left);
		l_move_down = new Label("Move Down:", Settings.skin);
		l_move_down.setPosition(200, 470, Align.left);
		l_move_right = new Label("Move Right:", Settings.skin);
		l_move_right.setPosition(200, 440, Align.left);
		l_move_left = new Label("Move Left:", Settings.skin);
		l_move_left.setPosition(200, 410, Align.left);
		l_move_run = new Label("Run:", Settings.skin);
		l_move_run.setPosition(200, 380, Align.left);
		
		cc_collect = new Label("Collect Resources:", Settings.skin);
		cc_collect.setPosition(200, 330, Align.left);
		cc_inventory = new Label("Open Inventory:", Settings.skin);
		cc_inventory.setPosition(200, 300, Align.left);
		cc_scroll = new Label("Select Inventory Item:", Settings.skin);
		cc_scroll.setPosition(200, 270, Align.left);
		cc_moveItem = new Label("Rearange Items in the Inventory:", Settings.skin);
		cc_moveItem.setPosition(200, 240, Align.left);
		cc_dropItem = new Label("Drop Item:", Settings.skin);
		cc_dropItem.setPosition(200, 210, Align.left);
		
		eh_eat = new Label("Eat & Heal:", Settings.skin);
		eh_eat.setPosition(200, 160, Align.left);
		
		
		l_move_up_cmd = new Label("W or Arrow Key Up", Settings.skin);
		l_move_up_cmd.setPosition(700,  500, Align.right);
		l_move_down_cmd = new Label("S or Arrow Key Down", Settings.skin);
		l_move_down_cmd.setPosition(700, 470, Align.right);
		l_move_right_cmd = new Label("D or Arrow Key Right", Settings.skin);
		l_move_right_cmd.setPosition(700, 440, Align.right);
		l_move_left_cmd = new Label("A or Arrow Key Left", Settings.skin);
		l_move_left_cmd.setPosition(700, 410, Align.right);
		l_move_run_cmd = new Label("Shift", Settings.skin);
		l_move_run_cmd.setPosition(700, 380, Align.right);
		
		cc_collect_cmd = new Label("Hold Space", Settings.skin);
		cc_collect_cmd.setPosition(700, 330, Align.right);
		cc_inventory_cmd = new Label("Tab or Inventory Button", Settings.skin);
		cc_inventory_cmd.setPosition(700, 300, Align.right);
		cc_scroll_cmd = new Label("Mouse Scroll-Wheel", Settings.skin);
		cc_scroll_cmd.setPosition(700, 270, Align.right);
		cc_moveItem_cmd = new Label("Right-Click Item", Settings.skin);
		cc_moveItem_cmd.setPosition(700,  240, Align.right);
		cc_dropItem_cmd = new Label("Q", Settings.skin);
		cc_dropItem_cmd.setPosition(700, 210, Align.right);
		
		eh_eat_cmd = new Label("Left Click with edible resource selected", Settings.skin);
		eh_eat_cmd.setPosition(700, 160, Align.right);
		
	
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
		
		
		stage.addActor(l_move_up_cmd);
		stage.addActor(l_move_down_cmd);
		stage.addActor(l_move_right_cmd);
		stage.addActor(l_move_left_cmd);
		stage.addActor(l_move_run_cmd);
		
		stage.addActor(cc_collect_cmd);
		stage.addActor(cc_inventory_cmd);
		stage.addActor(cc_scroll_cmd);
		stage.addActor(cc_moveItem_cmd);
		stage.addActor(cc_dropItem_cmd);
		
		stage.addActor(eh_eat_cmd);
		
		
		stage.addActor(txtbtn_back);
		
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
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
	}

}
