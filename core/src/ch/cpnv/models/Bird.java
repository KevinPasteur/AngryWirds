package ch.cpnv.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.concurrent.ConcurrentHashMap;

import ch.cpnv.kevangrywirds.KevAngryWirds;

public final class Bird extends MovingObject {

    private static final String PICNAME = "bird.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;

    public enum State{
        READY,
        AIMING,
        FLYING

    }
    private State state = State.READY;
    private Vector2 dragOffset;
    private Vector2 aimOrigin;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Bird(float posX, float posY){
        super(new Vector2(posX,posY), WIDTH, HEIGHT, PICNAME, new Vector2(0,0));
    }

    public void accelerate(float dt){speed.y += GRAVITY*dt;}

    public void startAim (Vector2 position){
        if(state == State.READY) {
            aimOrigin = position.cpy();
            dragOffset = position.sub(getX(), getY());
            state = State.AIMING;
        }

    }
    public void drag (Vector2 position){
        if(state == State.AIMING){
            //setPosition(position.x = dragOffset.x, position.y = dragOffset.y);
            setPosition((position.x-dragOffset.x),(position.y-dragOffset.y));
        }
    }
    public void launchFrom (Vector2 position){
        if(state == State.AIMING) {
            speed = aimOrigin.sub(position).scl(KevAngryWirds.SLINGSHOT_POWER);
            state = State.FLYING;
        }
    }

}
