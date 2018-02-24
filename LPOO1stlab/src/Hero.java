import java.util.Scanner;

public class Hero {

	Integer x = 1, y = 1;
	Integer newx ,newy;
	Scanner move = new Scanner(System.in);

	void improveMove(int x, int y) {	
		this.newy = this.y + y;
		this.newx = this.x + x;
	}

	Integer getx() {
		return x;
	}

	Integer gety() {
		return y;		
	}
	Integer getnx() {
		return newx;
	}
	
	Integer getny() {
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
			improveMove(0, -1);
			break;
		case 'w':
			improveMove(-1, 0);
			break;
		case 's':
			improveMove(1, 0);
			break;
		case 'd':
			improveMove(0,1);
			break;
		default:
			break;
		}

	}



}
