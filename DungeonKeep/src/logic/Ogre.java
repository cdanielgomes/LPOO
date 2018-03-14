package logic;

import java.util.Random;

public class Ogre extends Character {

	private Character weapon;
	private Random rand = new Random();
	private	char moviment[] = {'a','w','d','s'};
	private boolean stun = false;
	private int countdown;

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

			switch(symbol) {
			case 'X':
				break;
			case ' ':
				setPosition(newPos);
				break;
			case 'I':
				break;
			default:
				break;
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
			
			switch(symbol) {
			case 'X':
				c = true;
				break;
			case ' ':
				setPosition(newPos);
				break;
			case 'I':
				c = true;
				break;
			default:
				break;
			}

			if(this.weapon.position.equals(map.leverPos())) {
				this.weapon.setSymbol('$');
			}

		}while(c);
	}

	public Character getWeapon() {
		return this.weapon;
	}

	public boolean isStun() {
		return this.stun;
	}
}
