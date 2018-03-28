package logic;

import java.util.Random;

public class Drunken extends Guard {
	
	private int sleepCounter= 4;
	
	
	public Drunken(Position pos , String name, char[] moves) {
		super(pos, name, moves);
	}

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
			if (n == 2) {  // it is a 10 % chance 
				asleep = true;
				this.setSymbol('g');
				
				if (reverse) {                 // change direction every-time he goes sleeping
					reverse = false;           // 
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
	
	
	
	
}
