package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;

public class Tnt extends PhysicalObject {

    private int negativePoints;
    private static final String PICNAME = "tnt.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Tnt(Vector2 position) {
        super(position, WIDTH, HEIGHT, PICNAME);
    }
}
