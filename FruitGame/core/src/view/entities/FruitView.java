package view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyFruitGame;

import java.nio.channels.spi.SelectorProvider;

public class FruitView extends EntityView {

    Texture texture;
    Fruits fruits;

    /**
     * Constructs a bullet view.
     *
     * @param game the game this view belongs to. Needed to access the
     *             asset manager to get textures.
     */
    public FruitView(MyFruitGame game, Fruits fruits) {
        super();

        this.fruits = fruits;
        sprite = createSprite(game);
        sprite.setScale(1.3f);

    }

    /**
     * Abstract method that creates the view sprite. Concrete
     * implementation should extend this method to create their
     * own sprites.
     *
     * @param game the game this view belongs to. Needed to access the
     *             asset manager to get textures.
     * @return the sprite representing this view.
     */
    @Override
    public Sprite createSprite(MyFruitGame game) {
        switch(this.fruits){
            case PLUM:
                texture = game.getAssetManager().get("plum.png", Texture.class);
                break;
            case APPLE:
                texture = game.getAssetManager().get("apple.png", Texture.class);
                break;

            case PEACH:
                texture = game.getAssetManager().get("peach.png", Texture.class);
                break;

            case LEMON:
                texture = game.getAssetManager().get("lemon.png", Texture.class);
                break;

            case STRAW:
                texture = game.getAssetManager().get("strawberry.png", Texture.class);
               break;

            case BANANA:
                texture = game.getAssetManager().get("banana.png", Texture.class);
                break;

            case ORANGE:
                texture = game.getAssetManager().get("orange.png", Texture.class);
                break;

            case WATERMELON:
                texture = game.getAssetManager().get("watermelon.png", Texture.class);
               break;
            case BOMB:
                texture = game.getAssetManager().get("bomb.png", Texture.class);

            case SPECIAL:
                texture = game.getAssetManager().get("special.png", Texture.class);
        }

        return  new Sprite(texture, texture.getWidth(), texture.getHeight());

    }
}
