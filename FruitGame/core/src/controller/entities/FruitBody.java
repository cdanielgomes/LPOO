package controller.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import model.entities.EntityModel;
import model.entities.FruitModel;

/**
 *
 *  FruitBody Body class , extends EntityBody
 *
 *
 */

public class FruitBody extends EntityBody {


    /**
     * Constructor of the class itself
     * 
     * @param  world the world this body lives on
     * @param  model the model representing the body
     * 
     */
    public FruitBody(World world, EntityModel model ){
        super(world, model, BodyDef.BodyType.DynamicBody);

        if(model instanceof FruitModel){
            switch(((FruitModel) model).getFruit()){
                case WATERMELON:
                    createFixture(body, 2, 0.6f);
                    break;
                case ORANGE:
                    createFixture(body, 2, 0.2f);
                    break;
                case BANANA:
                    createFixture(body, 2, 0.54f);
                    break;
                case STRAW:
                    createFixture(body, 2, 0.3f);
                    break;
                case LEMON:
                    createFixture(body, 2, 0.4f);
                    break;
                case PEACH:
                    createFixture(body, 2, 0.45f);
                    break;
                case APPLE:
                    createFixture(body, 2, 0.4f);
                    break;
                case PLUM:
                    createFixture(body, 2, 0.35f);
                    break;
                case BOMB:
                    createFixture(body, 2, 1f);
                case SPECIAL:
                    createFixture(body, 2, 1f);
                    break;

            }
        }
    }



}
