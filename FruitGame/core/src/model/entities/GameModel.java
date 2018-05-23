package model;


import model.entities.FruitModel;

/**
 * A model representing a game.
 */

public class GameModel {

    /**
     * The singleton instance of the game model
     */
    private static GameModel instance;

    private FruitModel watermelon;

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

        watermelon = new FruitModel(300,300,10);
    }

    public FruitModel getFruit() {
        return watermelon;
    }
}

