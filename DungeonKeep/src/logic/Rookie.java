package logic;

/**
 * Class of the Rookie type of the Guard ,
 * extends Guard
 */
public class Rookie extends Guard{

	/**
	 * Constructor of the class Rookie
	 * @param position Position of the guard
	 * @param name name type of the guard
	 * @param moves predefined moves of the guard
	 * 
	 */
	public Rookie(Position position, String name, char[] moves) {
		super(position, name, moves);
	}

	/**
	 * Computes the guard movement in the map
	 */
	@Override
	public void movement() {
		this.guardMoves();
	}

}
 