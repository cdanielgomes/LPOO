package controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import controller.entities.FruitBody;
import model.GameModel;
import model.entities.EntityModel;
import model.entities.FruitModel;


/**
 * Controls the physics aspect of the game.
 */
public class GameController implements ContactListener {

    /**
     * Accumulator used to calculate the simulation step.
     */
    private float accumulator;
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


    private  ArrayList<FruitModel> fruits = new ArrayList<FruitModel>();

    Random random = new Random();

    /**
     * The physics world controlled by this controller.
     */
    private final World world;


    private GameController(){
        world = new World(new Vector2(0,-9.8f), true);

        java.util.List<FruitModel> kapa = GameModel.getInstance().getFruits();

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


private void bodyMove(Body body){

    Vector2 impulse = new Vector2(0,20);

    Random n = new Random();

    body.applyLinearImpulse(impulse, body.getWorldCenter(), true);

}


   public void update(float delta){

       float frameTime = Math.min(delta, 0.25f);
       accumulator += frameTime;
       while (accumulator >= 1/60f) {
           world.step(1/60f, 6, 2);
           accumulator -= 1/60f;
       }

      com.badlogic.gdx.utils.Array<Body> bodies = new com.badlogic.gdx.utils.Array<Body>();
        world.getBodies(bodies);

        for(Body b : bodies){
            remove(b);
            bodyMove(b);
            ((EntityModel) b.getUserData()).setPosition(b.getPosition().x, b.getPosition().y);
            ((EntityModel) b.getUserData()).setRotation(b.getAngle());

        }

        if(GameModel.getInstance().getFruits().isEmpty()){
            createNewFruits();
            GameModel.getInstance().setFruitModels(fruits);
            fruits.clear();
        }

   }

   public void createNewFruits(){

       for(int i = 0; i < 1; i++){
           fruits.add(new FruitModel(random.nextInt(Gdx.graphics.getWidth()), (random.nextInt(Gdx.graphics.getHeight())), 12, GameModel.getInstance().type()));
       }

   }

   private void remove(Body body){
        if (body.getPosition().x > Gdx.graphics.getWidth() || body.getPosition().x < Gdx.graphics.getWidth()){
            if (body.getPosition().y > Gdx.graphics.getHeight()){
                GameModel.getInstance().removeFruit((EntityModel) body.getUserData());
            }
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
}
