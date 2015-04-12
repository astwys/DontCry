package com.game;

import java.awt.Label;

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
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

public class PlayScreen implements Screen {

	int x = 0;
	
	private DontCry game;
	
	//for the map
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	//for the HUD
	private Stage stage;
	public static Skin skin;
	private Image[] fullhearts = new Image[10];
	private Image halfheart;
	private Image[] fullchickenlegs = new Image[10];
	private Image halfchickenleg;
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
		player = new Player(game, this, new Sprite(new Texture("../core/assets/player/p_back.png")), (TiledMapTileLayer) map.getLayers().get(1));
		player.setPosition(208, 20.8f);
		
		//assigning the stage
		skin = new Skin(new FileHandle("../core/assets/skins/HUD/uiskin.json"));
		stage = new Stage();
		txtbtn_inventory = new TextButton("Inventory", skin);
		txtbtn_inventory.setPosition(10, 10);
		txtbtn_inventory.addListener(new ClickListener(){

			public void clicked(InputEvent input, float x, float y){
				player.craftingMode();
			}
			
		});
		
		stage.addActor(txtbtn_inventory);
		
		//assign files for hearts
		Texture heart = new Texture(new FileHandle("../core/assets/icons/hearts/fullheart.png"));
		int x = 10;
		int y = 530;
		for(int i=0; i<fullhearts.length; i++){
			fullhearts[i] = new Image(heart);
			fullhearts[i].setPosition(x, y);
			stage.addActor(fullhearts[i]);
			x += 40;
		}
		//asign files for chickenlegs
		Texture leg = new Texture(new FileHandle("../core/assets/icons/chickenlegs/fullchickenleg.png"));
		x = 10;
		y = 470;
		for(int i=0; i<fullchickenlegs.length; i++){
			fullchickenlegs[i] = new Image(leg);
			fullchickenlegs[i].setPosition(x, y);
			stage.addActor(fullchickenlegs[i]);
			x += 40;
		}
		
		//assign healtstatus
		healthStatus = new StatusIndicator(100, 100, skin);
		healthStatus.setColor(1, 0, 0, 1);
		healthStatus.setPosition(20, 555);
		stage.addActor(healthStatus);
		
		//assign hungerstatus
		hungerStatus = new StatusIndicator(100, 100, skin);
		hungerStatus.setColor(1, 0.4f, 0, 1);
		hungerStatus.setPosition(20, 500);
		stage.addActor(hungerStatus);
		
		//assign InputMultiplexer for several InputProcessors
		InputMultiplexer ipmulti = new InputMultiplexer();
		ipmulti.addProcessor(stage);
		ipmulti.addProcessor(player);
		Gdx.input.setInputProcessor(ipmulti);
		
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
		renderer.render();
		
		hunger += delta;
		if(hunger >= 10.0f){
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
	
	private void deleteHeartsAndLegs(Array<Actor> actors){
		for(int i=0; i<actors.size; i++){
			if(actors.get(i) instanceof Object){
				
			}
		}
	}

}
