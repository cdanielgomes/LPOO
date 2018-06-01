package model;


import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.entities.EntityModel;
import model.entities.FruitModel;
import model.entities.LimitModel;
import view.entities.EntityView;

import java.util.Random;
/**
 * A model representing a game.
 */

public class GameModel {

    private int MAX_FRUITS = 1;


    Random rand = new Random();
    /**
     * The singleton instance of the game model
     */
    private static GameModel instance;

    private List<FruitModel>  fruitModels = new ArrayList<FruitModel>();
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


    private GameModel(){

        top = new LimitModel(0,Gdx.graphics.getHeight(), 0);
        left = new LimitModel(0,0, 0);
        right = new LimitModel(Gdx.graphics.getWidth(),0, 0);

        createFruits();

    }

  private void createFruits(){

        for(int i = fruitModels.size(); i < MAX_FRUITS; i++){
            int x = rand.nextInt(Gdx.graphics.getWidth());
            fruitModels.add(new FruitModel(x, 0, 2,type()));
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



    public List<FruitModel> getFruits() {
        return fruitModels;
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

    public void setFruitModels(List<FruitModel> l){
        fruitModels = l;
    }

  public void checkBounds() {
      Iterator<FruitModel> iterator = fruitModels.iterator();

      while (iterator.hasNext()) {
          FruitModel fruit = iterator.next();
          if (fruit.getX() > Gdx.graphics.getWidth() || fruit.getX() < 0 ){
              if(fruit.getY() < 0)
              iterator.remove();
          }
      }
      createFruits();
  }
}

