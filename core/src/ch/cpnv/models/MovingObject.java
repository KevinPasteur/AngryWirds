package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;

public abstract class MovingObject extends PhysicalObject {

    public Vector2 speed;

    public MovingObject(Vector2 position, float width, float height, String picname, Vector2 speed) {
        super(position, width, height, picname);
        this.speed = speed;
    }

    public void move(int dt){

    }

    public abstract void accelerate(float dt);
}
