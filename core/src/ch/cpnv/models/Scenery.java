package ch.cpnv.models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.cpnv.kevangrywirds.KevAngryWirds;

public final class Scenery {
    public static final int BLOCK_SIZE = 30;

    private ArrayList<PhysicalObject> scene;
    private ArrayList<Tnt> ListTnt;
    private ArrayList<Block> ListBlock;



    public Scenery(){

        scene = new ArrayList<PhysicalObject>();

        ListTnt = new ArrayList<Tnt>();
        for (int i = 0; i < 5; i++) {
            tnt = new Tnt(new Vector2(WORLD_WIDTH / (i+1), (float) (WORLD_HEIGHT/5.5)));
            ListTnt.add(tnt);
        }

        ListBlock= new ArrayList<Block>();
        for (int i = 0; i < 30; i++) {
            block = new Block(new Vector2((float) (WORLD_WIDTH-(i*45)), WORLD_HEIGHT/7));
            ListBlock.add(block);
        }
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
