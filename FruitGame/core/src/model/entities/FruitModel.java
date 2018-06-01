package model.entities;


import com.badlogic.gdx.Gdx;

import model.GameModel;
import view.entities.EntityView;

public class FruitModel extends EntityModel{

    private final EntityView.Fruits fruit;
private boolean throwned = true;
    public FruitModel(float x, float y, float rotation, EntityView.Fruits fruit){
        super(x,y,rotation);
        this.fruit = fruit;
    }

public EntityView.Fruits getFruit(){
        return fruit;
}

public  boolean isThrowned(){
        return throwned;
}

}
