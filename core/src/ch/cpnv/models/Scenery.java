package ch.cpnv.models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.cpnv.kevangrywirds.KevAngryWirds;

public final class Scenery {
    public static final int BLOCK_SIZE = 30;

    private ArrayList<PhysicalObject> scene;

    public Scenery(){
        scene = new ArrayList<PhysicalObject>();
    }


    /**
     * Add one piece of scenary
     *
     * @param el
     */
    public void addElement(PhysicalObject el) {
        scene.add(el);
    }

    /**
     * Lay down a line of blocks to act a floor to the scene
     */
    public void addFloor() {
        for (int i = 5; i < KevAngryWirds.WORLD_WIDTH / BLOCK_SIZE; i++) {
            addElement(new PhysicalObject(new Vector2(i * BLOCK_SIZE, KevAngryWirds.FLOOR_HEIGHT), BLOCK_SIZE, BLOCK_SIZE, "block.png"));
        }
    }

    /**
     * Render the whole scenary
     *
     * @param batch
     */
    public void draw(Batch batch) {
        for (PhysicalObject p : scene) p.draw(batch);
    }

}
