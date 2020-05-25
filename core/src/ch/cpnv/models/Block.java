package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;

public class Block extends PhysicalObject {
    private static final String PICNAME = "block.png";
    private static final int WIDTH = 45;
    private static final int HEIGHT = 45;

    public Block(Vector2 position) {
        super(position, WIDTH, HEIGHT, PICNAME);
    }
}



