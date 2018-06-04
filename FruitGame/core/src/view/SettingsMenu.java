package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyFruitGame;

import javax.xml.soap.Text;

public class SettingsMenu implements Screen {
   /**
     * Game instance
     */
    private MyFruitGame game;
     /**
     * Stage instance
     */
    private Stage stage;
      /**
     * Bitmap fonts instance
     *      
     **/
    private BitmapFont settings, musicfont;
      /**
     *  Free type font generator
     */
    private FreeTypeFontGenerator generator;
     /**
     * Text BUtton Style
     */
    
    TextButton.TextButtonStyle style;

    /**
     * Preferences Menu constructor. Incialize all necessary things
     */
    
    public SettingsMenu(MyFruitGame game) {

        this.game = game;

        generator = new FreeTypeFontGenerator(Gdx.files.internal("myfont.ttf"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        FreeTypeFontParameter parameter2 = new FreeTypeFontParameter();
        parameter.size = 80;
        parameter.color = Color.CORAL;
        parameter.shadowOffsetX = 2;
        parameter.shadowOffsetY = 1;
        settings = generator.generateFont(parameter);
        parameter2.size = 50;
        parameter2.color = Color.BROWN;
        parameter2.shadowOffsetX = 5;
        parameter2.shadowOffsetY = 5;
        musicfont = generator.generateFont(parameter2);
        style = new TextButton.TextButtonStyle();
        style.font = musicfont;


    }


    /**
     * Called when this screen becomes the current screen
     * Create all buttons and labels
     */
    @Override
    public void show() {

        Label title = new Label("SETTINGS", new Label.LabelStyle(settings, Color.CORAL));
        title.setPosition(Gdx.graphics.getWidth() / 2 - title.getWidth() / 2, Gdx.graphics.getHeight() - title.getHeight() - 10);
        Label songs = new Label("Music", new Label.LabelStyle(settings, Color.CORAL));
        final Label musics = new Label("Song", new Label.LabelStyle(settings, Color.CORAL));


        TextButton enablem = new TextButton("enable", style);
        TextButton disablem = new TextButton("disable", style);
        TextButton enables = new TextButton("enable", style);
        TextButton disables = new TextButton("disable", style);
        TextButton back = new TextButton("back", style);

        songs.setPosition(Gdx.graphics.getWidth() / 2 - songs.getWidth() / 2, Gdx.graphics.getHeight() - title.getHeight() - songs.getHeight() - 130);
        musics.setPosition(Gdx.graphics.getWidth() / 2 - musics.getWidth() / 2, Gdx.graphics.getHeight() - musics.getHeight() - title.getHeight() - 130 - songs.getHeight());
        enables.setPosition(Gdx.graphics.getWidth() / 2 - musics.getWidth() / 2 - enablem.getWidth(), musics.getY());
        enablem.setPosition(Gdx.graphics.getWidth() / 2 - musics.getWidth() / 2 - enablem.getWidth(), songs.getY());
        disables.setPosition(Gdx.graphics.getWidth() / 2 - musics.getWidth() / 2 + enablem.getWidth(), musics.getY());
        disablem.setPosition(Gdx.graphics.getWidth() / 2 - musics.getWidth() / 2 + enablem.getWidth(), songs.getY());
        back.setPosition(Gdx.graphics.getWidth() / 2 - back.getWidth() / 2, back.getWidth());


        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                game.changeScreen(MyFruitGame.Menus.MAIN);
            }
        });

        enablem.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenuScreen.getMusic().setVolume(1);


            }
        });

        disables.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenuScreen.getSound().stop();
                game.getGameView().sound = false;
            }
        });

        disablem.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                MainMenuScreen.getMusic().setVolume(0);
            }
        });

        enables.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.getGameView().sound = true;
                MainMenuScreen.getSound().resume();

            }
        });

        stage.addActor(songs);
        stage.addActor(musics);
        stage.addActor(back);

        stage.addActor(enablem);
        stage.addActor(enables);
        stage.addActor(disablem);
        stage.addActor(disables);

        stage.addActor(title);
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        drawBG();
        game.getBatch().end();
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
     * Called when this screen is no longer the current screen for a {@link MyFruitGame}.
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
     * Draw Preferences Menu Background
     */
    
    public void drawBG() {
        Texture t = game.getAssetManager().get("defeatBG.jpg", Texture.class);
        game.getBatch().draw(t, t.getWidth(), t.getHeight());
    }
}
