package model.entities;


import view.entities.EntityView.Fruits;

public class FruitModel extends EntityModel{

    private final Fruits fruit;
    private boolean throwned = false;
    private boolean cut = false;

    public FruitModel(float x, float y, float rotation, Fruits fruit){
        super(x,y,rotation);
        this.fruit = fruit;
    }

public Fruits getFruit(){
        return fruit;
}

public  boolean isThrowned(){
        return throwned;
}
public void setThrowned() {throwned = true;}
public void setCut(boolean cut){ this.cut = cut; }
public boolean isCut() {return cut;}
}
