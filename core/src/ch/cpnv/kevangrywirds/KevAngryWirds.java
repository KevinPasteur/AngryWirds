package ch.cpnv.kevangrywirds;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;


import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.utils.TimeUtils;


import ch.cpnv.models.*;
import sun.awt.AWTAccessor;

public class KevAngryWirds extends ApplicationAdapter implements InputProcessor {

	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
    public static final int FLOOR_HEIGHT = 120;

	private SpriteBatch batch;
	private Texture background;
	private Bird birdy;
	private Wasp waspy;
	private Scenery scene;

	private OrthographicCamera camera;

	public static long startTime = TimeUtils.millis();



	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("background.jpg"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();



		scene = new Scenery();
		birdy = new Bird(150, 130);
		waspy = new Wasp(new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT / 2), new Vector2(20, 20));


	}

	@Override
	public void render () {
		update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);


		waspy.draw(batch);

		birdy.draw(batch);
		scene.draw(batch);
		batch.end();
		Gdx.input.setInputProcessor(this);
	}

	public void update(){
		float dt = Gdx.graphics.getDeltaTime();

		//birdy.move(dt);
		waspy.move(dt);
	}

	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}


	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		birdy.setPosition((screenX/((float)Gdx.graphics.getWidth()/ WORLD_WIDTH)),(WORLD_HEIGHT-screenY/((float)Gdx.graphics.getHeight()/WORLD_HEIGHT)));
		System.out.println((float)Gdx.graphics.getWidth()/WORLD_WIDTH);
		System.out.println(Gdx.graphics.getWidth());
		System.out.println(WORLD_WIDTH);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
