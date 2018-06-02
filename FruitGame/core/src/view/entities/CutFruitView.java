package view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyFruitGame;

public class CutFruitView extends EntityView {

    private final Fruits fruits;

    Texture half1,half2;

   public CutFruitView(MyFruitGame game, Fruits fruits){
        super();
        this.fruits = fruits;
        sprite = createSprite(game);
        sprite.setScale(1.3f);
        if(sprite2 != null){

            sprite2.setScale(1.3f);


        }

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
                half1 = game.getAssetManager().get("half1_plum.png", Texture.class);
                half2 = game.getAssetManager().get("half2_plum.png", Texture.class);
                break;
            case APPLE:
                half1 = game.getAssetManager().get("half1_apple.png", Texture.class);
                half2 = game.getAssetManager().get("half1_apple.png", Texture.class);
                break;

            case PEACH:
                half1 = game.getAssetManager().get("half1_peach.png", Texture.class);
                half2 = game.getAssetManager().get("half2_peach.png", Texture.class);
                break;

            case LEMON:
                half1 = game.getAssetManager().get("half1_lemon.png", Texture.class);
                half2 = game.getAssetManager().get("half2_lemon.png", Texture.class);
                break;

            case STRAW:
                half1 = game.getAssetManager().get("half1_strawberry.png", Texture.class);
                half2 = game.getAssetManager().get("half2_strawberry.png", Texture.class);
                break;

            case BANANA:
                half1 = game.getAssetManager().get("half1_banana.png", Texture.class);
                half2 = game.getAssetManager().get("half2_banana.png", Texture.class);
                break;

            case ORANGE:
                half1 = game.getAssetManager().get("half1_orange.png", Texture.class);
                half2 = game.getAssetManager().get("half2_orange.png", Texture.class);
                break;

            default:
                half1 = game.getAssetManager().get("half1_watermelon.png", Texture.class);
                half2 = game.getAssetManager().get("half2_watermelon.png", Texture.class);
                break;
        }

        sprite2 = new Sprite(half1, half1.getWidth(), half1.getHeight());


        return new Sprite(half2, half2.getWidth(), half2.getHeight());
    }

}
