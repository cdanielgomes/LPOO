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

        GameController.getInstance().update(delta);

        game.getBatch().begin();
        drawBackground();
        drawEntities();

        game.getBatch().setProjectionMatrix(camera.combined);

        SwipeRender(camera);


        game.getBatch().end();


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
       /// GameModel.getInstance().checkBounds();
        fruitModels = GameModel.getInstance().getFruits();
        System.out.println(fruitModels.size());
        for (FruitModel fruit : fruitModels) {

            FruitView view = new FruitView(this.game, fruit.getFruit());
        //System.out.print("x = " + fruit.getX() + "  y=" + fruit.getY() + "  ");

            view.update(fruit);
            view.draw(game.getBatch());

        }
        /*
        LimitView limitView = new LimitView(this.game);


        limitView.update(GameModel.getInstance().getTop());

        limitView.draw(game.getBatch());

        limitView.update(GameModel.getInstance().getLeft());

        limitView.draw(game.getBatch());

        limitView.update(GameModel.getInstance().getRight());
        limitView.draw(game.getBatch());
   */


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

        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //camera.update();
        //game.getBatch().setProjectionMatrix(camera.combined);
        //Gdx.gl.glEnable(GL20.GL_BLEND);
        //Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);


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

//        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setInputProcessor(cut);

    }

    private void checkForFruitsCut() {

        World world = GameController.getInstance().getWorld();
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        // get the radius of the shape of the body
         Array<Fixture> f = bodies.get(0).getFixtureList();
         float radius = f.get(0).getShape().getRadius();
        //System.out.println(f.get(0).getShape().getRadius());



        for (Body fruit : bodies) {

            if (swipeTS.getTriangleStrip().size != 0) {
              //  System.out.println("DIST : " + distSq(swipeTS.getTriangleStrip().get(0) , fruit.getWorldCenter()));
                //System.out.println("FIRST POINT : " + " x : " + (int)swipeTS.getTriangleStrip().get(0).x + " y : " + (int)swipeTS.getTriangleStrip().get(0).y);

                if (distSq(swipeTS.getTriangleStrip().get(0) , fruit.getWorldCenter()) < (radius*radius)){
                  //  System.out.println("IN FRUIT");
                }
            }

            /*for (Vector2 cut : swipeTS.getTriangleStrip()) {

                if ((fruit.getPosition().x == cut.x) && (fruit.getPosition().y == cut.y)) {
                    System.out.println("touch the fruit");

                }
            }*/
        }


    }

    public static float distSq(Vector2 p1, Vector2 p2) {
        float dx = p1.x - p2.x, dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }
}



