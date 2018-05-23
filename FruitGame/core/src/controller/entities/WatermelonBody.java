package controller.entities;

import com.badlogic.gdx.physics.box2d.World;
import model.entities.EntityModel;

public class WatermelonBody extends EntityBody {

    public WatermelonBody(World world, EntityModel model ){
        super(world, model);
        createFixture(body, 324, 23, 12,12);
    }

}
