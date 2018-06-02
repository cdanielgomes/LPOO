package model.entities;

import view.entities.EntityView.Fruits;

public class CutFruitModel extends EntityModel {
   Fruits fruits;
   private final boolean i;
    /**
     * Constructs a model with a position and a rotation.
     *
     * @param x        The x-coordinate of this entity in meters.
     * @param y        The y-coordinate of this entity in meters.
     * @param rotation The current rotation of this entity in radians.
     */
    public CutFruitModel(boolean i, float x, float y, float rotation, Fruits fruit) {
        super(x, y, rotation);
        this.fruits = fruit;
        this.i = i;
    }

    public Fruits getFruits() {
        return fruits;
    }

    public boolean getHalf() {
        return i;
    }
}
