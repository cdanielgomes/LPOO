package model.entities;

import view.entities.EntityView.Fruits;

public class CutFruitModel extends EntityModel {
    
    /**
     * Fruit type
     */
   Fruits fruits;

   /**
     * Boolean used to check which half 
     * 
     * */

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

    /**
     * Return the type of the fruit 
     * @return type of the fruit
     * */
    public Fruits getFruits() {
        return fruits;
    }
   /**
     * Return a boolean to choose a side of the fruit
     * @return true for a side, fals for another
     * */
    public boolean getHalf() {
        return i;
    }
}
