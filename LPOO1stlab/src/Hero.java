import java.util.Scanner;

public class Hero {
	boolean key = false;
	private int x = 1, y = 1;
	private int newx ,newy;
	private Scanner move = new Scanner(System.in);
	private char symbol = 'H';

	void improveMove(int x, int y) {	
		this.newy = this.y + y;
		this.newx = this.x + x;
	}

	char getSymbol() {
		return this.symbol;
	}

	void setSymbol(char s) {
		this.symbol = s;
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


	void set(int x , int y) {
		this.x = x;
		this.y = y;
	}

	void setn(int x, int y) {
		this.newy = y;
		this.newx = x;
	}
	void setkey(boolean k) {
		this.key = k;
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
