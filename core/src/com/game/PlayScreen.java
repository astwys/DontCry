package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
	
	public PlayScreen(final DontCry dontcry){
		game = dontcry;
		
		//stuff for rendering the tiledmap
		map = new TmxMapLoader().load("../core/assets/maps/map1/map1.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1.5f, game.batch);
		camera = new OrthographicCamera();
		
		//create and initialise the player with the collisionlayer
		player = new Player(new Sprite(new Texture("../core/assets/player/p_back.png")), (TiledMapTileLayer) map.getLayers().get(1));
		player.setPosition(200, 10);
		
		//saving important map properties
		tileWidth = ((TiledMapTileLayer) map.getLayers().get(1)).getTileWidth(); 
		tileHeight = ((TiledMapTileLayer) map.getLayers().get(1)).getTileHeight();
		
		//set the player to the InputProcessor
		Gdx.input.setInputProcessor(player);
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
		
		updateCamera();
		
		game.font.draw(game.batch, player.getName(), player.getX()-5, player.getY()+player.getHeight()+20);
		game.batch.end();
		
		
	}
	
	private void updateCamera(){
		// scroll so that the player is in the center
		camera.position.x = player.getX()-player.getWidth()/2;
		camera.position.y = player.getY()-player.getHeight()/2;
		
		// do not let the camera show places, where there is no map
		if(camera.position.x < 450){
			camera.position.x = 450;
		}else if(camera.position.x > width*tileWidth - 450){
			camera.position.x = width*tileWidth - 450;
		}
				
//		if(camera.position.y < 300){
//			camera.position.y = 300;
//		}else if(camera.position.y > height*tileHeight - 300){
//			camera.position.y = height*tileHeight - 300;
//		}
		
		if(camera.position.y < 300){
			camera.position.y = 300;
		}else if(camera.position.y > (tileHeight) * 255 - 300){
			camera.position.y = (tileHeight) * 255 - 300;
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
