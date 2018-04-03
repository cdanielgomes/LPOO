package logic;

import java.util.Random;

public abstract class Guard extends Character{



	private String name;
	private char[] moves;
	protected boolean reverse = false;
	protected boolean asleep = false;
	private int m = 0;



	public Guard(Position position, String name, char[] moves) {
		super(position);
		this.symbol = 'G';
		this.name = name;
		this.moves = moves;

	}


	public String getName() {
		return name;
	}


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

	public boolean getasleep() {
		return this.asleep;
	}


}
