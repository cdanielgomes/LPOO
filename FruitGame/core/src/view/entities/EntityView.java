package view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyFruitGame;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.entities.EntityModel;


/**
 * A abstract view capable of holding a sprite with a certain
 * position and rotation.
 *
 * This view is able to update its data based on a entity model.
 */

public abstract class EntityView {

    public enum Fruits{
        WATERMELON, BANANA, LEMON, ORANGE, PEACH, PLUM, APPLE, STRAW
    }

        /**
         * The sprite representing this entity view.
         */
        Sprite sprite;

        /**
         * Creates a view belonging to a game.
         *
         * @param game the game this view belongs to. Needed to access the
         *             asset manager to get textures.
         */
       public EntityView(MyFruitGame game, Fruits fruits) {
            sprite = createSprite(game, fruits);
        }

        /**
         * Draws the sprite from this view using a sprite batch.
         *
         * @param batch The sprite batch to be used for drawing.
         */

        public void draw(SpriteBatch batch) {
              sprite.draw(batch);   
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
        public abstract Sprite createSprite(MyFruitGame game, Fruits fruits);

        /**
         * Updates this view based on a certain model.
         *
         * @param model the model used to update this view
         */
        public void update(EntityModel model) {
            sprite.setCenter(model.getX(), model.getY());
           //sprite.setRotation((float) Math.toDegrees(model.getRotation()));
        }
}
