package logic;

import java.util.ArrayList;

/**
 * Class that has the information of the state of the current game
 */

public class GameState {
	private ArrayList<GameMap> gameMaps = new ArrayList<GameMap>(); 
	private GameMap map;
	private String guard;
	private int nOgres;
	private boolean won = false;
	private int level = 0;

	private char[][] map1 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'X','H',' ',' ','I',' ','X',' ','G','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'X',' ','I',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X',' ','X','X','X','X',' ','X'},
			{'X',' ','I',' ','I',' ','X','k',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}
	};


	private char[][] map2 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ','O',' ',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','H',' ',' ','*',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}
	};	

	/**
	 * Constructor of class GameState
	 * @param numogres number of ogres
	 * @param guard guard type
	 * 
	 */
	public GameState(int numogres, String guard) {
		this.nOgres = numogres;
		this.guard = guard;

		initializeGame();

	};


	/**
	 * Sets all the variables for the game 
	 * and starts the game
	 */

	public void initializeGame() {
		ArrayList<Door> i = new ArrayList<Door>(); 
		char[] moves = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd',
				'd', 'w', 'w', 'w', 'w', 'w' };
		i.add(new Door(new Position(0,5)));
		i.add(new Door(new Position(0,6)));
		GameMap m =  new Dungeon(map1,guard, i, moves);
		gameMaps.add(m);
		m = new Keep(map2,nOgres);
		gameMaps.add(m);
		this.map = gameMaps.get(level);

	}

	/**
	 * Changes guard variable
	 * @param guard guard type name
	 */
	public void setGuard(String guard) {
		this.guard = guard;
	}

	/**	
	 * Changes number of ogres in game
	 * @param i number of ogres
	 */
	public void setnOgres(int i ) {
		this.nOgres = i;
	}

	/**
	 * Starts the game , resets the level
	 */
	public void start_game() {
		this.won = false;
		this.level = 0;

		this.map = gameMaps.get(level);

	}

	/**
	 * Makes the movement of the hero
	 * @param hero new move of hero
	 */

	public void movement(char hero) {

		map.deleteOldPositions();
		map.autoMoves(hero);
		map.setNewPositions();

		if (map.hero.nextLevel()) {
			if (level + 1 < gameMaps.size()) {
				level++;
				map = gameMaps.get(level);
			}
			else 
				won = true;
		}
	}

	/**
	 * Displays the map
	 */
	public void display() {
		System.out.println(map.tostring());
	}

	/**	
	 * Returns the flag over
	 * @return true if gameover or won , false if not
	 */
	public boolean over() {
		return map.endOfGame() || won;
	}

	/**
	 * Returns won flag
	 * @return true if won , false if not
	 */

	public boolean hasWon() {
		return this.won;
	}

	/**
	 * Returns map variable 
	 * @return map of type GameMap
	 */

	public GameMap getMap() {
		return map;
	}

	/**
	 * Changes variable map of class
	 * @param map map of type GameMap
	 */
	public void setMap(GameMap map) {
		this.map = map;
	}

	/**
	 * Adds new GameMap
	 * @param m of type GameMap
	 */

	public void addMap(GameMap m) {
		gameMaps.set(1, m);

	}
}
