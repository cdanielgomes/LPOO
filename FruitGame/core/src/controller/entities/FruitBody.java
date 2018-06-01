package controller.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import model.entities.EntityModel;
import model.entities.FruitModel;

public class FruitBody extends EntityBody {

    public FruitBody(World world, EntityModel model ){
        super(world, model);

        if(model instanceof FruitModel){
            switch(((FruitModel) model).getFruit()){
                case WATERMELON:
                    createFixture(body, 1.5f/0.04f, 1.2f);
                    break;
                case ORANGE:
                    createFixture(body, 1.5f/0.04f, 0.02f);
                    break;
                case BANANA:
                    createFixture(body, 1.5f/0.04f, 0.54f);
                    break;
                case STRAW:
                    createFixture(body, 1.5f/0.04f, 1.5f);
                    break;
                case LEMON:
                    createFixture(body, 1.5f/0.04f, 0.2f);
                    break;
                case PEACH:
                    createFixture(body, 1.5f/0.04f, 1.1f);
                    break;
                case APPLE:
                    createFixture(body, 1.5f/0.04f, 0.4f);
                    break;
                case PLUM:
                    createFixture(body, 1.5f/0.04f, 0.4f);
                    break;
                    default:
                        break;

            }
        }
    }

    /**
     * Helper method to create a polygon fixture represented by a set of vertexes.
     * @param body The body the fixture is to be attached to.
     *                 easier to get them from a bitmap image.
     * @param density The density of the fixture. How heavy it is in relation to its area.
     */
    final void createFixture(Body body, float radius, float density ) {

        CircleShape polygon = new CircleShape();
        polygon.setRadius(radius);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygon;

        fixtureDef.density = density;
        fixtureDef.restitution = 0.7f;
        fixtureDef.friction = 0.5f;

        body.createFixture(fixtureDef);

        polygon.dispose();
    }

}
