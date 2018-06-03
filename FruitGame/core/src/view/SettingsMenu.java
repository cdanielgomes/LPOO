package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyFruitGame;

public class SettingsMenu implements Screen {

    private MyFruitGame game;
    private Stage stage;
    private BitmapFont settings;
    private FreeTypeFontGenerator generator;

    public SettingsMenu(MyFruitGame game){
        System.out.println("ohpiças");
        this.game = game;

        generator = new FreeTypeFontGenerator(Gdx.files.internal("myfont.ttf"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 60;
        parameter.color = Color.CORAL;
        parameter.shadowOffsetX = 2;
        parameter.shadowOffsetY = 1;
        settings = generator.generateFont(parameter);


    }


    /**
     * Called when this screen becomes the current screen for a {@link MyFruitGame}.
     */
    @Override
    public void show() {

        Label title = new Label("SETTINGS", new Label.LabelStyle(settings, Color.CORAL));
        title.setPosition(Gdx.graphics.getWidth() / 2 - title.getWidth() / 2, Gdx.graphics.getHeight() - title.getHeight() - 30);



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
}
