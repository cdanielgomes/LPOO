package controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

import controller.entities.FruitBody;
import model.GameModel;


/**
 * Controls the physics aspect of the game.
 */
public class GameController implements ContactListener {
    /**
     * The arena width in meters.
     */
    public static final int ARENA_WIDTH = 100;

    /**
     * The arena height in meters.
     */
    public static final int ARENA_HEIGHT = 50;

    /**
     * The rotation speed in radians per second.
     */
    private static final float ROTATION_SPEED = 5f;


    /**
     * The singleton instance of this controller
     */
    private static GameController instance;




    /**
     * The physics world controlled by this controller.
     */
    private final World world;

    private final FruitBody watermelon;


    private GameController(){
        world = new World(new Vector2(0,-2), true);

        watermelon = new FruitBody(world, GameModel.getInstance().getFruit());


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
