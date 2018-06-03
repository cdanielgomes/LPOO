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
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyFruitGame;

public class LoseView implements Screen {

    private Texture background;
    private final MyFruitGame game;
    private SpriteBatch batch;
    private Stage stage;
    private FreeTypeFontGenerator generator;
    private TextButton.TextButtonStyle style;
    private BitmapFont font12;

    public LoseView(MyFruitGame game){

        this.game = game;
        this.batch = new SpriteBatch();
        this.game.getAssetManager().load("defeatBG.jpg", Texture.class);

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




    @Override
    public void show() {

        TextButton menu = new TextButton("MENU", style);
        TextButton exit = new TextButton("EXIT", style);

        menu.setPosition(Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() / 5);
        exit.setPosition(menu.getX() + menu.getWidth() + 100, menu.getY());

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

        stage.addActor(menu);
        stage.addActor(exit);

    }

    @Override
    public void render(float delta) {

        this.batch.begin();
        drawBackGround();
        this.batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }


    @Override
    public void dispose() {

    }

    public void drawBackGround(){
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}
