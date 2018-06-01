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
                    createFixture(body, 1, 0.6f);
                    break;
                case ORANGE:
                    createFixture(body, 1, 0.2f);
                    break;
                case BANANA:
                    createFixture(body, 5, 0.54f);
                    break;
                case STRAW:
                    createFixture(body, 1, 0.3f);
                    break;
                case LEMON:
                    createFixture(body, 1, 0.4f);
                    break;
                case PEACH:
                    createFixture(body, 1, 0.45f);
                    break;
                case APPLE:
                    createFixture(body, 5, 0.4f);
                    break;
                case PLUM:
                    createFixture(body, 1, 0.35f);
                    break;
                    default:
                        break;

            }
        }
    }



}
