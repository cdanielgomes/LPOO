import java.util.Scanner;

public class Hero {
	boolean key = false;
	private int x = 1, y = 1;
	private int newx ,newy;
	private Scanner move = new Scanner(System.in);

	void improveMove(int x, int y) {	
		this.newy = this.y + y;
		this.newx = this.x + x;
	}

	int getx() {
		return x;
	}

	int gety() {
		return y;		
	}
	int getnx() {
		return newx;
	}
	
	int getny() {
		return newy;
	}


	void set() {
		x = newx;
		y = newy;
	}

	public void getMove() {
		char s = move.next().charAt(0);
		switch(s) {
		case 'a':
			improveMove(-1, 0);
			break;
		case 'w':
			improveMove(0, -1);
			break;
		case 's':
			improveMove(0, 1);
			break;
		case 'd':
			improveMove(1,0);
			break;
		default:
			break;
		}

	}



}
