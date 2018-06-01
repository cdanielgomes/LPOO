package view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyFruitGame;

public class FruitView extends EntityView {

    Texture texture;
    Fruits fruits;
    Texture half1,half2;

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
                half1 = game.getAssetManager().get("plum_half1.png", Texture.class);
                half2 = game.getAssetManager().get("plum_2.png", Texture.class);
                break;
            case APPLE:
                texture = game.getAssetManager().get("apple.png", Texture.class);
                half1 = game.getAssetManager().get("apple_half1.png", Texture.class);
                half2 = game.getAssetManager().get("apple_2.png", Texture.class);
                break;

            case PEACH:
                texture = game.getAssetManager().get("peach.png", Texture.class);
                half1 = game.getAssetManager().get("peach_half1.png", Texture.class);
                half2 = game.getAssetManager().get("peach_2.png", Texture.class);
                break;

            case LEMON:
                texture = game.getAssetManager().get("lemon.png", Texture.class);
                half1 = game.getAssetManager().get("lemon_half1.png", Texture.class);
                half2 = game.getAssetManager().get("lemon_2.png", Texture.class);
                break;

            case STRAW:
                texture = game.getAssetManager().get("strawberry.png", Texture.class);
                half1 = game.getAssetManager().get("strawberry_half1.png", Texture.class);
                half2 = game.getAssetManager().get("strawberry_2.png", Texture.class);
                break;

            case BANANA:
                texture = game.getAssetManager().get("banana.png", Texture.class);
                half1 = game.getAssetManager().get("banana_half1.png", Texture.class);
                half2 = game.getAssetManager().get("banana_2.png", Texture.class);
                break;

            case ORANGE:
                texture = game.getAssetManager().get("orange.png", Texture.class);
                half1 = game.getAssetManager().get("orange_half1.png", Texture.class);
                half2 = game.getAssetManager().get("orange_2.png", Texture.class);
                break;

            default:
                texture = game.getAssetManager().get("watermelon.png", Texture.class);
                half1 = game.getAssetManager().get("watermelon_half1.png", Texture.class);
                half2 = game.getAssetManager().get("watermelon_2.png", Texture.class);
                break;
        }


        return new Sprite(texture, texture.getWidth(), texture.getHeight());
    }
}
