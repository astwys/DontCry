package com.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
import com.craft.Craftingbook.ReturnForCraft;
import com.resources.Resource;
import com.resources.craftable.DiamondPlate;
import com.resources.craftable.Fire;
import com.resources.craftable.GoldPlate;
import com.resources.craftable.IronPlate;
import com.resources.craftable.StonePlate;
import com.resources.craftable.WoodPlate;
import com.resources.craftable.WoodStick;
import com.resources.craftable.edible.Chips;
import com.resources.craftable.potions.HealthPotionBig;
import com.resources.craftable.potions.HealthPotionSmall;
import com.resources.craftable.tools.DiamondAxe;
import com.resources.craftable.tools.DiamondSword;
import com.resources.craftable.tools.GoldAxe;
import com.resources.craftable.tools.GoldSword;
import com.resources.craftable.tools.IronAxe;
import com.resources.craftable.tools.IronSword;
import com.resources.craftable.tools.StoneAxe;
import com.resources.craftable.tools.StoneSword;
import com.resources.craftable.tools.WoodAxe;
import com.resources.craftable.tools.WoodSword;
import com.slot.Bag;

public class CraftingScreen implements Screen {

	public class CSInputProcessor implements InputProcessor{

		@Override
		public boolean keyDown(int keycode) {
			return false;
		}

		@Override
		public boolean keyUp(int keycode) {
			
			if(keycode == Keys.TAB){
				returnToGame();
			}
			
			return true;
		}

		@Override
		public boolean keyTyped(char character) {
			return false;
		}

		@Override
		public boolean touchDown(int screenX, int screenY, int pointer, int button) {
			
			if(button == 0) addResourceToCraft();
			
			return true;
		}

		@Override
		public boolean touchUp(int screenX, int screenY, int pointer, int button) {
			return false;
		}

		@Override
		public boolean touchDragged(int screenX, int screenY, int pointer) {
			return false;
		}

		@Override
		public boolean mouseMoved(int screenX, int screenY) {
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
	private Bag bag; //initial bag of the player
	private Bag craftTo; //the selected items the user wants to craft
	
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
		Resource r = bag.getSelectedItem();
		if(r != null){
			craftTo.add(bag.getSelectedItem(), 1);
			bag.addSelectedItemToCraft();
			ArrayList<String> craftFrom = new ArrayList<String>();

			for(int i=0; i<craftTo.getResources().length; i++){
				if(!craftTo.getResources()[i].isEmpty()){
					for(int j=0; j<craftTo.getResources()[i].getAmount(); j++){
						craftFrom.add(craftTo.getResources()[i].getResource().getName());
					}
				}
			}
			if(craftFrom.size() > 1){
				String result = player.getCharacter().craftsInto(craftFrom);
				txtbtn_craft.setText(result);
			}else{
				txtbtn_craft.setText("Craft");
			}
			
		}else{
			if(craftTo.isEmpty()) {
				txtbtn_craft.setText("Craft");
			}
		}
	}
	
	public void cancle(){
		for(int i=0; i<craftTo.getResources().length; i++){
			bag.add(craftTo.getResources()[i].getResource(), craftTo.getResources()[i].getAmount());
			craftTo.getResources()[i].setAmount(0);
			txtbtn_craft.setText("Craft");
		}
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
	
	public void craftStuff(){
		if(craftTo.isEmpty()) return;
		//recognize and craft the item
		ArrayList<String> craftFrom = new ArrayList<String>();

		for(int i=0; i<craftTo.getResources().length; i++){
			if(!craftTo.getResources()[i].isEmpty()){
				for(int j=0; j<craftTo.getResources()[i].getAmount(); j++){
					craftFrom.add(craftTo.getResources()[i].getResource().getName());
				}
			}
		}
		
		ReturnForCraft rfc = player.getCharacter().getCraftingBook().craft(craftFrom);
		if(rfc == null) return;
		Resource toAdd = rfc.getResource();
		int amount = rfc.getAmount();
		bag.add(toAdd, amount);
		
		//delete stuff out of the craftTo & craftFrom array (ist noch die assoziale methode)
//		ArrayList<String> resourcesUsed = toAdd.getResourcesNeeded();
//		for(int i=0; i<craftFrom.size(); i++){
//			for(int j=0; j<resourcesUsed.size(); i++){
//				if(resourcesUsed.get(j).equals(craftFrom.get(i))){
//					craftFrom.
//				}
//			}
//		}
		craftTo.clearBackpack();
		
	}
	
	
	// -------------------------------- graphical stuff ---------------------------------------
	@Override
	public void show() {
		stage = new Stage();
		inputp = new CSInputProcessor();
		
		txtbtn_craft = new TextButton("Craft", Settings.skin);
		txtbtn_craft.setPosition(550, 310);
		txtbtn_craft.setSize(120, 40);
		txtbtn_craft.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				craftStuff();
				txtbtn_craft.setText("Craft");
			}
			
		});
		
		txtbtn_cancle = new TextButton("Cancle", Settings.skin);
		txtbtn_cancle.setPosition(550, 250);
		txtbtn_cancle.setSize(120, 40);
		txtbtn_cancle.addListener(new ClickListener(){
			
			public void clicked(InputEvent input, float x, float y){
				cancle();
			}
			
		});
		
		txtbtn_returnToGame = new TextButton("Return to game", Settings.skin);
		txtbtn_returnToGame.setPosition(375, 50);
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
		craftTo.setPosition(350, 350);
		
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

}
