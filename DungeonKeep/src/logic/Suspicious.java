package logic;

import java.util.Random;

public class Suspicious extends Guard{

	public Suspicious(Position pos , String name) {
		super(pos , name);
	}
	
	@Override
	public void movement() {
		Random random = new Random();
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
}