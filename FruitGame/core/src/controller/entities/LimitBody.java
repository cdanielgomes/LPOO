package controller.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import model.entities.EntityModel;

import static view.GameView.PPM;

/**
 *
 * LimitBody Body class 
 * 
 */

public class LimitBody {

    /**
     * The Box2D body that supports this body.
     */
    final Body body;

    /**
     * Constructs a body representing a model in a certain world.
     *
     * @param world The world this body lives on.
     * @param model The model representing the body.
     */
    public LimitBody(World world, EntityModel model, float width, float height) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(model.getX()*PPM, model.getY()*PPM);
        bodyDef.angle = model.getRotation();

        body = world.createBody(bodyDef);
        body.setUserData(model);

        PolygonShape rectangle = new PolygonShape();

        rectangle.setAsBox(width*PPM,height*PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = rectangle;
        fixtureDef.density = .5f;      // how heavy is the ground
        fixtureDef.friction =  .5f;    // how slippery is the ground
        fixtureDef.restitution =  .5f; // how bouncy is the ground
      //  fixtureDef.filter.categoryBits = 2;
       // fixtureDef.filter.maskBits = 1;

        body.createFixture(fixtureDef);

        rectangle.dispose();
    }


}
