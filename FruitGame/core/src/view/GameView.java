package view;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyFruitGame;
import java.util.List;

import controller.GameController;

import model.GameModel;
import model.entities.FruitModel;
import view.entities.FruitView;

public class GameView extends ScreenAdapter{


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
     * The width of the viewport in meters. The height is
     * automatically calculated using the screen ratio.
     */
    private static final float VIEWPORT_WIDTH = 30;

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

public GameView(MyFruitGame game){
    this.game = game;

    loadAssets();

   camera = createCamera();

}


    private void loadAssets(){

         this.game.getAssetManager().load("watermelon.png", Texture.class);
         this.game.getAssetManager().load("background.png",Texture.class);
        this.game.getAssetManager().load("banana.png", Texture.class);
        this.game.getAssetManager().load("lemon.png",Texture.class);
        this.game.getAssetManager().load("apple.png", Texture.class);
        this.game.getAssetManager().load("strawberry.png",Texture.class);
        this.game.getAssetManager().load("peach.png", Texture.class);
        this.game.getAssetManager().load("plum.png",Texture.class);
        this.game.getAssetManager().load("orange.png", Texture.class);

        this.game.getAssetManager().finishLoading();
    }

    /**
     * Creates the camera used to show the viewport.
     *
     * @return the camera
     */
    private OrthographicCamera createCamera() {
        OrthographicCamera camera = new OrthographicCamera(VIEWPORT_WIDTH / PPM, VIEWPORT_WIDTH / PPM * ((float) Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth()));

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

        //camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor( 0f, 0f, 0f, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );


        game.getBatch().begin();
        drawBackground();
        drawEntities();
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

    private void drawEntities(){
        List<FruitModel> fruitModels;

       /// GameModel.getInstance().checkBounds();
        fruitModels = GameModel.getInstance().getFruits();

        for(FruitModel fruit : fruitModels) {

           // System.out.println("posicao Antes " + fruit.getX() + "," + fruit.getY());

            FruitView view = new FruitView(this.game, fruit.getFruit());


            view.update(fruit);
            view.draw(game.getBatch());

        }



//       GameModel.getInstance().checkBounds();

        System.out.print(GameModel.getInstance().getFruits().size());

    }

    /**
     * Draws the background
     */
    private void drawBackground() {
        Texture background = game.getAssetManager().get("background.png", Texture.class);
        game.getBatch().draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
    }

    private void backButton (){

    }
}
