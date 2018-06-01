package controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public interface CutResolver {
    public void resolve(Array<Vector2> input, Array<Vector2> output);
}
