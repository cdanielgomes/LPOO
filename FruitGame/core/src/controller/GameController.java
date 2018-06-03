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

import javax.swing.text.html.parser.Entity;

import controller.entities.CutFruitBody;
import controller.entities.FruitBody;
import controller.entities.LimitBody;
import model.GameModel;
import model.entities.CutFruitModel;
import model.entities.EntityModel;
import model.entities.FruitModel;
import model.entities.LimitModel;

import static view.GameView.PPM;


/**
 * Controls the physics aspect of the game.
 */
public class GameController implements ContactListener {
    /**
     * Accumulator used to calculate the simulation step.
     */
    private float accumulator;

    private float GRAVITY = -13f;

    private int MAXVELOCITY = 10;
    /**
     * The rotation speed in radians per second.
     */
    private static final float ROTATION_SPEED = 5f;

    private boolean throwElem = false;

    /**
     * The singleton instance of this controller
     */
    private static GameController instance;


    private ArrayList<FruitModel> fruits = new ArrayList<FruitModel>();

    Random random = new Random();

    /**
     * The physics world controlled by this controller.
     */
    private final World world;


    private GameController() {
        world = new World(new Vector2(0, GRAVITY), true);

        createBodies();

        new LimitBody(world, GameModel.getInstance().getTop(), Gdx.graphics.getWidth(), 1);
        new LimitBody(world, GameModel.getInstance().getRight(), 1, Gdx.graphics.getHeight());
        new LimitBody(world, GameModel.getInstance().getLeft(), 1, Gdx.graphics.getHeight());


        world.setContactListener(this);
    }

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
        y = 30 ;


        return new Vector2(x, y);
    }

    private void cutMove(Body body) {
        Vector2 impulse = new Vector2(0, -12);
        body.setLinearVelocity(impulse);
        body.setAngularVelocity(12);
    }

    private void bodyMove(Body body) {


        Vector2 impulse = new Vector2(impulse(body));
        body.setLinearVelocity(impulse);


    }


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

                if (((CutFruitModel)b.getUserData()).getY() < -20) {
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

                if (f.getY() < -20) {
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

    public World getWorld() {
        return this.world;
    }

    public void dispose(){
        world.dispose();
    }
}