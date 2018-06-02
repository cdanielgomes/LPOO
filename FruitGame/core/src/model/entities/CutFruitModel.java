package model.entities;

import view.entities.EntityView.Fruits;

public class CutFruitModel extends EntityModel {
   Fruits fruits;
    /**
     * Constructs a model with a position and a rotation.
     *
     * @param x        The x-coordinate of this entity in meters.
     * @param y        The y-coordinate of this entity in meters.
     * @param rotation The current rotation of this entity in radians.
     */
    public CutFruitModel(float x, float y, float rotation, Fruits fruit) {
        super(x, y, rotation);
        this.fruits = fruit;
    }

    public Fruits getFruits() {
        return fruits;
    }
}
