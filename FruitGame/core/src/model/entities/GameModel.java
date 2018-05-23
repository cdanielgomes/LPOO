package model;


import model.entities.WatermelonModel;

/**
 * A model representing a game.
 */

public class GameModel {

    /**
     * The singleton instance of the game model
     */
    private static GameModel instance;

    private WatermelonModel watermelon;

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

        watermelon = new WatermelonModel(50,50,10);
    }

    public WatermelonModel getWatermelon() {
        return watermelon;
    }
}

