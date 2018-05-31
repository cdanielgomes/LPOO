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
import com.badlogic.gdx.utils.Array;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.List;

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

    private float GRAVITY = -9.8f;
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

/*private Vector2 impulse(Body body){
        float x, y;

        y = 2*GRAVITY*(random.nextInt(Gdx.graphics.getHeight()) - Gdx.graphics.getHeight()/2  - 23 - body.getPosition().y);

        if(Gdx.graphics.getWidth()/2 < bod)

  return  new Vector2(, y);
}*/


private void bodyMove(Body body){

    Vector2 impulse = new Vector2(32f,31f);
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

        for(Body b : bodies){
           // remove(b);
        if(!throwElem)
                bodyMove(b);

            ((EntityModel) b.getUserData()).setPosition(b.getPosition().x /0.1f, b.getPosition().y/0.2f);
            ((EntityModel) b.getUserData()).setRotation(b.getAngle());



        }
        throwElem = true;


      /*  if(GameModel.getInstance().getFruits().isEmpty()){
            createNewFruits();
            GameModel.getInstance().setFruitModels(fruits);
            fruits.clear();
        }*/

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
