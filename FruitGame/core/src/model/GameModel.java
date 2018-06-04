package model;


import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.entities.CutFruitModel;
import model.entities.FruitModel;
import model.entities.Life;
import model.entities.LimitModel;
import view.GameView;
import view.entities.EntityView;

import java.util.Random;

import static view.GameView.PPM;
import static view.entities.EntityView.Fruits.APPLE;
import static view.entities.EntityView.Fruits.BANANA;
import static view.entities.EntityView.Fruits.BOMB;
import static view.entities.EntityView.Fruits.LEMON;
import static view.entities.EntityView.Fruits.ORANGE;
import static view.entities.EntityView.Fruits.PEACH;
import static view.entities.EntityView.Fruits.PLUM;
import static view.entities.EntityView.Fruits.SPECIAL;
import static view.entities.EntityView.Fruits.STRAW;
import static view.entities.EntityView.Fruits.WATERMELON;

/**
 * A model representing a game.
 */

public class GameModel {


/**
 * Max number of fruits in the screen.
 */
    private int MAX_FRUITS = 2;
   
/**
 * Max life
 */
    private int MAX_LIFE = 5;


/**
 * Variable to generate random numbers
 */
    Random rand = new Random();
    /**
     * The singleton instance of the game model
     */
    private static GameModel instance;


/**
 * Array of fruit models
 */
    private List<FruitModel> fruitModels = new ArrayList<FruitModel>();
    
/**
 * Array of cut fruit models
 */
    private List<CutFruitModel> cutModels = new ArrayList<CutFruitModel>();
    
/**
 * Array of number of lives at a time
 */
    private List<Life> life = new ArrayList<Life>();

/**
 * Model of the top limit
 */
    private LimitModel top;

/**
 * Model of the left limit
 */
    private LimitModel left;
    
/**
 * Model of the right limit
 */
    private LimitModel right;

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



/**
 * Constructor
 */
    private GameModel() {

        top = new LimitModel(0, Gdx.graphics.getHeight(), 0);
        left = new LimitModel(0, 0, 0);
        right = new LimitModel(Gdx.graphics.getWidth(), -5, 0);

        createFruits();
        createLife();

    }


/**
 * Create lives 
 */
    private void createLife() {
        Life first = new Life(Gdx.graphics.getWidth() - 10, Gdx.graphics.getHeight() - 10, 0, 0);
        life.add(first);
        for (int i = 1; i < MAX_LIFE; i++) {
            life.add(new Life((Gdx.graphics.getWidth() - 30 * (i + 1)) * PPM, (Gdx.graphics.getHeight() - 30) * PPM, 0, i));
        }

    }

    
/**
 * Create the fruits
 */
    private void createFruits() {

        for (int i = fruitModels.size(); i < MAX_FRUITS; i++) {
            int x = rand.nextInt(Gdx.graphics.getWidth());
            fruitModels.add(new FruitModel(x, 10, 2, type()));

        }

    }

/**
 * Calculate which type will be the fruit
 * 
 * @return the Fruit type 
 */
    public EntityView.Fruits type() {

        if (rand.nextInt(40) == 20)
            return SPECIAL;


        switch (rand.nextInt(9)) {
            case 0:
                return WATERMELON;
            case 1:
                return APPLE;
            case 3:
                return BANANA;

            case 2:
                return LEMON;

            case 5:
                return ORANGE;

            case 4:
                return PEACH;
            case 6:
                return PLUM;
            case 7:
                return BOMB;
            case 8:
                return STRAW;
        }

        return PLUM;

    }


/**
 * Return the List of fruit models
 * @return Listo of fruit models
 */
    public List<FruitModel> getFruits() {
        return fruitModels;
    }

/**
 * Return the List of cut fruit models
 * @return List of cut fruit models
 */
    public List<CutFruitModel> getCutFruits() {
        return cutModels;
    }


/**
 * Return left limit model
 * @return left limit model
 */
    public LimitModel getLeft() {
        return left;
    }


/**
 * Return top limit model
 * @return top limit model
 */
    public LimitModel getTop() {
        return top;
    }

/**
 * Return right limit model
 * @return right limit model
 */
    public LimitModel getRight() {
        return right;
    }

/**
 * add cur fruit models
 */
    public void addCutFruit(CutFruitModel x, CutFruitModel y) {
        cutModels.add(x);
        cutModels.add(y);

    }


/**
 * Check if the fruit is on  the screen and if not delete it. At the same time create new fruits
 */
    public void checkBounds() {

        Iterator<FruitModel> iterator = fruitModels.iterator();

        while (iterator.hasNext()) {

            FruitModel fruit = iterator.next();
            if (0 > fruit.getY() || fruit.isCut()) {
                iterator.remove();
            }
        }

        createFruits();
    }


 /**
 * Delete cut fruit models from the array when they are not in the screen
 */
    public void deleteCutFruits() {
        Iterator<CutFruitModel> iterator = cutModels.iterator();

        while (iterator.hasNext()) {

            CutFruitModel fruit = iterator.next();
            if (0 > fruit.getY()) {
                iterator.remove();
            }
        }
    }

 /**
 * Return the life
 * @return List of lives 
 */
    public List<Life> getLife() {
        return life;
    }

 /**
 * Remove a life from the array of lives
 */
    public void deleteLife() {
        if (!life.isEmpty())
            life.remove(life.size() - 1);
    }

    /**
     * Check the array of life size 
     * @return true if the array size is 0, false if not
     * */
    public boolean gameOver() {
        return life.size() == 0;
    }

    /**
     * Assign instance to null
     * */
    public void resetArrays() {
      instance = null;
       /* fruitModels.clear();
        cutModels.clear();
        life.clear();
        createLife();
        createFruits();
*/    }
}


