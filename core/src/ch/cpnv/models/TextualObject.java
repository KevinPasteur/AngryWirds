package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;

public abstract class TextualObject extends PhysicalObject {

    protected String word;
    private String text;

    public TextualObject(Vector2 position, float width, float height, String picname, String text) {
        super(position, width, height, picname);
        this.text = text;
    }

    protected String getWord(){
        return word;
    }

    public String getText() {return text;}
}
