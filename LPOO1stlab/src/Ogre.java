import java.util.Random;

public class Ogre {
	Random rand = new Random();
	int x = 4, y = 2;
	char moviment[] = {'a','w','d','s'};
	int index;
	char symbol = 'O';
	
	
	char getSymbol() {
		return this.symbol;
	}
	
	void setSymbol(char k) {
		this.symbol = k;
	}
	
	int getx() {
		return this.x;
	}
	int gety() {
		return this.y;
	}
	
	void ogreMove() {
		index = rand.nextInt(4);	
		switch(index) {
		case 1:
			if (this.x - 1 == 0)
				break;
			this.x -= 1;
			break;
		case 2:
			if (this.y - 1 == 0)
				break;
			this.y -= 1;
			break;
		case 3:
			if (this.y + 1 == 0)
				break;
			this.y += 1;
			break;
		case 0:
			if (this.x + 1 == 0)
				break;
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
