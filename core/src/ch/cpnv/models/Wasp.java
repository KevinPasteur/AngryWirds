package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;
import ch.cpnv.kevangrywirds.KevAngryWirds;

public class Wasp extends MovingObject {

    private static final float AGITATION = 100;
    private static final String PICNAME = "wasp.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private static int ty = 5;
    private static int tx = 5;

    public Wasp(Vector2 position, Vector2 speed){
        super(position, WIDTH, HEIGHT, PICNAME, speed);

    }
    public void accelerate(float dt){
        Vector2 folly = new Vector2(getX()/KevAngryWirds.WORLD_WIDTH,getY()/KevAngryWirds.WORLD_HEIGHT);
        speed = speed.add(folly.scl(AGITATION+dt));
    }

    public void move(){
        if (this.getY() < getRandomNumberInRange(0, 100)) {
            this.ty = 5;
        }
        else if (this.getY() > getRandomNumberInRange(200, 300))
        {
            this.ty = -5;
        }

        if (this.getX() < getRandomNumberInRange(0, 300)) {
            this.tx = 5;
        }
        else if (this.getX() > getRandomNumberInRange(200, 700))
        {
            this.tx = -5;
        }
        this.translate(this.tx,this.ty);
        //System.out.println(getRandomNumberInRange(5, 10));

        //System.out.println(this.tx);
        //System.out.println(this.ty);
        //System.out.println(getX());
        //System.out.println(getY());
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

