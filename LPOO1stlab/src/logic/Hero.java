package logic;
import java.util.Scanner;

public class Hero {
	
	public boolean key = false;
	private int x = 1, y = 1;
	private int newx ,newy;
	private Scanner move = new Scanner(System.in);
	private char symbol = 'H';

	public void improveMove(int x, int y) {	
		this.newy = this.y + y;
		this.newx = this.x + x;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public void setSymbol(char s) {
		this.symbol = s;
	}
	
	public int getx() {
		return x;
	}

	public int gety() {
		return y;		
	}
	
	public int getnx() {
		return newx;
	}

	public int getny() {
		return newy;
	}


	public void set(int x , int y) {
		this.x = x;
		this.y = y;
	}

	public void setn(int x, int y) {
		this.newy = y;
		this.newx = x;
	}
	public void setkey(boolean k) {
		this.key = k;
	}

	public void getMove() {
		System.out.print("Direction : ");
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
