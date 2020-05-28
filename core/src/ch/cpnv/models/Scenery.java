package ch.cpnv.models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

import ch.cpnv.kevangrywirds.KevAngryWirds;

public final class Scenery {
    private static final int BLOCK_SIZE = 45;

    private ArrayList<PhysicalObject> scene;

    public Scenery(){
        scene = new ArrayList<PhysicalObject>();

        addFloorBoxes();
        addTnts();
        addPigs();
    }

    /**
     * Add one piece of scenary
     *
     * @param el
     */
    public void addElement(PhysicalObject el) {
        ChangeYIfColliding(el);
        scene.add(el);
    }

    public void addFloorBoxes(){
        for (int i = 10; i < KevAngryWirds.WORLD_WIDTH / BLOCK_SIZE; i++) {
            addElement(new Block(new Vector2(i * BLOCK_SIZE, KevAngryWirds.FLOOR_HEIGHT)));
        }
    }

    public void addTnts(){
        Random r = new Random();
        int low = 500;
        int high = 1500;

        for (int i = 0; i <= 4; i++) {
            addElement(new Tnt(new Vector2(r.nextInt(high-low) + low, (float) (KevAngryWirds.WORLD_HEIGHT / 6))));
        }
    }

    public void addPigs(){
        Random r = new Random();
        int low = 500;
        int high = 1500;

        for (int i = 0; i < 3; i++) {
            addElement(new Pig(new Vector2(r.nextInt(high-low) + low, (float) (KevAngryWirds.WORLD_HEIGHT / 6))));
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

    public void ChangeYIfColliding(PhysicalObject p)
    {
        for(PhysicalObject alreadyExistingP : scene ) {
            if(p.collidesWith(alreadyExistingP)) {
                p.setY(alreadyExistingP.getY() + alreadyExistingP.getHeight()-5);
            }
        }
    }
}
