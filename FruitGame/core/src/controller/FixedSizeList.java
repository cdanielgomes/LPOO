package controller;

import com.badlogic.gdx.utils.Array;

public class FixedSizeList<T> extends Array<T> {

    public FixedSizeList(int size , Class<T> type){
        super(false , size , type);
    }

    public void insert(T newValue){

        T[] items = this.items;

        size = Math.min(size + 1 , items.length);

        for (int i = size -1 ; i > 0 ; i--){
            items[i] = items[i -1];
        }

        items[0] = newValue;

    }
}
