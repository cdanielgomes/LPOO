package logic;

import java.util.ArrayList;
import java.util.Random;

public class GameState {

	private	int gameOver;
	private int gameWon; 
	private int gameEnd;
	private int nextLevel = 0;
	private Labirinths map;// = new Labirinths();
	private Map currentMap;// = map.getMap();
	private Lever lever;// = new Lever(currentMap.getCharcX('k'), currentMap.getCharcY('k'), currentMap);
	private Hero hero;// = new Hero(currentMap.getCharcX('H'), currentMap.getCharcY('H'), currentMap, lever);
	private Guard guard;
	private ArrayList<Ogre> hordOfOgres = new ArrayList<Ogre>();
	private boolean hasGuard, hasOgre;



	public GameState() {

		this.gameOver = 0;
		this.gameWon = 0;
		this.gameEnd = 0;
		this.nextLevel = 0;
		this.map = new Labirinths();
		this.currentMap = map.getMap();

	}


<<<<<<< HEAD
	public void chooseGuard(int i) {	
=======
	public void chooseGuard() {
		this.guard = new Drunken(currentMap.getCharcX('G'), currentMap.getCharcY('G'),currentMap , "Drunken");

		Random r = new Random();
		int i = r.nextInt(3);
>>>>>>> d9128d0905635c3d6f787e1175a9d03703b57f65
		switch(i) {
		case 1 : 
			this.guard = new Drunken(currentMap.getCharcX('G'), currentMap.getCharcY('G'),currentMap , "Drunken");
			break;
		case 3 : 
			this.guard = new Suspicious(currentMap.getCharcX('G'), currentMap.getCharcY('G'),currentMap , "Suspicious");
			break;
		case 2 :
			this.guard = new Rookie(currentMap.getCharcX('G'), currentMap.getCharcY('G'),currentMap , "Rookie");
			break;
		}

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



		if (currentMap.getCharcX('G') == -1) {
			this.hasGuard = false;
		}
		else {
			this.hasGuard = true;
		}

		if (currentMap.getCharcX('O') == -1) {
			this.hasOgre = false;
		}
		else{
			for (int i = 0; i < 3; i++) {
				hordOfOgres.add(new Ogre(currentMap.getCharcX('O'), currentMap.getCharcY('O'),currentMap));

			}
			this.hasOgre = true;
		}

		lever = new Lever(currentMap.getCharcX('k'), currentMap.getCharcY('k'), currentMap);
		hero = new Hero(currentMap.getCharcX('H'), currentMap.getCharcY('H'), currentMap, lever);


	}



	@SuppressWarnings("unlikely-arg-type")
	public void updateGame(char heroMove) {

		hero.getMove(heroMove);

		if(hero.isOnStairs()) {
			map.setLevel(map.getLevel() + 1);
			this.nextLevel = 1;
			hero.setOnStairs(false);
			currentMap = map.getMap();
			return;
		}


		if(hasGuard) {
			guard.movement();
		}

		if(hasOgre) {
			for(Ogre i : hordOfOgres) {
				i.ogreMove();
				if(!i.getKeyFlag() && !lever.getKey()) {
					currentMap.setMapSymbol(lever.getX(), lever.getY(), lever.getSymbol());
				}
			}
		}

		if (checkColisions()) {
			this.gameOver = 1;
			System.out.println("You lost the Game");
		}

		if (hero.equals(lever) && map.getLevel() == 0) { //change the doors when the Hero push the lever

			currentMap.setMapSymbol(0, 5, 'S');
			currentMap.setMapSymbol(0, 6, 'S');
		}

		if(hero.getX() == 0 && hero.getY() == 1 && map.getLevel() == (map.getMaps().size() - 1)) {
			System.out.print("You have finished the game ! Congrats\n");
			this.gameWon = 1;
		}   

	}

	private boolean checkColisions() {
		if(hasGuard)
			return guard.nextToMe(hero.getX(), hero.getY()) && (!guard.getasleep());

		if (hasOgre) {
			for(Ogre index : hordOfOgres) {
				if(index.nextToMe(hero.getX(), hero.getY()) || index.nextToWeapon(hero.getX(), hero.getY())) {
					return true;
				}
			}
		}

		return false;
	}


	public void display() {

		currentMap.printmap();
	}


	public int getNextLevel() {
		return nextLevel;
	}





	public void setNextLevel(int nextLevel) {
		this.nextLevel = nextLevel;
	}


	public Guard getGuard() {
		return this.guard;
	}


}
