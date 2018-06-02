package controller.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import model.entities.EntityModel;

public class CutFruitBody extends EntityBody {
    /**
     * Constructs a body representing a model in a certain world.
     *
     * @param world The world this body lives on.
     * @param model The model representing the body.
     */
   public CutFruitBody(World world, EntityModel model, float radius, float density) {
        super(world, model, BodyDef.BodyType.KinematicBody);

        createFixture(body, radius, density);

    }
}
