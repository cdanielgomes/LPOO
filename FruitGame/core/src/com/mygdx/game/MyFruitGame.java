package com.mygdx.game;


import com.badlogic.gdx.Game;
import view.GameView;
import view.MainMenuScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.assets.AssetManager;

public class MyFruitGame extends Game {

	public enum Menus {MAIN, GAME, PREFERENCES, ENDGAME}
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

	public void changeScreen(Menus screen){
		switch(screen){
			case MAIN:
				this.setScreen( new MainMenuScreen(this));
				break;
			case PREFERENCES:
			//	if(preferencesScreen == null) preferencesScreen = new PreferencesScreen();
			//	this.setScreen(preferencesScreen);
				break;
			case GAME:
			this.setScreen(new GameView(this));
				break;
			case ENDGAME:
			//	if(endScreen == null) endScreen = new EndScreen();
			//	this.setScreen(endScreen);
				break;
		}
	}
}
