package model.entities;

public class LimitModel extends EntityModel {
    /**
     * Constructs a model with a position and a rotation.
     *
     * @param x        The x-coordinate of this entity in meters.
     * @param y        The y-coordinate of this entity in meters.
     * @param rotation The current rotation of this entity in radians.
     */
    public LimitModel(float x, float y, float rotation) {
        super(x, y, rotation);
    }
}
