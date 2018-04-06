package logic;

import java.util.Random;

/**
 * 	Abstract class that represents the Guard of the game,
 * 	extends Character
 */

public abstract class Guard extends Character{



	private String name;
	private char[] moves;
	protected boolean reverse = false;
	protected boolean asleep = false;
	private int m = 0;


	/**
	 * Constructor of class Guard
	 * @param position position of the guard
	 * @param name type of the guard
	 * @param moves pre defined moves of the guard
	 *
	 */
	public Guard(Position position, String name, char[] moves) {
		super(position);
		this.symbol = 'G';
		this.name = name;
		this.moves = moves;

	}

	/**
	 * Returns name type of the Guard
	 * @return variable name of type String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Computes next move of the guard
	 */

	public void guardMoves() {
		
		if(reverse){
		if (m == 0)
			m = moves.length - 1;
		else
			m--;
		this.position = move(moves[m], reverse); 
		}
		
		else{
		this.position = move(moves[m], reverse);
		m++;
		if (m == moves.length)
			m = 0;
		}


	}
	public abstract void movement();

	/** Returns flag of asleep
	 * @return asleep value 
	 */
	public boolean getasleep() {
		return this.asleep;
	}


}
