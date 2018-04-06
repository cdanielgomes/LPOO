package logic;

import java.util.Random;

/**
 * Class that represents the Ogre type in the game
 */
public class Ogre extends Character {

	private Character weapon;
	private Random rand = new Random();
	private	char moviment[] = {'a','w','d','s'};
	private boolean stun = false;
	private int countdown = 2;

	/**
	 * Constructor of class Ogre
	 * @param position position of the Ogre in the map
	 * 
	 */
	public Ogre(Position position) {
		super(position);
		this.symbol = 'O';
		weapon = new Character(position);
		weapon.symbol = '*';
	}	
	
	
	int randomTo4(GameMap map) {
		int indexMove = rand.nextInt(4);
		return indexMove;
	}
	
	void calculateNextPos(GameMap map) {
		Position newPos = move(moviment[randomTo4(map)], false);
		char symbol = map.getMapSymbol(newPos);
		this.setSymbol('O');
		this.weapon.setSymbol('*');
		if (!this.stun) {
			if(symbol == 'k' || symbol == ' ' || symbol == '*') setPosition(newPos);
		}
		else {
			this.setSymbol('8');
			countdown--;
			if (countdown == 0) {
				countdown = 2;
				this.stun = false;
			}
		}
		if(this.position.equals(map.leverPos()) && !map.getHero().hasLever()) this.setSymbol('$');
		calculateNextPosWeapon(map);
	}


	void calculateNextPosWeapon(GameMap map) {
		boolean c = false;	
		weapon.setPosition(this.position);

		do {
			c = false;
			Position newPos = weapon.move(moviment[randomTo4(map)], false);
			char symbol = map.getMapSymbol(newPos);
			if(symbol == ' ' || symbol == 'k') weapon.setPosition(newPos);
			else 
				c = true;
		}while(c);
		if(this.weapon.position.equals(map.leverPos())) this.weapon.setSymbol('$');
	}

	/**
	 * Gets the variable weapon
	 * @return variable of type Character (weapon)
	 */
	public Character getWeapon() {
		return this.weapon;
	}

	/**	
	 * Checks if ogre is stunned
	 * @return value of variable stunS
	 */

	public boolean isStun() {
		return this.stun;
	}

	/**
	 * Changes the value of stun variable 
	 * @param s new value for the variable stun
	 */
	
	public void setStun(boolean s) {
		this.stun = s;
	}
}
