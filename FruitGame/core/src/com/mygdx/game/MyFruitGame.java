package com.mygdx.game;


import com.badlogic.gdx.Game;
import view.GameView;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.assets.AssetManager;

public class MyFruitGame extends Game {

	private SpriteBatch batch;
	private AssetManager assetManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		assetManager = new AssetManager();

		startGame();
	}

    /**
     * Starts the game.
     */
    private void startGame() {
        setScreen(new GameView(this));
    }

	@Override
	public void dispose () {
		batch.dispose();
		assetManager.dispose();
	}

    /**
     * Returns the asset manager used to load all textures and sounds.
     *
     * @return the asset manager
     */
    public AssetManager getAssetManager() {
        return assetManager;
    }


    /**
     * Returns the sprite batch used to improve drawing performance.
     *
     * @return the sprite batch
     */
    public SpriteBatch getBatch() {
        return batch;
    }
}
