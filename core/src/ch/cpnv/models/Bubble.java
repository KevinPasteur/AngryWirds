package ch.cpnv.models;

import com.badlogic.gdx.math.Vector2;

import javax.xml.datatype.Duration;

public class Bubble extends TextualObject {
    private Duration duration;

    public Bubble(Vector2 position, float width, float height, String picname) {
        super(position, width, height, picname);
    }
}
