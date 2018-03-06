package logic;
import java.util.Random;

public class Ogre extends Character {

	public Ogre(int x, int y, Map map) {
		super(x, y, map);

	}


	Random rand = new Random();
	Random weaponpos = new Random();
	private int weaponx = this.x, weapony = this.y;
	private	char moviment[] = {'a','w','d','s'};
	private char normalsymbol = 'O';
	private char weaponSymbol = '*';
	private boolean weaponFlag = true;

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

	public char getNormalSymbol() {
		return this.normalsymbol;
	}

	public void setSymbol(char k) {
		this.normalsymbol = k;
	}

	public void setWeaponSymbol(char k) {
		this.weaponSymbol = k;
	}


	public void weaponPos() {
		int index = weaponpos.nextInt(4);
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

		int index = rand.nextInt(4);
		int x = this.x;
		int y = this.y;
		
		map.deleteCell(weaponx, weapony);
		map.deleteCell(this.x, this.y);
		move(moviment[index]);
		
		if (map.inWall(this.x, this.y, 'X'))
		{
			this.x = x;
			this.y = y;
		}

		do {

			
			weaponPos();
			if(map.inWall(weaponx, weapony, 'k')) {
				this.setWeaponSymbol('$');
			}


		}while(map.inWall(weaponx, weapony, 'X'));

		map.setMapSymbol(weaponx, weapony, weaponSymbol);
		map.setMapSymbol(this.x,this.y, normalsymbol);
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

	public boolean getWeaponFlag() {
		return weaponFlag;
	}	

}
