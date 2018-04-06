package logic;
/**
 * Class that is used to represent the doors of the map
 *  
 *  Extends Character
 */
public class Door extends Character {

	/**
	 * Constructor of class Door
	 * @param position door Position in map
	 * 
	 */
	public Door(Position position) {
		super(position);
		this.symbol = 'I';
	}

	/**
	 * Changes the symbol of the door ('S') ,
	 *   making the door open
	 * @param map GameMap object 
	 */

	public void openDoor(GameMap map) {
			this.setSymbol('S');
			map.setMapSymbol(this);
	}

	
	
	
}
