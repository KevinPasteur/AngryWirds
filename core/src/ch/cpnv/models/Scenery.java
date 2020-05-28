package ch.cpnv.models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ch.cpnv.kevangrywirds.KevAngryWirds;
import sun.awt.AWTAccessor;

public final class Scenery {
    public static final int BLOCK_SIZE = 30;

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
        scene.add(el);
    }

    public void addFloorBoxes(){
        for (int i = 5; i < KevAngryWirds.WORLD_WIDTH / BLOCK_SIZE; i++) {
            addElement(new PhysicalObject(new Vector2(i * BLOCK_SIZE, KevAngryWirds.FLOOR_HEIGHT), BLOCK_SIZE, BLOCK_SIZE, "block.png"));
        }
    }

    public void addTnts(){
        for (int i = 0; i <= 4; i++) {
            addElement(new Tnt(new Vector2(KevAngryWirds.WORLD_WIDTH / (i + 1), (float) (KevAngryWirds.WORLD_HEIGHT / 6))));
        }
    }

    public void addPigs(){
        for (int i = 0; i <= 5; i++) {
            Pig pig = new Pig(new Vector2(KevAngryWirds.WORLD_WIDTH / (i + 1), (float) (KevAngryWirds.WORLD_HEIGHT / 6)));

            for(PhysicalObject p : scene ) {
                if(isObjectXBetween(p, pig.getX(),pig.getX()+pig.getWidth())){
                    pig.setY(p.getY()+p.getHeight()-4);
                }
            }
            addElement(pig);
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

    public boolean isObjectXBetween(PhysicalObject object, float a, float b) {
        return (a < object.getX() + object.getWidth() && a > object.getX()) ||
                (b < object.getX() + object.getWidth() && b > object.getX());
    }

}
