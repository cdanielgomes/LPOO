package model.entities;


import view.entities.EntityView.Fruits;


public class FruitModel extends EntityModel{
   /**
     * Type of the fruit
     * */
    private final Fruits fruit;
   /**
     * Boolean to check if the fruit is throw 
     * */
    private boolean throwned = false;
   
   /**
     * Boolean to check if the fruit is cut 
     * */
    private boolean cut = false;


   /**
     * Constructor of the fruit model with position, rotation and fruit type
     * 
     * @param x The x-coordinate of this entity in meters.
     * @param y The y-coordinate of this entity in meters.
     * @param rotation The current rotation of this entity in radians.
     * @param fruit type of fruit
     * */
    public FruitModel(float x, float y, float rotation, Fruits fruit){
        super(x,y,rotation);
        this.fruit = fruit;
    }

    /**
     * Return the type of the fruit
     * @return type of fruit
     */
    
public Fruits getFruit(){
        return fruit;
}

    /**
     * Return if the fruit was throw or not
     * @return true if the fruit was throw, false otherwise
     */
public  boolean isThrowned(){
        return throwned;
}
   /**
     * Set the throwned true - fruit was throw
     *
     */

public void setThrowned() {throwned = true;}
   /**
     * Assign a boolean to the cut 
     * @param cut fruit cut or not
     */

public void setCut(boolean cut){ this.cut = cut; }

   /**
     * Return if the fruit was cut or not
     * @return true if the fruit was cut, false otherwise
     */
public boolean isCut() {return cut;}
}
