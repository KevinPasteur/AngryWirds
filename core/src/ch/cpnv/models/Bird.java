package ch.cpnv.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public final class Bird extends MovingObject {

    private static final String PICNAME = "bird.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    public static final float v0=20;
    public static float time;

    MathUtils math;


    public Bird(float posX,float posY){
        super(new Vector2(posX,posY), WIDTH, HEIGHT, PICNAME, new Vector2(0,0));
    }
    public void accelerate(float dt){
        speed.y -= 50*dt*2;
    }

    public void move(float dt){
        time+=dt;
        this.translate(speed.x*dt,speed.y*dt);

    }

}
