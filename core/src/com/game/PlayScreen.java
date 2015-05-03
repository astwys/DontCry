package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.slot.Bag;

public class PlayScreen implements Screen {
	
	private DontCry game;
	
	//for the map
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private int[] background = {0, 1, 2};
	private int[] foreground = {3};
	
	//for the HUD
	private Stage stage;
	private TextButton txtbtn_inventory;
	private StatusIndicator healthStatus;
	private StatusIndicator hungerStatus;
	
	//player
	private Player player;
	private float hunger;
	
	
	public PlayScreen(final DontCry dontcry){
		game = dontcry;
		
		//stuff for rendering the tiledmap
		map = new TmxMapLoader().load("../core/assets/maps/map1/map1.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1.3f, game.batch);
		camera = new OrthographicCamera();
		
		//create and initialise the player with the collisionlayer
		player = new Player(game, this, new Sprite(new Texture("../core/assets/player/p_back.png")), (TiledMapTileLayer) map.getLayers().get(1), (TiledMapTileLayer) map.getLayers().get(2));
		player.setPosition(208, 20.8f);
		
		//assigning the stage
		stage = new Stage();
		txtbtn_inventory = new TextButton("Inventory", Settings.skin);
		txtbtn_inventory.setPosition(10, 10);
		txtbtn_inventory.addListener(new ClickListener(){

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
		
		//assign the bag to the stage
		player.getCharacter().getBag().setPosition(730, 550);
		stage.addActor(player.getCharacter().getBag());

	}
	
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

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//set the renderer for the map
		renderer.setView(camera);
		renderer.render(background);
		renderer.render(foreground);
		
		hunger += delta;
		if(hunger >= 9.0f){
			hungerStatus.setStatus(player.getCharacter().decreaseHungerDef());
			healthStatus.setStatus(player.getCharacter().getHealth());
			hunger = 0;
		}
		
		stage.act(delta);
		stage.draw();
		
		game.batch.begin();
		player.draw(game.batch);
		
		updateCamera();
		
		game.font.draw(game.batch, player.getName(), player.getX()-5, player.getY()+player.getHeight()+20);
		game.batch.end();
		
	}
	
	private void updateCamera(){
		// scroll so that the player is in the center
		camera.position.x = player.getX()+player.getWidth()/2;
		camera.position.y = player.getY()+player.getHeight();
		
		// do not let the camera show places, where there is no map
		if(camera.position.x < 450){
			camera.position.x = 450;
		}else if(camera.position.x > 5325 - 450){
			camera.position.x = 5325 - 450;
		}
		
		if(camera.position.y < 300){
			camera.position.y = 300;
		}else if(camera.position.y > 5325 - 300){
			camera.position.y = 5325 - 300;
		}

		
		camera.update();
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = height;
		camera.viewportWidth = width;
		camera.update();
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
		renderer.dispose();
		map.dispose();
		player.getTexture().dispose();
		stage.dispose();
	}
	public Player getPLayer(){
		return this.player;
	}


}
