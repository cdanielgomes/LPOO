package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Life extends EntityModel {


    private final int position;

    /**
     * Constructs a model with a position and a rotation.
     *
     * @param x        The x-coordinate of this entity in meters.
     * @param y        The y-coordinate of this entity in meters.
     * @param rotation The current rotation of this entity in radians.
     * @param position Position in the array
     */
    public Life(float x, float y, float rotation, int position) {
        super(x, y, rotation);
        this.position = position;

    }

}
