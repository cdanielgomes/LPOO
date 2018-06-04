package view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyFruitGame;

/**
 *
 * Class used to represent the Limit's entity view
 */
public class LimitView extends EntityView {

    Texture texture;

    /**
     * Constructs a Limit view.
     *
     * @param game the game this view belongs to. Needed to access the
     *             asset manager to get textures.
     */
    public LimitView(MyFruitGame game) {

        super();

        sprite = createSprite(game);

    }

    /**
     * Abstract method that creates the view sprite. Concrete
     * implementation should extend this method to create their
     * own sprites.
     *
     * @param game   the game this view belongs to. Needed to access the
     *               asset manager to get textures
     * @return the sprite representing this view.
     */
    @Override
    public Sprite createSprite(MyFruitGame game) {
        texture = game.getAssetManager().get("wall.png", Texture.class);

        return new Sprite(texture, texture.getWidth(), texture.getHeight());

    }


}
