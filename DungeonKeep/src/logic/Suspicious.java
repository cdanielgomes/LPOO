package logic;

import java.util.Random;

/**
 * Class of Suspicious type of the Guard,
 * Extends Guard
 */
public class Suspicious extends Guard{

	/**
	 * Constructor of class Suspicious
	 * @param pos Position of the guard
	 * @param name name type of guard
	 * @param moves pre defined moves of the guard
	 * 
	 */
	public Suspicious(Position pos , String name, char[] moves) {
		super(pos , name, moves);
	}

	/**
	 * Computes the guard movement in the map
	 */

	@Override
	public void movement() {
		Random random = new Random();
		int n = random.nextInt(10) + 1;

		if (n < 3) {
			if (reverse) reverse = false;
				else reverse = true;


			}
			guardMoves();
		}
	}

