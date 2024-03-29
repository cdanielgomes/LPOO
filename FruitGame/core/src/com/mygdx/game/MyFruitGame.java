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

public class MyFruitGame extends Game {

	public enum Menus {MAIN, GAME, PREFERENCES, ENDGAME}
	private SpriteBatch batch;
	private AssetManager assetManager;
	private GameView gameView;
	private MainMenuScreen mainMenuScreen;


	
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
        setScreen(mainMenuScreen);
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

    public GameView getGameView(){return this.gameView;}

}
