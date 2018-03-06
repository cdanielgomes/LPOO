package logic;

import java.util.Random;

public class Drunken extends Guard {
	
	private int sleepCounter= 4;
	
	
	public Drunken(int x, int y, Map map , String name) {
		super(x ,y ,map, name);
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
	
	
	
	
}
