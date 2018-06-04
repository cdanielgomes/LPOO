package controller;

import com.badlogic.gdx.utils.Array;

/**
 * Class that extends Array that allows inserting elements without changing the size of
 *
 * the Array , making a shift to the right  , discarding the last element
 *
 * 
 */

public class FixedSizeList<T> extends Array<T> {

    /**
     * Constructor of the class
     * @param  size size of the "Array"
     * @param  type type of the "Array"
     * 
     */
    public FixedSizeList(int size , Class<T> type){
        super(false , size , type);
    }

    /**
     * Inserts new elemnt
     * 
     * @param newValue new element of type T to be inserted
     */

    public void insert(T newValue){

        T[] items = this.items;

        size = Math.min(size + 1 , items.length);

        for (int i = size -1 ; i > 0 ; i--){
            items[i] = items[i -1];
        }

        items[0] = newValue;

    }
}
