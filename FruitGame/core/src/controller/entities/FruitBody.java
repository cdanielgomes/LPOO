package controller.entities;

import com.badlogic.gdx.physics.box2d.World;
import model.entities.EntityModel;
import model.entities.FruitModel;

public class FruitBody extends EntityBody {

    public FruitBody(World world, EntityModel model ){
        super(world, model);

        if(model instanceof FruitModel){
            switch(((FruitModel) model).getFruit()){
                case WATERMELON:
                    createFixture(body, 2, 1.2f);
                    break;
                case ORANGE:
                    createFixture(body, 0.002f, 0.02f);
                    break;
                case BANANA:
                    createFixture(body, 1.4f, 0.54f);
                    break;
                case STRAW:
                    createFixture(body, 0.2f, 1.5f);
                    break;
                case LEMON:
                    createFixture(body, 0.8f, 0.2f);
                    break;
                case PEACH:
                    createFixture(body, 0.7f, 1.1f);
                    break;
                case APPLE:
                    createFixture(body, 0.2f, 0.4f);
                    break;
                case PLUM:
                    createFixture(body, 0.3f, 0.4f);
                    break;
                    default:
                        break;

            }
        }
    }



}
