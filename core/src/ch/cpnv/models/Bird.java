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

    }

    public void resetPos(float dt){
        //System.out.println(this.getY());
        if(this.getY() < 0) {
            this.setPosition(150, 130);
            this.move(dt);
        }
    }

    public void move(float dt){
        time+=dt;
        this.translate(this.vx(),this.vy(time));
    }

    public void fire(){

    }

    private float vx(){
        return v0*math.cosDeg(70);
    }

    private float vy(float dt){
        return v0*math.sinDeg(70)-10*dt;
    }
}
