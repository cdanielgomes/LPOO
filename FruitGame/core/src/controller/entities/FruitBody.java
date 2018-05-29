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
                    createFixture(body, 50, 4, 0,0);
                    break;
                case ORANGE:
                    createFixture(body, 50, 1.4f, 0,0);
                    break;
                case BANANA:
                    createFixture(body, 50, 0.54f, 0,0);
                    break;
                case STRAW:
                    createFixture(body, 50, 1.5f, 0,0);
                    break;
                case LEMON:
                    createFixture(body, 50, 3, 0,0);
                    break;
                case PEACH:
                    createFixture(body, 50, 3.1f, 0,0);
                    break;
                case APPLE:
                    createFixture(body, 50, 13.f, 0,0);
                    break;
                case PLUM:
                    createFixture(body, 50, 1, 0,0);
                    break;
                    default:
                        break;

            }
        }
    }



}
