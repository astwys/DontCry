package com.game;

import com.badlogic.gdx.Gdx;
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

public class PlayScreen implements Screen {

	private DontCry game;
	
	//for the map
	private TiledMap map;
	private float tileWidth, tileHeight;
	private int width = 900, height = 600;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	//player
	private Player player;
	private Sprite[] fullhearts = new Sprite[10];
	private Sprite halfheart;
	
	public PlayScreen(final DontCry dontcry){
		game = dontcry;
		
		//stuff for rendering the tiledmap
		map = new TmxMapLoader().load("../core/assets/maps/map1/map1.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1.3f, game.batch);
		camera = new OrthographicCamera();
		
		//create and initialise the player with the collisionlayer
		player = new Player(new Sprite(new Texture("../core/assets/player/p_back.png")), (TiledMapTileLayer) map.getLayers().get(1));
		player.setPosition(208, 20.8f);
		
		//saving important map properties
		tileWidth = ((TiledMapTileLayer) map.getLayers().get(1)).getTileWidth(); 
		tileHeight = ((TiledMapTileLayer) map.getLayers().get(1)).getTileHeight();
		
		//set the player to the InputProcessor
		Gdx.input.setInputProcessor(player);
		
		//assign files for hearts
		Texture heart = new Texture(new FileHandle("../core/assets/icons/hearts/fullheart.png"));
		int x = 10;
		int y = 200;
		for(int i=0; i<fullhearts.length; i++){
			fullhearts[i] = new Sprite(heart);
			fullhearts[i].setPosition(x, y);
			x += 40;
		}
		
	}
	
	@Override
	public void show() {
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		game.font.setColor(1, 1, 1, 1);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//set the renderer for the map
		renderer.setView(camera);
		renderer.render();
		
		game.batch.begin();
		player.draw(game.batch);
		
		for(int i=0; i*10<player.getCharacter().getHealth(); i++){
			fullhearts[i].draw(game.batch);
		}
		
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
	}

}
