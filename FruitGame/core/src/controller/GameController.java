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
import com.mygdx.game.MyFruitGame;


import java.util.Iterator;
import java.util.List;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.html.parser.Entity;

import controller.entities.CutFruitBody;
import controller.entities.FruitBody;
import controller.entities.LimitBody;
import model.GameModel;
import model.entities.CutFruitModel;
import model.entities.EntityModel;
import model.entities.FruitModel;
import model.entities.LimitModel;
import view.entities.EntityView;

import static view.GameView.PPM;


/**
 * Controls the physics aspect of the game.
 */
public class GameController implements ContactListener {
    /**
     * Accumulator used to calculate the simulation step.
     */
    private float accumulator;
     /**
     * Gravity of the world
     */
    private float GRAVITY = -13f;
    /**
     * Max velocity in the x-axis
     */
    private int MAXVELOCITY = 10;

    /**
     * The singleton instance of this controller
     */
    private static GameController instance;
 /**
     * Variable used to calculate random values
     */
    Random random = new Random();

    /**
     * The physics world controlled by this controller.
     */
    private World world;

    /**
     * Game Controller constructor. Initialize the world and all bodies
     */

    private GameController() {
        world = new World(new Vector2(0, GRAVITY), true);

        createBodies();

        new LimitBody(world, GameModel.getInstance().getTop(), Gdx.graphics.getWidth(), 1);
        new LimitBody(world, GameModel.getInstance().getRight(), 1, Gdx.graphics.getHeight());
        new LimitBody(world, GameModel.getInstance().getLeft(), 1, Gdx.graphics.getHeight());

        world.setContactListener(this);
    }

    /**
     * Create fruit bodies
     */

    private void createBodies() {
        List<FruitModel> kapa = GameModel.getInstance().getFruits();

        for (FruitModel fruits : kapa) {
            if (!fruits.isThrowned())
                new FruitBody(world, fruits);
        }
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

    /**
     * 
     * Calculate the impulse vector 
     * 
     * @param body Body that will gain velocity
     * @return Vector with velocity to be applied
     */

    private Vector2 impulse(Body body) {
        float x, y;

        if ((Gdx.graphics.getWidth() / 2) * PPM > body.getPosition().x)
            x = MAXVELOCITY + random.nextInt(MAXVELOCITY);

        else if ((Gdx.graphics.getWidth() / 2) * PPM < body.getPosition().x)
            x = (MAXVELOCITY + random.nextInt(MAXVELOCITY)) * -1;

        else {

            if (random.nextBoolean())
                x = (random.nextInt(MAXVELOCITY) + MAXVELOCITY) * -1;

            else
                x = 2 + random.nextInt(MAXVELOCITY);

        }


        //  y = random.nextInt(60 - 30) + 30;
        y = 30;


        return new Vector2(x, y);
    }

     /**
     * Apply a linear velocity and rotation the sliced fruit
     * 
     * @param body Body will gain velocity
     */
    private void cutMove(Body body) {
        Vector2 impulse = new Vector2(0, -12);
        body.setLinearVelocity(impulse);
        body.setAngularVelocity(12);
    }

    /**
     * Apply a linear velocity to the body
     * 
     * @param body Body will gain velocity
     */
    private void bodyMove(Body body) {


        Vector2 impulse = new Vector2(impulse(body));
        body.setLinearVelocity(impulse);


    }

     /**
     * Function that update all the bodies position in the world. Delete bodies if they are not 
     * on the screen
     * 
     * @param delta time in seconds since the last render
     */
    public void update(float delta) {


        Array<Body> bodies = new Array<Body>();

        world.getBodies(bodies);


        float frameTime = Math.min(delta, 0.25f);
        accumulator += frameTime;
        while (accumulator >= 1 / 60f) {
            world.step(1 / 60f, 6, 2);
            accumulator -= 1 / 60f;
        }


        for (Body b : bodies) {

            if ((b.getUserData() instanceof CutFruitModel)) {
                cutMove(b);

                ((EntityModel) b.getUserData()).setPosition(b.getPosition().x, b.getPosition().y);
                ((EntityModel) b.getUserData()).setRotation(b.getAngle());

                if (((CutFruitModel) b.getUserData()).getY() < -5) {
                    world.destroyBody(b);
                }
            }

            if ((b.getUserData() instanceof FruitModel)) {
                FruitModel f = (FruitModel) b.getUserData();

                if (!(f.isThrowned())) {
                    bodyMove(b);
                    f.setThrowned();
                }

                ((EntityModel) b.getUserData()).setPosition(b.getPosition().x, b.getPosition().y);
                ((EntityModel) b.getUserData()).setRotation(b.getAngle());

                if (f.getY() < -5) {
                    if (!(f.getFruit() == EntityView.Fruits.BOMB || f.getFruit() == EntityView.Fruits.SPECIAL))
                        GameModel.getInstance().deleteLife();
                    world.destroyBody(b);
                }

                if (f.isCut()) {
                    createCutBodies(b);
                    world.destroyBody(b);
                }
            }
        }


        createBodies();
    }

    /**
     * Create sliced fruit
     * 
     * @param b Body will gain velocity
     */
    private void createCutBodies(Body b) {

        List<CutFruitModel> kapa = GameModel.getInstance().getCutFruits();

        for (CutFruitModel fruits : kapa) {

            new CutFruitBody(world, fruits, b.getFixtureList().get(0).getShape().getRadius(), b.getFixtureList().get(0).getDensity());
            new CutFruitBody(world, fruits, b.getFixtureList().get(0).getShape().getRadius(), b.getFixtureList().get(0).getDensity());


        }

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
     /**
     * Return the world
     *
     * @return the world  
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * Null the controller instance
     */
    public void dispose() {

        instance = null;
    }
}