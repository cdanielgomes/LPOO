package controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 *
 * Cut handler for in-game events
 * 
 */

public class CutHandler extends InputAdapter {

    /**
     *  List with the points that belong to the cut 
     */
    private FixedSizeList<Vector2> inputPoints ;

    /**
     *  EventInputPointer for input control
     */

    private int EventInputPointer = 0;

    /**
     * First minimum distance between points (the first 2 points)
     */

    public int firstDistance = 10;

    /**
     *
     *  Minimum distance between the other points
     */
    public int minDistance = 20;

    /**
     * First point of the cut 
     */

    private Vector2 startingPoint = new Vector2();

    /**
     * Flag to check if the cut is being displayed
     */
    private boolean isDrawing = false;

    /**
     * 
     * simplifier used to simplify the cut 
     */

    private CutResolver simplifier = new Resolver();

    /**
     * The points of the cut simplified
     */

    private Array<Vector2> simplified;


    /**
     * Constructor 
     * @param  maxPoints Maximum number of points of the cut
     * @return a CutHandler
     */

    public CutHandler(int maxPoints){
        this.inputPoints = new FixedSizeList<Vector2>(maxPoints , Vector2.class);
        this.simplified = new Array<Vector2>(true , maxPoints , Vector2.class);
    }

    /**
     * Get func. for the inputPoints field
     * 
     * @return the inputPoints
     */
    public Array<Vector2> getInputPoints() {
        return this.inputPoints;
    }

    /**
     * Get func. for the simplified field
     * 
     * @return the simplified
     */

    public Array<Vector2> getSimplified() {
        return this.simplified;
    }

    /**
     * Resolve function to simplify the inputPoints
     * 
     */
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
