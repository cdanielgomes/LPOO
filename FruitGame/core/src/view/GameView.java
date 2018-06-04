package view;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyFruitGame;

import java.util.List;

import controller.CutHandler;
import controller.GameController;

import model.GameModel;
import model.entities.CutFruitModel;
import model.entities.FruitModel;
import model.entities.Life;
import view.entities.CutFruitView;
import view.entities.EntityView;
import view.entities.FruitView;
import view.entities.LifeView;
import view.entities.SwipeTriangleStrip;

public class GameView extends ScreenAdapter {

    /**
     * Tell if a special fruit was cut
     */

    private boolean special = false;
    
    /**
     * instance of the game
     */
    private final MyFruitGame game;
   /**
     * Tell if the sound effect is assigned
     */

    public boolean sound = true;
    /**
     * Used to debug the position of the physics fixtures
     */
    private static final boolean DEBUG_PHYSICS = false;

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
    /**
     * CutHandler instance
     */

    private CutHandler cut;
    /**
     * Tell if a special fruit was cut
     */

    private SwipeTriangleStrip swipeTS;

    ShapeRenderer shapes;
    
    float delta = 0;

    //score variables
    Stage stage;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("myfont.ttf"));
    BitmapFont ScoreFont;
    static public Integer scoreValue = 0;

    private String yourScoreName = "0";
    BitmapFont yourBitmapFontName;
    //


    Texture tex;


    public GameView(MyFruitGame game) {
        this.game = game;
        scoreValue = 0;
        loadAssets();
        CreateSwipe();
        camera = createCamera();


        createScore();

    }


    private void loadAssets() {

        this.game.getAssetManager().load("half1_watermelon.png", Texture.class);
        this.game.getAssetManager().load("half2_watermelon.png", Texture.class);
        this.game.getAssetManager().load("watermelon.png", Texture.class);
        this.game.getAssetManager().load("background.png", Texture.class);
        this.game.getAssetManager().load("defeatBG.jpg", Texture.class);

        this.game.getAssetManager().load("half1_banana.png", Texture.class);
        this.game.getAssetManager().load("half2_banana.png", Texture.class);
        this.game.getAssetManager().load("banana.png", Texture.class);
        this.game.getAssetManager().load("half1_lemon.png", Texture.class);
        this.game.getAssetManager().load("half2_lemon.png", Texture.class);
        this.game.getAssetManager().load("lemon.png", Texture.class);

        this.game.getAssetManager().load("half1_apple.png", Texture.class);
        this.game.getAssetManager().load("half2_apple.png", Texture.class);
        this.game.getAssetManager().load("apple.png", Texture.class);
        this.game.getAssetManager().load("half2_strawberry.png", Texture.class);
        this.game.getAssetManager().load("half1_strawberry.png", Texture.class);
        this.game.getAssetManager().load("strawberry.png", Texture.class);

        this.game.getAssetManager().load("half1_peach.png", Texture.class);
        this.game.getAssetManager().load("half2_peach.png", Texture.class);
        this.game.getAssetManager().load("peach.png", Texture.class);

        this.game.getAssetManager().load("plum.png", Texture.class);
        this.game.getAssetManager().load("orange.png", Texture.class);
        this.game.getAssetManager().load("half1_orange.png", Texture.class);
        this.game.getAssetManager().load("half2_orange.png", Texture.class);

        this.game.getAssetManager().load("half1_plum.png", Texture.class);
        this.game.getAssetManager().load("half2_plum.png", Texture.class);
        this.game.getAssetManager().load("bomb.png", Texture.class);
        this.game.getAssetManager().load("special.png", Texture.class);
        this.game.getAssetManager().load("life.png", Texture.class);
        this.game.getAssetManager().load("half1_special.png", Texture.class);
        this.game.getAssetManager().load("half2_special.png", Texture.class);

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

        if (GameModel.getInstance().gameOver()) {
            GameController.getInstance().dispose();
            GameModel.getInstance().resetArrays();

            game.changeScreen(MyFruitGame.Menus.ENDGAME);
            return;
        }

        game.getBatch().begin();

        drawBackground();
        drawEntities();
        yourBitmapFontName.draw(game.getBatch(), yourScoreName, 180, Gdx.graphics.getHeight() - 10);

        DrawLife();
        game.getBatch().setProjectionMatrix(camera.combined);

        SwipeRender(camera);
        game.getBatch().end();

        if (special) {

            this.delta += delta;

            float accelerationX = Gdx.input.getAccelerometerX();
            scoreValue += (int) (Math.abs(accelerationX) * 0.1);

            if (this.delta >= 3) {
                special = false;
                this.delta = 0;
            }


        } else GameController.getInstance().update(delta);

        stage.draw();

        if (DEBUG_PHYSICS) {
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PPM);
            debugRenderer.render(GameController.getInstance().getWorld(), debugCamera);
        }


    }


    private void DrawLife() {
        List<Life> l = GameModel.getInstance().getLife();

        for (Life life : l) {
            LifeView view = new LifeView(this.game);
            view.update(life);
            view.draw(game.getBatch());
        }
    }


    /**
     * How much meters does a pixel represent.
     */

    private void drawEntities() {

        List<FruitModel> fruitModels;
        List<CutFruitModel> cutfruitModels;

        fruitModels = GameModel.getInstance().getFruits();
        cutfruitModels = GameModel.getInstance().getCutFruits();

        GameModel.getInstance().checkBounds();
        GameModel.getInstance().deleteCutFruits();

        for (FruitModel fruit : fruitModels) {

            FruitView view = new FruitView(this.game, fruit.getFruit());
            view.update(fruit);
            view.draw(game.getBatch());


        }

        for (CutFruitModel cut : cutfruitModels) {

            CutFruitView view = new CutFruitView(this.game, cut);

            view.update(cut);
            view.draw(game.getBatch());
        }

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

        Array<Fixture> fixtures;
        float radius;

        if (swipeTS.getTriangleStrip().size < 2)
            return;

        Vector2 v1 = swipeTS.getTriangleStrip().get(0);  // first point of swipe
        Vector2 v2 = swipeTS.getTriangleStrip().get(1);  // second point of swipe


        for (Body fruit : bodies) {


            if (fruit.getUserData() instanceof FruitModel) {
                fixtures = fruit.getFixtureList();
                radius = fixtures.get(0).getShape().getRadius();

                if(sound)
                     MainMenuScreen.getSound().play();

                if (Cut(v1, v2, fruit, radius)) {
                    FruitModel v = ((FruitModel) fruit.getUserData());
                    if (v.getFruit() == EntityView.Fruits.BOMB) {
                        GameController.getInstance().dispose();
                        GameModel.getInstance().resetArrays();

                        game.changeScreen(MyFruitGame.Menus.ENDGAME);
                        return;
                        //show score and back to the main menu

                    }
                    if (v.getFruit() == EntityView.Fruits.SPECIAL) {
                        special = true;
                        ((FruitModel) fruit.getUserData()).setCut(true);
                        return;
                    }

                    ((FruitModel) fruit.getUserData()).setCut(true);
                    GameModel.getInstance().addCutFruit(new CutFruitModel(true, (v.getX() - 2) / PPM, v.getY() / PPM, v.getRotation(), v.getFruit()),
                            new CutFruitModel(false, (2 + v.getX()) / PPM, v.getY() / PPM, v.getRotation(), v.getFruit()));

                    if (scoreValue == 0) {
                        yourScoreName = "";
                    }
                    scoreValue++;
                    yourScoreName = scoreValue.toString();


                }

            }
        }


    }

    public static float distSq(Vector2 p1, Vector2 p2) {
        float dx = p1.x * PPM - p2.x, dy = p1.y * PPM - p2.y;
        return dx * dx + dy * dy;
    }

    public boolean Cut(Vector2 v1, Vector2 v2, Body b, float r) {

        if ((distSq(v1, b.getWorldCenter()) < (r * r)) && (distSq(v2, b.getWorldCenter()) < (r * r))) {
            return true;
        }

        return false;
    }

    public void createScore() {

        stage = new Stage(new ScreenViewport());

        FreeTypeFontGenerator.FreeTypeFontParameter title = new FreeTypeFontGenerator.FreeTypeFontParameter();
        title.size = 50;
        title.shadowColor = Color.BLUE;
        title.shadowOffsetY = 3;
        title.shadowOffsetX = 3;

        ScoreFont = generator.generateFont(title);
        yourBitmapFontName = generator.generateFont(title);


    }

    @Override
    public void show() {
        Label scoreB = new Label("SCORE : ", new Label.LabelStyle(ScoreFont, Color.SKY));
        scoreB.setPosition(0, Gdx.graphics.getHeight() - scoreB.getHeight());
        stage.addActor(scoreB);

    }

    static public Integer getScoreValue(){
        return scoreValue;
    }
}



