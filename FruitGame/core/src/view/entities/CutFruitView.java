package view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyFruitGame;

import model.entities.CutFruitModel;

public class CutFruitView extends EntityView {

    private final Fruits fruits;
    private final boolean half;


    public CutFruitView(MyFruitGame game, CutFruitModel cut) {
        super();
        this.fruits = cut.getFruits();
        sprite = createSprite(game);
        sprite.setScale(1.3f);
        this.half = cut.getHalf();

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

        Texture texture;
        switch (this.fruits) {
            case PLUM:
                if (half)
                    texture = game.getAssetManager().get("half1_plum.png", Texture.class);
                else texture = game.getAssetManager().get("half2_plum.png", Texture.class);
                break;
            case APPLE:
                if (half)
                    texture = game.getAssetManager().get("half1_apple.png", Texture.class);
                else
                    texture = game.getAssetManager().get("half2_apple.png", Texture.class);
                break;

            case PEACH:
                if (half)
                    texture = game.getAssetManager().get("half1_peach.png", Texture.class);
                else
                    texture = game.getAssetManager().get("half2_peach.png", Texture.class);
                break;

            case LEMON:
                if (half)
                    texture = game.getAssetManager().get("half1_lemon.png", Texture.class);
                else
                    texture = game.getAssetManager().get("half2_lemon.png", Texture.class);
                break;

            case STRAW:
                if (half)
                    texture = game.getAssetManager().get("half1_strawberry.png", Texture.class);
                else
                    texture = game.getAssetManager().get("half2_strawberry.png", Texture.class);
                break;

            case BANANA:
                if (half)
                    texture = game.getAssetManager().get("half1_banana.png", Texture.class);
                else
                    texture = game.getAssetManager().get("half2_banana.png", Texture.class);
                break;

            case ORANGE:
                if (half)
                    texture = game.getAssetManager().get("half1_orange.png", Texture.class);
                else
                    texture = game.getAssetManager().get("half2_orange.png", Texture.class);
                break;

           case SPECIAL:
            if (half)
                texture = game.getAssetManager().get("half1_special.png", Texture.class);
            else
                texture = game.getAssetManager().get("half2_special.png", Texture.class);
            break;

            default:
                if (half)
                    texture = game.getAssetManager().get("half1_watermelon.png", Texture.class);
                else
                    texture = game.getAssetManager().get("half2_watermelon.png", Texture.class);
                break;


        }


        return new Sprite(texture, texture.getWidth(), texture.getHeight());
    }

}
