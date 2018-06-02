package model;


import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.entities.CutFruitModel;
import model.entities.FruitModel;
import model.entities.LimitModel;
import view.entities.EntityView;
import java.util.Random;
import static view.entities.EntityView.Fruits.APPLE;
import static view.entities.EntityView.Fruits.BANANA;
import static view.entities.EntityView.Fruits.BOMB;
import static view.entities.EntityView.Fruits.LEMON;
import static view.entities.EntityView.Fruits.ORANGE;
import static view.entities.EntityView.Fruits.PEACH;
import static view.entities.EntityView.Fruits.PLUM;
import static view.entities.EntityView.Fruits.WATERMELON;

/**
 * A model representing a game.
 */

public class GameModel {

    private int MAX_FRUITS = 4;


    Random rand = new Random();
    /**
     * The singleton instance of the game model
     */
    private static GameModel instance;

    private List<FruitModel> fruitModels = new ArrayList<FruitModel>();
    private List<CutFruitModel> cutModels = new ArrayList<CutFruitModel>();

    private final LimitModel top;
    private final LimitModel left;
    private final LimitModel right;

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


    private GameModel() {

        top = new LimitModel(0, Gdx.graphics.getHeight(), 0);
        left = new LimitModel(0, 0, 0);
        right = new LimitModel(Gdx.graphics.getWidth(), -5, 0);

        createFruits();

    }

    private void createFruits() {

        for (int i = fruitModels.size(); i < MAX_FRUITS; i++) {
            int x = rand.nextInt(Gdx.graphics.getWidth());
            fruitModels.add(new FruitModel(x, 10, 2, type()));

        }

    }

    public EntityView.Fruits type() {

        switch (rand.nextInt(8)) {
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

        }
        return EntityView.Fruits.STRAW;
    }


    public List<FruitModel> getFruits() {
        return fruitModels;
    }

    public List<CutFruitModel> getCutFruits() {
        return cutModels;
    }

    public LimitModel getLeft() {
        return left;
    }

    public LimitModel getTop() {
        return top;
    }

    public LimitModel getRight() {
        return right;
    }

    public void addCutFruit(CutFruitModel x, CutFruitModel y) {
        cutModels.add(x);
        cutModels.add(y);

    }

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

    public void deleteCutFruits() {
        Iterator<CutFruitModel> iterator = cutModels.iterator();

        while (iterator.hasNext()) {

            CutFruitModel fruit = iterator.next();
            if (0 > fruit.getY()) {
                iterator.remove();
            }
        }
    }
}


