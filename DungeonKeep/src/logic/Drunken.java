package logic;

import java.util.Random;

/**
 *  Class used to represent the Drunken type of guard,
 *  Extends Guard
 */

public class Drunken extends Guard {

	private int sleepCounter= 4;

	/**
	 * Constructor of the class Drunken
	 * 
	 * @param pos Position 
	 * @param name name of the guard type (in this case always "Drunken")
	 * @param moves char array with all the pre defined moves of the guard
	 * 
	 */
	public Drunken(Position pos , String name, char[] moves) {
		super(pos, name, moves);
	}

	/**
	 * Computes the movement of the guard  and can make the
	 *  guard fall asleep (with 10 % chance) 
	 */

	@Override
	public void movement() {
		Random random = new Random();
		int n = random.nextInt(10) + 1;
		if (asleep) {
			sleepCounter --;
			if (sleepCounter == 0) {
				sleepCounter = 4;
				asleep = false;
				this.setSymbol('G');
			}
		}
		else {
			if (n == 2) {  
				asleep = true;
				this.setSymbol('g');

				if (reverse) reverse = false;            
				else reverse = true;

			}
			else guardMoves();
		}
	}

}
