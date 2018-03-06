package logic;

import java.util.Random;

public class Suspicious extends Guard{

	public Suspicious(int x, int y, Map map , String name) {
		super(x, y, map , name);
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
