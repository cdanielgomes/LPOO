package view;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyFruitGame;

import java.util.ArrayList;
import java.util.List;

import controller.CutHandler;
import controller.GameController;

import model.GameModel;
import model.entities.FruitModel;
import view.entities.FruitView;
import view.entities.LimitView;
import view.entities.SwipeTriangleStrip;

public class GameView extends ScreenAdapter {


    private final MyFruitGame game;

    /**
     * Used to debug the position of the physics fixtures
     */
    private static final boolean DEBUG_PHYSICS = true;

    /**
     * How much meters does a pixel represent.
     */
    public final static float PPM = 0.04f;

    /**
     * The camera used to show the viewport.
     */
    private final OrthographicCamera camera;

    /**
     * A renderer used to debug the physical fixtures.
     */
    private Box2DDebugRenderer debugRenderer;

    /**
     * The transformation matrix used to transform meters into
     * pixels in order to show fixtures in their correct places.
     */
    private Matrix4 debugCamera;

    private CutHandler cut;
    private SwipeTriangleStrip swipeTS;
    ShapeRenderer shapes;


    Texture tex;


    public GameView(MyFruitGame game) {
        this.game = game;

        loadAssets();
        CreateSwipe();
        camera = createCamera();

    }


    private void loadAssets() {

        this.game.getAssetManager().load("watermelon.png", Texture.class);
        this.game.getAssetManager().load("background.png", Texture.class);
        this.game.getAssetManager().load("banana.png", Texture.class);
        this.game.getAssetManager().load("lemon.png", Texture.class);
        this.game.getAssetManager().load("apple.png", Texture.class);
        this.game.getAssetManager().load("strawberry.png", Texture.class);
        this.game.getAssetManager().load("peach.png", Texture.class);
        this.game.getAssetManager().load("plum.png", Texture.class);
        this.game.getAssetManager().load("orange.png", Texture.class);
        this.game.getAssetManager().load("wall.png", Texture.class);

        this.game.getAssetManager().finishLoading();
    }

    /**
     * Creates the camera used to show the viewport.
     *
     * @return the camera
     */
    private OrthographicCamera createCamera() {

        OrthographicCamera camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

        if (DEBUG_PHYSICS) {
            debugRenderer = new Box2DDebugRenderer();
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PPM);
        }

        return camera;
    }

    /**
     * Renders this screen.
     *
     * @param delta time since last renders in seconds.
     */
    @Override
    public void render(float delta) {


        game.getBatch().begin();
        drawBackground();
        drawEntities();
 ;

        game.getBatch().setProjectionMatrix(camera.combined);

        SwipeRender(camera);


        game.getBatch().end();

        GameController.getInstance().update(delta);

        if (DEBUG_PHYSICS) {
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PPM);
            debugRenderer.render(GameController.getInstance().getWorld(), debugCamera);
        }


    }

    /**
     * How much meters does a pixel represent.
     */

    private void drawEntities() {

        List<FruitModel> fruitModels;

        fruitModels = GameModel.getInstance().getFruits();
<<<<<<< HEAD

        GameModel.getInstance().checkBounds();

=======
>>>>>>> 649c0a7cf4bb65316faf7b2844c8861d2ef3ec48
        for (FruitModel fruit : fruitModels) {

            FruitView view = new FruitView(this.game, fruit.getFruit());
           view.update(fruit);
            view.draw(game.getBatch());

        }
<<<<<<< HEAD

=======
System.out.println("added");
        LimitView limitView = new LimitView(this.game);


        limitView.update(GameModel.getInstance().getTop());

        limitView.draw(game.getBatch());


        limitView.update(GameModel.getInstance().getLeft());


        limitView.draw(game.getBatch());


        limitView.update(GameModel.getInstance().getRight());
        limitView.draw(game.getBatch());
   */
>>>>>>> 649c0a7cf4bb65316faf7b2844c8861d2ef3ec48



//       GameModel.getInstance().checkBounds();

      //  System.out.print(GameModel.getInstance().getFruits().size());

    }

    /**
     * Draws the background
     */
    public void drawBackground() {
        Texture background = game.getAssetManager().get("background.png", Texture.class);
        game.getBatch().draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
    }


    public void SwipeRender(OrthographicCamera camera) {


        tex.bind();

        swipeTS.thickness = 30f;

        swipeTS.update(cut.getSimplified());


        swipeTS.color = Color.WHITE;

        checkForFruitsCut(); // TESTING

        swipeTS.draw(camera);


    }

    public void CreateSwipe() {

        swipeTS = new SwipeTriangleStrip();

        cut = new CutHandler(10);

        cut.minDistance = 10;

        cut.firstDistance = 10;

        tex = new Texture("gradient.png");
        tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        shapes = new ShapeRenderer();

        Gdx.input.setInputProcessor(cut);

    }

    private void checkForFruitsCut() {

        World world = GameController.getInstance().getWorld();
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);

        Array<Fixture> fixtures ;
        float radius;

        // get the radius of the shape of the body
        // Array<Fixture> f = bodies.get(0).getFixtureList();
        // float radius = f.get(0).getShape().getRadius();
        // System.out.println(f.get(0).getShape().getRadius());

        // distSq(swipeTS.getTriangleStrip().get(0) , fruit.getWorldCenter()) < (radius*radius)

<<<<<<< HEAD
            if (swipeTS.getTriangleStrip().size != 0) {

                if (distSq(swipeTS.getTriangleStrip().get(0) , fruit.getWorldCenter()) < (radius*radius)){

                }
            }

=======
        if (swipeTS.getTriangleStrip().size < 2)
            return ;

        Vector2 v1 = swipeTS.getTriangleStrip().get(0);
        Vector2 v2 = swipeTS.getTriangleStrip().get(1);


        for (Body fruit : bodies) {

            fixtures = fruit.getFixtureList();
            radius = fixtures.get(0).getShape().getRadius();

            if (Cut(v1 ,v2 , fruit , radius)){
                System.out.println("HIT FRUIT");
            }
>>>>>>> 649c0a7cf4bb65316faf7b2844c8861d2ef3ec48
        }


    }

    public static float distSq(Vector2 p1, Vector2 p2) {
        float dx = p1.x - p2.x, dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    public static boolean Cut(Vector2 v1 , Vector2 v2 , Body b , float r){
        if ((distSq(v1.scl(PPM) , b.getWorldCenter()) < (r*r)) && (distSq(v2.scl(PPM) , b.getWorldCenter()) < (r*r))){
            return true;
        }

        return false;
    }
}



