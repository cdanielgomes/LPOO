package logic;

import java.util.ArrayList;


/**
 *  Abstraction of the different levels of the game
 */
public abstract class GameMap {
	protected char[][] map;
	protected int collum;
	protected int lines;

	protected Hero hero;
	protected Lever lever;
	protected ArrayList<Door> door = new ArrayList<Door>();

	/**
	 * Constructor of the class GameMap
	 * @param map map of the game
	 * 
	 */

	public GameMap(char[][] map) {
		this.map = map;
		this.collum = map.length;
		this.lines = map[0].length;
		this.hero = new Hero(getCharc('H'));
		this.lever = new Lever(getCharc('k'));

	}
<<<<<<< Updated upstream
=======


	// no used
	
	public GameMap(GameMap t) {
		this.map = t.map;
		this.collum = t.collum;
		this.lines = t.lines;
		this.hero = t.hero;
		this.lever = t.lever;
>>>>>>> Stashed changes



	/**
	 * Function that returns the Postion of the character in the map
	 * @param charac symbol of the map
	 * @return Position of the symbol
	 */

	public Position getCharc(char charac) {
		for (int i = 0; i < collum; i++) {
			for (int b = 0; b < lines; b++) {
				if(this.map[i][b] == charac){
					return new Position(b,i);
				}
			}
		}
		return new Position(-1,-1);
	}

	/**
	 * Function that gets the char value in map with a Position
	 * @param symbol Position of the symbol in the map
	 * @return value of the symbol (char)
	 */


	public char getMapSymbol(Position symbol) {

		return this.map[symbol.getY()][symbol.getX()];
	}

	/**
	 * Delete symbol in the map
	 * @param pos Character to delete in map
	 */

	public void deleteCell(Character pos) {
		this.map[pos.position.getY()][pos.position.getX()] = ' ';
	}

	/**
	 * Sets the symbol in the map
	 * @param pos Character to search in the map
	 */

	public void setMapSymbol(Character pos) {
		this.map[pos.position.getY()][pos.position.getX()] = pos.getSymbol();
	}

	/**
	 * Returns the position of the lever
	 * @return lever of type Position
	 */
	public Position leverPos() {
		return lever.position;
	}

	/**
	 * Prints the map 
	 */

	public void printmap() {

		for(int a = 0 ; a < collum  ; a++ ) {
			//System.out.print("|");
			for(int b = 0 ; b < lines ; b++) {
				System.out.print(this.map[a][b] );

			}
			System.out.print('\n');
		}
	}

	/**
	 * Converts to string
	 * @return map in type String 
	 */

	public String tostring() {
		String map = "";
		for(int a = 0 ; a < collum  ; a++ ) {
			//System.out.print("|");
			for(int b = 0 ; b < lines ; b++) {
				//System.out.print(this.map[a][b] + "|");
				map += this.map[a][b];
			}		
			map += "\n";
		}
		return map;
	}
	
	/**
	 * Returns variable lever
	 * @return lever of type Lever
	 */
	public Lever getLever() {
		return lever;
	}

	/**
	 * Returns variable door
	 * @return door of type ArrayList<Door>
	 */

	public ArrayList<Door> getDoor() {
		return this.door;
	}

	/**
	 * Returns variable hero
	 * @return hero of type Hero
	 */
	
	public Hero getHero() {
		return this.hero;
	}

	/**
	 * Returns variable map
	 * @return map of type char[][]
	 */
	
	public char[][] getmap(){
		return this.map;
	}
	
	 public abstract void autoMoves(char heromove);
	 public abstract boolean endOfGame();

	 abstract void setNewPositions();
	 abstract void deleteOldPositions();

}
