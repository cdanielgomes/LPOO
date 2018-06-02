package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.mygdx.game.MyFruitGame;


public class MainMenuScreen implements Screen {
    private SpriteBatch batch;
    private final MyFruitGame game;
    Stage stage;
    BitmapFont font12;
    TextButton.TextButtonStyle style;
    FreeTypeFontGenerator generator;
    TextButton.TextButtonStyle Title;
    BitmapFont TitleFont;
    Music music;
    public MainMenuScreen(MyFruitGame game){
       this.game = game;
       this.batch = new SpriteBatch();
       this.game.getAssetManager().load("menubackground.jpg", Texture.class);
        this.game.getAssetManager().load("music.mp3", Music.class);
        this.music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        stage = new Stage (new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);
        generator = new FreeTypeFontGenerator(Gdx.files.internal("myfont.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 75;
        parameter.color = Color.WHITE;
        parameter.shadowColor = Color.CHARTREUSE;
        parameter.shadowOffsetX = 3;
        parameter.shadowOffsetY = 3;
        FreeTypeFontGenerator.FreeTypeFontParameter title = new FreeTypeFontGenerator.FreeTypeFontParameter();
        title.size = 150;
        title.shadowColor = Color.BLUE;
        title.shadowOffsetY = 3;
        title.shadowOffsetX = 3;

        style = new TextButton.TextButtonStyle();
        font12 = generator.generateFont(parameter); // font size 12 pixels
        style.font = font12;
        Title = new TextButton.TextButtonStyle();
        TitleFont = generator.generateFont(title);
        Title.font = TitleFont;

    }



    @Override
    public void show() {
        //create buttons
        TextButton newGame = new TextButton("New Game", style);
        TextButton preferences = new TextButton("Preferences", style);
        TextButton exit = new TextButton("Exit", style);
        Label title  = new Label("FRUiT GAME", new Label.LabelStyle(TitleFont, Color.SKY));
        newGame.setPosition(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/5);
        // create button listeners
        preferences.setPosition(newGame.getX() + newGame.getWidth() +34, newGame.getY());
        exit.setPosition(preferences.getX() + preferences.getWidth() + 34, preferences.getY());


        title.setPosition(Gdx.graphics.getWidth()/2 -title.getWidth()/2, Gdx.graphics.getHeight() - title.getHeight() - 30);

        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                Gdx.app.exit();
            }
        });

        newGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                game.changeScreen(MyFruitGame.Menus.GAME);
            }
        });

        preferences.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y)  {
                game.changeScreen(MyFruitGame.Menus.PREFERENCES);
            }
        });

        music.play();
        stage.addActor(newGame);
        stage.addActor(exit);
        stage.addActor(preferences);
        stage.addActor(title);



    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {

// clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        drawBackground();
        batch.end();
        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();


    }

    /**
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        generator.dispose();
    }

    public void drawBackground(){

        Texture background = new Texture("menubackground.jpg");
        batch.draw(background, 0, 0, Gdx.graphics.getWidth() , Gdx.graphics.getHeight());

    }

}
