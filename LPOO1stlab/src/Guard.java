
public class Guard {

	private int x = 8, y = 1;
	private int m = 0;
	char moves[]= {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	
	int getx() {
		return this.x;
	}
	
	int gety() {
		return this.y;
	}
	
	void guardMoves() {
		char ret = moves[m%moves.length];
		m++;
		switch(ret) {
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
		
	}
	
	
	boolean nextToMe(int x, int y) {
		int diferencex = this.x - x, diferencey = this.y - y;
		
		if ((diferencex == 1 || diferencex == -1) && diferencey == 0)
			return true;
		if ((diferencey == 1 || diferencey == -1) && diferencex == 0)
			return true;
		return false;
	}
	
}
