package controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;


import java.util.List;

import java.util.ArrayList;
import java.util.Random;

import controller.entities.FruitBody;
import model.GameModel;
import model.entities.EntityModel;
import model.entities.FruitModel;

import static view.GameView.PPM;


/**
 * Controls the physics aspect of the game.
 */
public class GameController implements ContactListener {
    float rend = 0.5f;
    /**
     * Accumulator used to calculate the simulation step.
     */
    private float accumulator;

    private float GRAVITY = -9f;

    private  int MAXVELOCITY = 7;
    /**
     * The rotation speed in radians per second.
     */
    private static final float ROTATION_SPEED = 5f;

    private boolean throwElem = false;

    /**
     * The singleton instance of this controller
     */
    private static GameController instance;


    private  ArrayList<FruitModel> fruits = new ArrayList<FruitModel>();

    Random random = new Random();

    /**
     * The physics world controlled by this controller.
     */
    private final World world;


    private GameController(){
        world = new World(new Vector2(0,GRAVITY), true);
        List<FruitModel> kapa = GameModel.getInstance().getFruits();


        for (FruitModel fruits : kapa){
            new FruitBody(world, fruits);
        }

        world.setContactListener(this);
    }

    /**
     * Returns a singleton instance of a game controller
     *
     * @return the singleton instance
     */
    public static GameController getInstance() {
        if (instance == null)
            instance = new GameController();
        return instance;
    }

private Vector2 impulse(Body body){
        float x, y;

        System.out.println("X,Y =  " + body.getPosition());
        if((Gdx.graphics.getWidth() /2)*PPM > body.getPosition().x)
            x =MAXVELOCITY  + random.nextInt(MAXVELOCITY );

        else if((Gdx.graphics.getWidth()/2)*PPM < body.getPosition().x)
            x = (MAXVELOCITY + random.nextInt(MAXVELOCITY )) * -1;

        else{

           if(random.nextBoolean())
               x =  (random.nextInt(MAXVELOCITY) + MAXVELOCITY) * -1;

           else
               x = 2 + random.nextInt(MAXVELOCITY);

        }


            y = random.nextInt(23-2) + 2;



    return  new Vector2(x, y);
}

public World getWorld(){
        return  world;
}

private void bodyMove(Body body){


    Vector2 impulse = new Vector2(impulse(body));
    body.setLinearVelocity(impulse);


}


   public void update(float delta){


       Array<Body> bodies = new Array<Body>();

       world.getBodies(bodies);


       float frameTime = Math.min(delta, 0.25f);
       accumulator += frameTime;
       while (accumulator >= 1/60f) {
           world.step(1/60f, 6, 2);
           accumulator -= 1/60f;
       }

        for(Body b : bodies) {

            if (!throwElem)
                bodyMove(b);
            ((EntityModel) b.getUserData()).setPosition(b.getPosition().x, b.getPosition().y);
            ((EntityModel) b.getUserData()).setRotation(b.getAngle());
        }
       throwElem = true;



   }


    /**
     * Called when two fixtures begin to touch.
     *
     * @param contact
     */
    @Override
    public void beginContact(Contact contact) {

    }

    /**
     * Called when two fixtures cease to touch.
     *
     * @param contact
     */
    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
