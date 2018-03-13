package logic;
import java.util.Random;

public class Ogre extends Character {


	Random rand = new Random();
	Random weaponpos = new Random();
	private int weaponx; 
	private int weapony;
	private	char moviment[] = {'a','w','d','s'};
	private char weaponSymbol = '*';
	private boolean keyFlag;
	
	
	public Ogre(int x, int y, Map map) {
		super(x, y, map);
		this.weaponx = x;
		this.weapony = y;
		this.keyFlag = false;

	}


	public void setKeyFlag(boolean s) {
		keyFlag = s;

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
		
		this.setWeaponSymbol('*');
		this.setSymbol('O');
		
		move(moviment[index]);
		
		if (map.inWall(this.x, this.y, 'X'))
		{
			this.x = x;
			this.y = y;
		}
		
		map.deleteCell(this.weaponx, this.weapony);
		do {
			weaponPos();
			
			if(map.inWall(this.weaponx, this.weapony, 'k')) {
				this.setWeaponSymbol('$');
				this.keyFlag = true;
			}
			
		}while(map.inWall(this.weaponx, this.weapony, 'X'));

		map.setMapSymbol(this.weaponx, this.weapony, this.weaponSymbol);
		map.setMapSymbol(this.x,this.y, this.symbol);
	}

	private void setSymbol(char c) {
		this.symbol = c;
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

	public boolean getKeyFlag() {
		return keyFlag;
	}	

}
