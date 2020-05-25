package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Random;
import ch.cpnv.kevangrywirds.KevAngryWirds;

public class Wasp extends MovingObject {

    private static final float AGITATION = 100;
    private static final String PICNAME = "wasp.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    Vector2 cycleLength = new Vector2(1300,900); // time (1000 = 1sec)
    Vector2 cycleScale = new Vector2(KevAngryWirds.WORLD_WIDTH / 3-getWidth(), KevAngryWirds.WORLD_HEIGHT / 4); // zone where wasp moves from centerPo

    Vector2 centerPos;



    public Wasp(Vector2 position, Vector2 speed){
        super(position, WIDTH, HEIGHT, PICNAME, speed);
        centerPos = position;

    }
    public void accelerate(float dt){
        Vector2 folly = new Vector2(getX()/KevAngryWirds.WORLD_WIDTH,getY()/KevAngryWirds.WORLD_HEIGHT);
        speed = speed.add(folly.scl(AGITATION+dt));
    }


    public void move(float dt) {
        long globalCounter = TimeUtils.timeSinceMillis(KevAngryWirds.startTime);
        float x  = (float) Math.sin(globalCounter/cycleLength.x) * cycleScale.x + centerPos.x;
        float y = (float) Math.cos(globalCounter/cycleLength.y) * cycleScale.y + centerPos.y;

        this.setPosition(x, y);
    }

}

