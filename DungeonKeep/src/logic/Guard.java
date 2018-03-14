package logic;

import java.util.Random;

public abstract class Guard extends Character{
	
	

	private String name;
	private char moves[] = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd',
			'd', 'w', 'w', 'w', 'w', 'w' };
	protected boolean reverse = false;
	protected boolean asleep = false;
	private int m = 0;
	
	
	public Guard(Position position, String name) {
		super(position);
		this.symbol = 'G';
		this.name = name;
		
		
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void guardMoves() {
		this.position = move(moves[m]);
		m++;
		if (m == moves.length)
			m = 0;

		
	}

	public void guardReverseMoves() {

		
		if (m == 0)
			m = moves.length - 1;
		else
			m--;
		reversemove(moves[m]);
	}
	
	public abstract void movement();

	public boolean getasleep() {
		return this.asleep;
	}
	
	
}
