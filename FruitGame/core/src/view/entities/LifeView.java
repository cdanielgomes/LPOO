package view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyFruitGame;

public class LifeView extends EntityView {


    Texture texture;

    public LifeView(MyFruitGame game){
        super();
        sprite = createSprite(game);
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
       texture = game.getAssetManager().get("life.png", Texture.class);

        return new Sprite(texture, texture.getWidth(), texture.getHeight());
    }
}
