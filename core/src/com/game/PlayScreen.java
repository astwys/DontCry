package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.slot.Bag;

public class PlayScreen implements Screen {
	
	private DontCry game;
	private MainMenuScreen mainmenu;
	
	//for the map
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private int[] background = {0, 1, 2};
	
	//for the HUD
	private Stage stage;
	private TextButton txtbtn_inventory;
	private StatusIndicator healthStatus;
	private StatusIndicator hungerStatus;
	
	//player
	private Player player;
	private float hunger;
	private float hungerIndicator; //the amount of time that needs to be passed until hunger is decreased 
	
	public PlayScreen(final DontCry dontcry, MainMenuScreen mainScreen, String name){
		game = dontcry;
		mainmenu = mainScreen;
		
		//stuff for rendering the tiledmap
		map = new TmxMapLoader().load("../core/assets/maps/map1/map1.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1.3f, game.batch);
		camera = new OrthographicCamera();
		
		//create and initialise the player with the collisionlayer
		player = new Player(game, name, this, new Sprite(Settings.playerBack), (TiledMapTileLayer) map.getLayers().get(1));
		player.setPosition(108, 60.0f);
		
		//assigning the stage
		stage = new Stage();
		txtbtn_inventory = new TextButton("Inventory", Settings.skin);
		txtbtn_inventory.setPosition(10, 10);
		txtbtn_inventory.addListener(new ClickListener(){

			//opens the craftin screen
			public void clicked(InputEvent input, float x, float y){
				player.craftingMode();
			}
			
		});
		
		stage.addActor(txtbtn_inventory);
		
		//assign healtstatus
		healthStatus = new StatusIndicator(player, false, 100, 100, Settings.skin, Settings.fullheart, Settings.halfheart);
		healthStatus.setColor(1, 0, 0, 1);
		healthStatus.setPosition(20, 520);
		stage.addActor(healthStatus);
		
		//assign hungerstatus
		hungerStatus = new StatusIndicator(player, true, 100, 100, Settings.skin, Settings.fullchickenleg, Settings.halfchickenleg);
		hungerStatus.setColor(1, 0.4f, 0, 1);
		hungerStatus.setPosition(20, 465);
		stage.addActor(hungerStatus);
		setHungerIndicator(9.0f);
		
		//assign bag
		player.getCharacter().getBag().setPosition(730, 550);
		stage.addActor(player.getCharacter().getBag());

	}
	
	/**
	 * if the user exits the crafting screen the resources in thebag are deleted and added again to save the crafted resources
	 * @param bag
	 */
	public void reinitialiseBag(Bag bag){
		
		bag.setPosition(730, 550);
		
		Array<Actor> actors = stage.getActors();
		for(int i=0; i<actors.size; i++){
			if(actors.get(i) instanceof Bag){
				actors.removeIndex(i);
				break;
			}
		}
		stage.addActor(bag);
	}
	
	
	/**
	 * is called when the screen shows up
	 */
	@Override
	public void show() {
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		game.font.setColor(1, 1, 1, 1);
		
		//assign InputMultiplexer for several InputProcessors
		InputMultiplexer ipmulti = new InputMultiplexer();
		ipmulti.addProcessor(stage);
		ipmulti.addProcessor(player);
		Gdx.input.setInputProcessor(ipmulti);
		
	}

	/**
	 * called every frame, clears the whole screen and renders everything new
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//set the renderer for the map
		renderer.setView(camera);
		renderer.render(background);
		
		hunger += delta;
		if(hunger >= hungerIndicator){
			hungerStatus.setStatus(player.getCharacter().decreaseHungerDef());
			healthStatus.setStatus(player.getCharacter().getHealth());
			hunger = 0;
		}
		
		stage.act(delta);
		stage.draw();
		
		game.batch.begin();
		player.draw(game.batch);
		
		updateCamera();
		
		game.font.draw(game.batch, player.getName(), player.getX()-player.getName().length()*(int)(player.getName().length()/3.5), player.getY()+player.getHeight()+20);
		game.batch.end();
		
	}
	
	/**
	 * updates the camera and the viewport, also regulates that the camera does not move out of the map
	 */
	private void updateCamera(){
		// scroll so that the player is in the center
		camera.position.x = (int)(player.getX()+player.getWidth()/2);
		camera.position.y = (int)(player.getY()+player.getHeight());
		
		// do not let the camera show places, where there is no map
		if(camera.position.x < 450){
			camera.position.x = 450;
		}else if(camera.position.x > (5325*2)-450){
			camera.position.x = (5325*2)-450;
		}
		
		if(camera.position.y < 300){
			camera.position.y = 300;
		}else if(camera.position.y > (5325*2)-300){
			camera.position.y = (5325*2)-300;
		}

		
		camera.update();
	}

	/**
	 * called if the window is resized, not used yet
	 */
	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = height;
		camera.viewportWidth = width;
		camera.update();
	}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		renderer.dispose();
		map.dispose();
		player.getTexture().dispose();
		stage.dispose();
	}
	
	/**
	 * sets how fast we get hungry
	 * @param hi
	 */
	public void setHungerIndicator(float hi){
		this.hungerIndicator = hi;
	}
	
	/**
	 * @return the initial player
	 */
	public Player getPLayer(){
		return this.player;
	}
	
	/**
	 * sets the screen to the final one --> true: found the end, false: died
	 * @param managed
	 */
	public void endGame(boolean managed){
		this.dispose();
		if(managed) game.setScreen(new FinalScreen(game, mainmenu, "CONGRATULATIONS"));
		else game.setScreen(new FinalScreen(game, mainmenu, "GAME OVER"));
	}


}
