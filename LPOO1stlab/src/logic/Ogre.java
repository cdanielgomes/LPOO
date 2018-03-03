package logic;
import java.util.Random;

public class Ogre {
	
	Random rand = new Random();
	Random weaponpos = new Random();
	int x = 4, y = 1;
	int weaponx = 3 , weapony = 3;
	int index;
	char moviment[] = {'a','w','d','s'};
	char symbol = 'O';
	char weaponSymbol = '*';
	public boolean weaponFlag = true;
	
	public void setWeaponFlag(boolean s) {
		weaponFlag = s;
		
	}
	
	public char getweponSymbol() {
		return this.weaponSymbol;	
	}
	
	public int getWeaponx() {
		return weaponx;
	}
	
	public int getWeapony() {
		return weapony;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public void setSymbol(char k) {
		this.symbol = k;
	}
	
	public void setWeaponSymbol(char k) {
		this.weaponSymbol = k;
	}
	
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	
	public void weaponPos() {
		index = weaponpos.nextInt(4);
		switch(index) {
		case 0:
			this.weaponx = this.x;
			this.weapony = this.y - 1;
			
			break;
		case 1: 
			this.weaponx = this.x - 1;
			this.weapony = this.y;
			
			break;
		case 2:
			this.weapony = this.y + 1;
			
			this.weaponx = this.x;
			break;
		case 3:
			this.weaponx = this.x + 1;
			this.weapony = this.y;
			break;
		}
	
	}
	
	public void ogreMove() {
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
			if (this.y + 1 == 9)
				break;
			this.y += 1;
			break;
		case 0:
			if (this.x + 1 == 9)
				break;
			this.x += 1;
			break;
		default:
			break;
		}
		
		do {
			weaponPos();
			
		}while(weaponx == 0 || weapony == 0 || weaponx == 9 || weapony == 9  );
	}
	
	public boolean nextToMe(int x, int y) {
		int diferencex = this.x - x, diferencey = this.y - y;
		
		if ((diferencex == 1 || diferencex == -1) && diferencey == 0)
			return true;
		if ((diferencey == 1 || diferencey == -1) && diferencex == 0)
			return true;
		return false;
	}	


	public boolean nextToWeapon(int x, int y) {
		int diferencex = this.weaponx - x, diferencey = this.weapony - y;
		
		if ((diferencex == 1 || diferencex == -1) && diferencey == 0)
			return true;
		if ((diferencey == 1 || diferencey == -1) && diferencex == 0)
			return true;
		
		return false;
	}	

}
