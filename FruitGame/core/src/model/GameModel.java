package model;


import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.entities.CutFruitModel;
import model.entities.FruitModel;
import model.entities.Life;
import model.entities.LimitModel;
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

    private int MAX_FRUITS = 4;
    private int MAX_LIFE = 5;

    Random rand = new Random();
    /**
     * The singleton instance of the game model
     */
    private static GameModel instance;

    private List<FruitModel> fruitModels = new ArrayList<FruitModel>();
    private List<CutFruitModel> cutModels = new ArrayList<CutFruitModel>();
    private List<Life> life = new ArrayList<Life>();

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
        createLife();

    }

    private void createLife() {
        Life first = new Life(Gdx.graphics.getWidth() - 10, Gdx.graphics.getHeight() - 10, 0, 0);
        life.add(first);
        for (int i = 1; i < MAX_LIFE; i++) {
            life.add(new Life((Gdx.graphics.getWidth() - 30 * (i + 1)) * PPM, (Gdx.graphics.getHeight() - 30) * PPM, 0, i));
        }

    }

    private void createFruits() {

        for (int i = fruitModels.size(); i < MAX_FRUITS; i++) {
            int x = rand.nextInt(Gdx.graphics.getWidth());
            fruitModels.add(new FruitModel(x, 10, 2, type()));

        }

    }

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

    public List<Life> getLife() {
        return life;
    }

    public void deleteLife() {
        if (!life.isEmpty())
            life.remove(life.size() - 1);
    }

    public boolean gameOver() {

        return life.size() == 0;
    }

    public void resetArrays() {
        fruitModels.clear();
        cutModels.clear();
        life.clear();
    }
}


