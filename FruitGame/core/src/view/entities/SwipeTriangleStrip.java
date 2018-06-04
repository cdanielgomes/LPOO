package view.entities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Color;

/**
 *  Class used to represent the cut's view
 */
public class SwipeTriangleStrip {

    Array<Vector2> texcoord = new Array<Vector2>();
    Array<Vector2> triangleStrip = new Array<Vector2>();
    int batchSize;

    Vector2 perp = new Vector2();

    public float thickness = 30f;
    public float endcap = 8.5f;
    public Color color = new Color(Color.WHITE);
    ImmediateModeRenderer20 gl20;

    /**
     * Constructor
     */
    public SwipeTriangleStrip() {
        gl20 = new ImmediateModeRenderer20(false, false, 1);
    }


    /**
     * Draws the cut in the viewport
     * @param cam the game camera
     */

    public void draw(Camera cam ) {


        if (triangleStrip.size<=0) {
            return;
        }


        gl20.begin(cam.combined, GL20.GL_TRIANGLE_STRIP);
        for (int i=0; i<triangleStrip.size; i++) {

            Vector2 point = triangleStrip.get(i);
            Vector2 tc = texcoord.get(i);
            //gl20.color(color.r, color.g, color.b, color.a);
            gl20.texCoord(tc.x, 0f);
            gl20.vertex(point.x, point.y, 0f);
        }
        gl20.end();
    }

    /**
     * Functions that generates the cut 
     * @param  input InputPoints of the cut
     * @param  mult  
     * @return  
     */

    private int generate(Array<Vector2> input, float mult) {

        float[] endcapMatrix = {endcap,endcap,endcap,endcap,endcap,endcap,endcap,endcap,endcap};
        Matrix3 m1 = new Matrix3(endcapMatrix);

        int c = triangleStrip.size;

        if (endcap<=0) {
            triangleStrip.add(input.get(0));
        } else {
            Vector2 p = input.get(0);
            Vector2 p2 = input.get(1);
            perp.set(p).sub(p2).mul(m1);
            triangleStrip.add(new Vector2(p.x+perp.x, p.y+perp.y));
        }
        texcoord.add(new Vector2(0f, 0f));

        for (int i=1; i<input.size-1; i++) {
            Vector2 p = input.get(i);
            Vector2 p2 = input.get(i+1);

            //get direction and normalize it
            perp.set(p).sub(p2).nor();

            //get perpendicular
            perp.set(-perp.y, perp.x);

            float thick = thickness * (1f-((i)/(float)(input.size)));

            float[] Matrix = {(thick/2f),(thick/2f),(thick/2f),(thick/2f),(thick/2f),(thick/2f),(thick/2f),(thick/2f),(thick/2f)};
            Matrix3 m2 = new Matrix3(Matrix);

            //move outward by thickness
            perp.mul(m2);

            float[] multMatrix = {mult,mult,mult,mult,mult,mult,mult,mult,mult};
            Matrix3 m3 = new Matrix3(multMatrix);

            //decide on which side we are using
            perp.mul(m3);

            //add the tip of perpendicular
            triangleStrip.add(new Vector2(p.x+perp.x, p.y+perp.y));
            //0.0 -> end, transparent
            texcoord.add(new Vector2(0f, 0f));

            //add the center point
            triangleStrip.add(new Vector2(p.x, p.y));
            //1.0 -> center, opaque
            texcoord.add(new Vector2(1f, 0f));
        }

        //final point
        if (endcap<=0) {
            triangleStrip.add(input.get(input.size-1));
        } else {
            Vector2 p = input.get(input.size-2);
            Vector2 p2 = input.get(input.size-1);
            perp.set(p2).sub(p).mul(m1);
            triangleStrip.add(new Vector2(p2.x+perp.x, p2.y+perp.y));
        }
        //end cap is transparent
        texcoord.add(new Vector2(0f, 0f));
        return triangleStrip.size-c;
    }

    public void update(Array<Vector2> input) {
        triangleStrip.clear();
        texcoord.clear();

        if (input.size<2) {
            return;
        }


        batchSize = generate(input, 1);
    }

    /**
     * Get func. for the triangleStrip
     * @return triangleStrip field
     */
    public Array<Vector2> getTriangleStrip (){
        return this.triangleStrip;
    }


}
