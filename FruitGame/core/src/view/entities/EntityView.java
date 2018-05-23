package view.entities;

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


        /**
         * The sprite representing this entity view.
         */
        private Sprite sprite;

        /**
         * Creates a view belonging to a game.
         *
         * @param game the game this view belongs to. Needed to access the
         *             asset manager to get textures.
         */
       public EntityView(MyFruitGame game) {
            sprite = createSprite(game);
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
        public abstract Sprite createSprite(MyFruitGame game);

        /**
         * Updates this view based on a certain model.
         *
         * @param model the model used to update this view
         */
        public void update(EntityModel model) {
            sprite.setCenter(model.getX() / 0.04f, model.getY() / 0.04f);
            sprite.setRotation((float) Math.toDegrees(model.getRotation()));
        }
}
