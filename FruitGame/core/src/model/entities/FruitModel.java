package model.entities;


import view.entities.EntityView;

public class FruitModel extends EntityModel {

    private final EntityView.Fruits fruit;

    public FruitModel(float x, float y, float rotation, EntityView.Fruits fruit){
        super(x,y,rotation);
        this.fruit = fruit;
    }


public EntityView.Fruits getFruit(){
        return fruit;
}

}
