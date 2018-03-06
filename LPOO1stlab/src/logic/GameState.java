package logic;

public class GameState {

	private	int gameOver;
	private int gameWon; 
	private int gameEnd;
	private int nextLevel;
	private char[][] currentMap;
	private Map map = new Map();
	private Lever lever = new Lever(map.getCharcX('k'), map.getCharcY('k'), map);
	private Hero hero = new Hero(map.getCharcX('H'), map.getCharcY('H'), map, lever);
	private Guard guard;
	private Ogre ogre;
	private boolean hasGuard, hasOgre;



	public GameState() {

		this.gameOver = 0;
		this.gameWon = 0;
		this.gameEnd = 0;
		this.setNextLevel(0);

	}





	/**
	 * @return the gameOver
	 */
	public int getGameOver() {
		return gameOver;
	}


	/**
	 * @param gameOver the gameOver to set
	 */
	public void setGameOver(int gameOver) {
		this.gameOver = gameOver;
	}


	/**
	 * @return the gameWon
	 */
	public int getGameWon() {
		return gameWon;
	}


	/**
	 * @param gameWon the gameWon to set
	 */
	public void setGameWon(int gameWon) {
		this.gameWon = gameWon;
	}





	/**
	 * @return the gameEnd
	 */
	public int getGameEnd() {
		return gameEnd;
	}





	/**
	 * @param gameEnd the gameEnd to set
	 */
	public void setGameEnd(int gameEnd) {
		this.gameEnd = gameEnd;
	}





	public void setEnemies() {
		
		if (map.getCharcX('G') == -1) {
			this.hasGuard = false;
		}
		else {
			guard = new Guard(map.getCharcX('G'), map.getCharcY('G'),map);
			this.hasGuard = true;
		}

		if (map.getCharcX('O') == -1) {
			this.hasOgre = false;
		}
		else{
			ogre = new Ogre(map.getCharcX('O'), map.getCharcY('O'),map);
			this.hasOgre = true;
		}

		lever = new Lever(map.getCharcX('k'), map.getCharcY('k'), map);
		hero = new Hero(map.getCharcX('H'), map.getCharcY('H'), map, lever);


	}



	public void updateGame() {

		hero.getMove();

		if(hero.isOnStairs()) {
			map.setLevel(map.getLevel() +1);
			this.nextLevel = 1;
			hero.setOnStairs(false);
			return;
		}

		if(hasGuard) {
			guard.movement();
		}

		if(hasOgre) {
			ogre.ogreMove();
		}

		if (checkColisions()) {
			this.gameOver = 1;
			System.out.println("You lost the Game");
		}

		if (hero.equals(lever) && map.getLevel() == 0) { //change the doors when the Hero push the lever

			map.setMapSymbol(0, 5, 'S');
			map.setMapSymbol(0, 6, 'S');
		}

		if(hero.getY() == 0 && map.getLevel() == 1) {
			System.out.print("You have finished the game ! Congrats\n");
			this.gameWon = 1;
		}
		
		
	}

	private boolean checkColisions() {
		if(hasGuard)
			return guard.nextToMe(hero.getX(), hero.getY()) && (!guard.getasleep());

		if (hasOgre) {
			return ogre.nextToMe(hero.getX(), hero.getY()) || ogre.nextToWeapon(hero.getX(), hero.getY());
		}

		return false;
	}


	public void display() {
		map.printmap();
	}





	public int getNextLevel() {
		return nextLevel;
	}





	public void setNextLevel(int nextLevel) {
		this.nextLevel = nextLevel;
	}





}