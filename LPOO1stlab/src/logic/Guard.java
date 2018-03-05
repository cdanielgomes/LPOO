package logic;

import java.util.Random;

public class Guard extends Character{

	
	private char symbol = 'G';
	private String[] guard_types = {"Rookie" , "Drunken" , "Suspicious"};
	private Random randomGuard = new Random(); 
	//public String TypeOfGuard = guard_types[randomGuard.nextInt(3)] ;
	private String TypeOfGuard = guard_types[0] ;
	private boolean reverse = false;
	private boolean asleep = false;
	private char moves[]= {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	private int m = 0;
	private int sleepCounter= 4;
	
	public Guard(int x, int y, Map map) {
		super(x, y, map);
		
	}
	
	public String getTypeOfGuard() {
		return TypeOfGuard;
	}
	
	public char getsymbol() {
		return this.symbol;
	}
	
	public void setsymbol(char c) {
		this.symbol = c;
	}
	
	public boolean getasleep() {
		return this.asleep;
	}
	public void guardMoves() {
		
		move(moves[m]);
		m++;
		if (m == moves.length)
			m = 0;
		
	}
	
	public void guardReverseMoves() {
		
		if (m == 0)
			m = moves.length - 1;
		else
			m --;
		move(moves[m]);
		
	}
	
	
	
	public boolean nextToMe(int x, int y) {
		int diferencex = this.x - x, diferencey = this.y - y;
		
		if ((diferencex == 1 || diferencex == -1) && diferencey == 0)
			return true;
		if ((diferencey == 1 || diferencey == -1) && diferencex == 0)
			return true;
		return false;
	}
	
	
	
	// drunken func.
	public void drunken(Random random) {
		
		int n = random.nextInt(10) +1;
		
		if (asleep) {
			sleepCounter --;
			if (sleepCounter == 0) {
				sleepCounter = 4;
				asleep = false;
				this.setsymbol('G');
			}
		}
		else {
			if (n == 2) {
				asleep = true;
				this.setsymbol('g');
				if (reverse) {        // change direction everytime he goes sleeping
					reverse = false;  // 
				}
				else reverse = true;
			}
			else {
				if (reverse)
					guardReverseMoves();
				else 
					guardMoves();
			}
		}
		
	}
	// suspicious func.
	
	public void suspicious(Random random) {
		
		int n = random.nextInt(10) + 1;

		if (n < 3) {
			if (reverse) {
				reverse = false;
			} else {
				reverse = true;
			}

		}

		if (reverse) {
			guardReverseMoves();
		} else {
			guardMoves();
		}
	}
		
	
	
	public void movement() {
		
		Random r = new Random();
		
		map.setMapSymbol(this.x, this.y, symbol);
		
		switch(TypeOfGuard) {
		case "Rookie":
			guardMoves();
			break;
		
		case "Drunken":
			drunken(r);
			break;
			
		case "Suspicious" :
			suspicious(r);
			break;
		
		}	
		
	}
	
}
