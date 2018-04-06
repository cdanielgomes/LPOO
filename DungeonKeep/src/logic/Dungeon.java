package logic;

import java.util.ArrayList;

/**
 * Class which has all the information of the first level of the game (Guard level)
 *  Extends GameMap
 */

public class Dungeon extends GameMap {

	private Guard guard;
	
	/**
	 * Constructor of class Dungeon
	 * @param map map used in Dungeon level
	 * @param i name of the guard type
	 * @param door ArrayList that contains the exits of the map
	 * @param guardMove char array with the moves of the guard
	 * 
	 */
	public Dungeon(char[][] map, String i, ArrayList<Door> door, char[] guardMove) {
		super(map);
		this.door = door;
		setGuard(i, guardMove);

	}

<<<<<<< Updated upstream

=======
	// not using
	public Dungeon(Dungeon d) {
		super(d);
		this.door = d.door;
		this.guard = d.guard;
	}

	/**
	 *  Sets the guard type
	 * @param i name of the guard type
	 * @param guardMove	char array with the moves of the guard
	 */
>>>>>>> Stashed changes
	
	public void setGuard(String i, char[] guardMove) {

		switch(i) {
		case "Rookie":
			guard = new Rookie(this.getCharc('G'), "Rookie", guardMove);
			break;
		case "Suspicious":
			guard = new Suspicious(this.getCharc('G'), "Suspicious", guardMove);
			break;
		case "Drunken":
			guard = new Drunken(this.getCharc('G'), "Drunken", guardMove);
			break;
		}
	}
	
	/**
	 * Returns guard of type Guard
	 * @return guard variable 
	 */
	public Guard getGuard() {
		return guard;
	}

	/**
	 * Boolean function that checks if is gameover
	 * @return true if gameover (guard next to hero and guard not asleep) , false if not
	 */
	public boolean endOfGame() {
		return guard.checkProximity(hero) && !guard.asleep;

	}

	/**
	 * Delet Position of hero and guard
	 */
	
	@Override
	public void deleteOldPositions() {
		deleteCell(hero);
		deleteCell(guard);
	}

	/**
	 * Set new Postion of hero and guard
	 */
	@Override
	public void setNewPositions() {
		setMapSymbol(guard);
		setMapSymbol(hero);
	} 

	/**
	 * Computes next move of hero
	 * @param heromove direction of the new move
	 */
	@Override
	public void autoMoves(char heromove) {
		hero.calculateNextPos(this, heromove);
		guard.movement();
	}



}
