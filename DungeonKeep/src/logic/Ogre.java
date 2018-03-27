package logic;

import java.util.Random;

public class Ogre extends Character {

	private Character weapon;
	private Random rand = new Random();
	private	char moviment[] = {'a','w','d','s'};
	private boolean stun = false;
	private int countdown = 2;

	public Ogre(Position position) {
		super(position);
		this.symbol = 'O';
		weapon = new Character(position);
		weapon.symbol = '*';
	}	

	/* 
	 * Calculate the next position of the weapon and of the ogre 
	 * 
	 * */
	void calculateNextPos(GameMap map) {

		int indexMove = rand.nextInt(4);
		Position newPos = move(moviment[indexMove]);

		char symbol = map.getMapSymbol(newPos);

		this.setSymbol('O');
		this.weapon.setSymbol('*');

		if (!this.stun) {
			
			if(symbol == 'k' || symbol == ' ')
				setPosition(newPos);
			
		}
		else {
			this.setSymbol('8');
			countdown--;
			if (countdown == 0) {
				countdown = 2;
				this.stun = false;
			}
		}
			
			
		if(this.position.equals(map.leverPos())) {
			this.setSymbol('$');
		}

		weapon.setPosition(this.position);
		boolean c = false;

		do {
			c = false;
			indexMove = rand.nextInt(4);
			newPos = weapon.move(moviment[indexMove]);
			symbol = map.getMapSymbol(newPos);

			if(symbol == ' ' || symbol == 'k')
				weapon.setPosition(newPos);
			else 
				c = true;

		}while(c);

		if(this.weapon.position.equals(map.leverPos())) {
			this.weapon.setSymbol('$');
		}
	}

	public Character getWeapon() {
		return this.weapon;
	}

	public boolean isStun() {
		return this.stun;
	}
	
	public void setStun(boolean s) {
		this.stun = s;
	}
}
