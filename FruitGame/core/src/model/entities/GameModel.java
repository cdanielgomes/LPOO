package model;


import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;

import model.entities.EntityModel;
import model.entities.FruitModel;
import view.entities.EntityView;

import java.util.Random;
/**
 * A model representing a game.
 */

public class GameModel {

    private int MAX_FRUITS = 5;

    Random rand = new Random();
    /**
     * The singleton instance of the game model
     */
    private static GameModel instance;

    private List<FruitModel>  fruitModels = new ArrayList<FruitModel>();

    /**
     * Returns a singleton instance of the game model
     *
     * @return the singleton instance
     */
    public static GameModel getInstance() {
        if (instance == null)
            instance = new GameModel();
        return instance;
    }


    private GameModel(){

        for(int i = 0; i < MAX_FRUITS; i++){
            int x = rand.nextInt(Gdx.graphics.getWidth());
            fruitModels.add(new FruitModel(31, 7, 2,type()));
        }


    }

    public EntityView.Fruits type(){

        switch (rand.nextInt(8)){
            case 0:
                return EntityView.Fruits.WATERMELON;
            case 1:
                return EntityView.Fruits.APPLE;
            case 3:
                return EntityView.Fruits.BANANA;

            case 2:
                return EntityView.Fruits.LEMON;

            case 5:
                return EntityView.Fruits.ORANGE;

            case 4:
                return EntityView.Fruits.PEACH;

            case 6:
                return EntityView.Fruits.PLUM;

        }
        return EntityView.Fruits.STRAW;
    }


    public void checkOutOfBounds(){


    }

    public List<FruitModel> getFruits() {
        return fruitModels;
    }

    public void setFruitModels(List<FruitModel> l){
        fruitModels = l;
    }

    public void removeFruit(EntityModel fruit){
        fruitModels.remove(fruit);
    }
}

