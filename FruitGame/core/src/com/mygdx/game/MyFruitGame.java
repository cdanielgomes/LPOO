package com.mygdx.game;


import com.badlogic.gdx.Game;

import controller.CutHandler;
import model.GameModel;
import view.GameView;
import view.LoseView;
import view.MainMenuScreen;
import view.SettingsMenu;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.assets.AssetManager;

/**
 * The game class
 *
 * Takes care of the controller , model and view entities.
 */

public class MyFruitGame extends Game {


	public enum Menus {MAIN, GAME, PREFERENCES, ENDGAME}

	/**
	 *  The batch
	 */
	private SpriteBatch batch;

	/**
	 *
	 *	The assetManager field
	 */
	private AssetManager assetManager;

	/**
	 *
	 *	The GameView field
	 */
	private GameView gameView;

	/**
	 * The MainMenuScreen field
	 * 
	 */
	private MainMenuScreen mainMenuScreen;


	/**
	 * 
	 * 	Creates the game
	 */
	
	@Override
	public void create () {
        boolean available = Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);
		if (!available){
            Gdx.app.exit();
        }
		batch = new SpriteBatch();
		assetManager = new AssetManager();
		gameView = new GameView(this);
		mainMenuScreen = new MainMenuScreen(this);
		startGame();
	}

    /**
     * Starts the game.
     */
    private void startGame() {
        setScreen(new MainMenuScreen(this));
    }

    /**
     * Disposes fields
     */

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


    /**
     * 	Function that changes the screen
     * 
     * @param screen the screen
     */
	public void changeScreen(Menus screen){
		switch(screen){
			case MAIN:
				this.setScreen(new MainMenuScreen(this));
				break;

			case PREFERENCES:
				this.setScreen(new SettingsMenu(this));
				break;

			case GAME:
				this.setScreen(new GameView(this));
				break;

			case ENDGAME:
				this.setScreen(new LoseView(this));
				break;
		}
	}

	/**
	 *  Gets the GameView
	 * 
	 * @return returns the GameView field
	 */

    public GameView getGameView(){return this.gameView;}

}
