package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;

public class Pig extends TextualObject {
    private int points;
    private static final String PICNAME = "pig.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Pig(Vector2 position) {
        super(position, WIDTH, HEIGHT, PICNAME);
    }

    public void sayWord(){

    }


}
