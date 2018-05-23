package controller.entities;

import com.badlogic.gdx.physics.box2d.World;
import model.entities.EntityModel;

public class FruitBody extends EntityBody {

    public FruitBody(World world, EntityModel model ){
        super(world, model);
        createFixture(body, 324, 23, 12,12);
    }

}
