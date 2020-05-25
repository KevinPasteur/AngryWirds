package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;

public abstract class TextualObject extends PhysicalObject {

    protected String word;

    public TextualObject(Vector2 position, float width, float height, String picname) {
        super(position, width, height, picname);
    }

    protected String getWord(){

        return word;
    }
}
