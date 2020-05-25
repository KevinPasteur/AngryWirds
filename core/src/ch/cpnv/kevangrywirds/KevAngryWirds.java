package ch.cpnv.kevangrywirds;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Random;

import ch.cpnv.models.*;

public class KevAngryWirds extends ApplicationAdapter {

	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
    public static final int FLOOR_HEIGHT = 300;
	public static Random alea;

	private SpriteBatch batch;
	private Texture background;
	private Bird birdy;
	private Wasp waspy;
	private Tnt tnt;
	private Block block;

	private OrthographicCamera camera;
	private ArrayList<Tnt> ListTnt;
	private ArrayList<Block> ListBlock;

	public static long startTime = TimeUtils.millis();

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("background.jpg"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();

		birdy = new Bird(150, 130);
		waspy = new Wasp(new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT / 2), new Vector2(20, 20));


	}

	@Override
	public void render () {
		update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
		birdy.draw(batch);
		waspy.draw(batch);
		Scenery.draw(batch);
		batch.end();
	}

	public void update(){
		float dt = Gdx.graphics.getDeltaTime();
		birdy.move(dt);
		waspy.move(dt);
	}

	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
