package logic;

import java.util.Random;

public class Guard {

	int x = 8, y = 1;
	char symbol = 'G';
	String[] guard_types = {"Rookie" , "Drunken" , "Suspicious"};
	Random randomGuard = new Random(); 
	public String TypeOfGuard = guard_types[randomGuard.nextInt(3)] ;
	boolean reverse = false;
	boolean asleep = false;
	public char moves[]= {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	public int m = 0;
	int sleepCounter= 4;
	
	public int getx() {
		return this.x;
	}
	
	public int gety() {
		return this.y;
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
		
		
		switch(moves[m]) {
		case 'a':
		this.x -= 1;
			break;
		case 'w':
			this.y -= 1;
			break;
		case 's':
			this.y += 1;
			break;
		case 'd':
			this.x += 1;
			break;
		default:
			break;
		}
		m++;
		if (m == moves.length)
			m = 0;
		
	}
	
	public void guardReverseMoves() {
		
		if (m == 0)
			m = moves.length - 1;
		else
			m --;
		
		switch(moves[m]) {
		case 'a':
		this.x += 1;
			break;
		case 'w':
			this.y += 1;
			break;
		case 's':
			this.y -= 1;
			break;
		case 'd':
			this.x -= 1;
			break;
		default:
			break;
		}
		
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
