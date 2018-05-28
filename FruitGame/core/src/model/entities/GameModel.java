package model;


import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;

import model.entities.FruitModel;
import view.entities.EntityView;

import java.util.Random;
/**
 * A model representing a game.
 */

public class GameModel {

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

        for(int i = 0; i < 5; i++){
            fruitModels.add(new FruitModel(rand.nextInt(Gdx.graphics.getWidth()), (rand.nextInt(Gdx.graphics.getHeight())), 12,type()));
        }


    }

    private EntityView.Fruits type(){

        switch (rand.nextInt(9)){
            case 0:
                return EntityView.Fruits.WATERMELON;
            case 4:
                return EntityView.Fruits.APPLE;
            case 2:
                return EntityView.Fruits.BANANA;

            case 3:
                return EntityView.Fruits.LEMON;

            case 5:
                return EntityView.Fruits.ORANGE;

            case 6:
                return EntityView.Fruits.PEACH;

            case 7:
                return EntityView.Fruits.PLUM;

        }
        return EntityView.Fruits.STRAW;
    }

    public List<FruitModel> getFruits() {
        return fruitModels;
    }
}

