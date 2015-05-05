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
	
	public ControllsScreen(OptionScreen parentScreen) {
		optionScreen = parentScreen;
		l_move_up = new Label("Move Up:\tW or Arrow Key Up", Settings.skin);
		l_move_down = new Label("Move Down:\tS or Arrow Key Down", Settings.skin);
		l_move_right = new Label("Move Right:\tD or Arrow Key Right", Settings.skin);
		l_move_left = new Label("Move Left:\tA or Arrow Key Left", Settings.skin);
		
		cc_collect = new Label("Collect Resources:\tHold Space", Settings.skin);
		cc_inventory = new Label("Open Inventory:\tTab or Inventory Button", Settings.skin);
		cc_scroll = new Label("Select Inventory Item:\tMouse Scroll-Wheel", Settings.skin);
		cc_moveItem = new Label("Rearange Items in the Inventory:\tRight-Click Item - Select new position - Right-Click", Settings.skin);
		cc_dropItem = new Label("Drop Item:\tQ", Settings.skin);
		
		eh_eat = new Label("Eat & Heal:\tLeft Click with edible resource selected", Settings.skin);
		
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
