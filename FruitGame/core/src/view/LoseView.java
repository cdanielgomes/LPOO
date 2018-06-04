package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyFruitGame;

public class LoseView implements Screen {
     /**
     * Background texture
     */
    private Texture background;
    /**
     * Game instance
     */
    private final MyFruitGame game;
   /**
     * Batch instance
     */
    private SpriteBatch batch;
   /**
     * Stage instance
     */
    private Stage stage;
    /**
     *  Free type font generator
     */
    private FreeTypeFontGenerator generator;
    /**
     * Text BUtton Style
     */
    private TextButton.TextButtonStyle style;
    /**
     * Bitmap Font
     */
    private BitmapFont font12;

    /**
     * Constructor of the loose menu
     * 
     * @param game Game  
     */
    public LoseView(MyFruitGame game){

        this.game = game;
        this.batch = new SpriteBatch();

        this.background = new Texture("defeatBG.jpg");

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("myfont.ttf"));

        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 100;
        parameter.color = Color.WHITE;
        parameter.shadowColor = Color.CHARTREUSE;
        parameter.shadowOffsetX = 3;
        parameter.shadowOffsetY = 3;

        style = new TextButton.TextButtonStyle();
        font12 = generator.generateFont(parameter); // font size 12 pixels
        style.font = font12;



    }



     /**
     * Add all buttons to the stage
     */
    @Override
    public void show() {

        TextButton menu = new TextButton("MENU", style);
        TextButton exit = new TextButton("EXIT", style);
        Label score = new Label( "SCORE: " + GameView.getScoreValue(),new Label.LabelStyle(font12, Color.GOLD));
        Label gameOver = new Label( "GAME OVER",new Label.LabelStyle(font12, Color.GREEN));

        menu.setPosition(Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 5);
        exit.setPosition(Gdx.graphics.getWidth() -30 - exit.getWidth(), menu.getY());

        score.setPosition(Gdx.graphics.getWidth() / 2 - score.getWidth(), Gdx.graphics.getHeight() / 2);
        gameOver.setPosition(Gdx.graphics.getWidth() / 2- gameOver.getWidth()/2, Gdx.graphics.getHeight() - gameOver.getHeight());

        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                Gdx.app.exit();
            }
        });

        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                game.changeScreen(MyFruitGame.Menus.MAIN);
            }
        });
        stage.addActor(gameOver);

        stage.addActor(score);
        stage.addActor(menu);
        stage.addActor(exit);

    }

    /**
     * Image rendering 
     * 
     * @param delta Time in seconds since the last render
     */
    @Override
    public void render(float delta) {

        this.batch.begin();
        drawBackGround();
        this.batch.end();
        stage.draw();
    }


     /**
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {

    }
    /**
     */
    @Override
    public void pause() {

    }

     /**
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a
     */
    @Override
    public void hide() {

    }

 /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {

    }

    /**
     * Draw background
     */
    public void drawBackGround(){
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}
