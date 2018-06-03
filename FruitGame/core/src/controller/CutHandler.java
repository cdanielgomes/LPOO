package controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class CutHandler extends InputAdapter {


    private FixedSizeList<Vector2> inputPoints ;

    private int EventInputPointer = 0;

    public int firstDistance = 10;

    public int minDistance = 20;

    private Vector2 startingPoint = new Vector2();

    private boolean isDrawing = false;

    private CutResolver simplifier = new Resolver();

    private Array<Vector2> simplified;

    public CutHandler(int maxPoints){
        this.inputPoints = new FixedSizeList<Vector2>(maxPoints , Vector2.class);
        this.simplified = new Array<Vector2>(true , maxPoints , Vector2.class);
    }

 
    public Array<Vector2> getInputPoints() {
        return this.inputPoints;
    }

    public Array<Vector2> getSimplified() {
        return this.simplified;
    }

    public void resolve(){
        simplifier.resolve(inputPoints , simplified);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {



        if (pointer != EventInputPointer ){
            return false;
        }

        isDrawing = true;

        inputPoints.clear();

        startingPoint = new Vector2( screenX , Gdx.graphics.getHeight() - screenY);

        inputPoints.insert(startingPoint);

         resolve();

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        isDrawing = false;
        inputPoints.clear();

        resolve();

        return false;

    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        if(EventInputPointer != pointer)
            return false;

        isDrawing = true;

        Vector2 vec = new Vector2( screenX, Gdx.graphics.getHeight() - screenY);

        float deltaX = vec.x - startingPoint.x;
        float deltaY = vec.y - startingPoint.y;

        float dist = (float)Math.sqrt(deltaX*deltaX  + deltaY*deltaY);

        if (dist < minDistance && (inputPoints.size > 1 || dist < firstDistance))
            return false;


        inputPoints.insert(vec);

        startingPoint = vec;

        resolve();



        return true;
    }
}
