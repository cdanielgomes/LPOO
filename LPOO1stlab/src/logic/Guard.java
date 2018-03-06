package logic;

import java.util.Random;

public abstract class Guard extends Character{
	
	public Guard(int x, int y, Map map , String name) {
		super(x, y, map);
		this.symbol = 'G';
		
	}
	
	private String name;
	private char moves[] = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd',
			'd', 'w', 'w', 'w', 'w', 'w' };
	protected boolean reverse = false;
	protected boolean asleep = false;
	private int m = 0;
	
	
	public String getName() {
		return name;
	}
	
	public char getsymbol() {
		return this.symbol;
	}
	
	public void setsymbol(char c) {
		this.symbol = c;
	}
	
	public void guardMoves() {
		move(moves[m]);
		m++;
		if (m == moves.length)
			m = 0;
		
	
		
		map.setMapSymbol(this.x, this.y, symbol);
	
		
	}

	public void guardReverseMoves() {

		
		if (m == 0)
			m = moves.length - 1;
		else
			m--;
		reversemove(moves[m]);
		
		

		map.setMapSymbol(this.x, this.y, symbol);
	}
	
	public boolean nextToMe(int x, int y) {
		int diferencex = this.x - x, diferencey = this.y - y;
		
		if ((diferencex == 1 || diferencex == -1) && diferencey == 0)
			return true;
		if ((diferencey == 1 || diferencey == -1) && diferencex == 0)
			return true;
		return false;
	}
	
	public abstract void movement();

	public boolean getasleep() {
		return this.asleep;
	}
	
	
}
