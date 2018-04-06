package logic;

/**
 * Class used to represent the Lever of the map,
 * Extends Character type
 */
public class Lever extends Character {

	/**
	 * Constructor of class Lever
	 * @param position position of the lever in the map 
	 * 
	 */
	public Lever(Position position) {
		super(position);
		this.symbol = 'k';
	}

}
 