package logic;

/**
 * Class which is an abstraction of each symbol 
 *  of the game map
 * 
 */
public class Character {

	protected Position position;
	protected char symbol;

	/**
	 * Constructor for class Character
	 * @param position object of class Position
	 */

	public Character(Position position) {
		this.position = position;
	}

	/**
	 * Set the value of class variable symbol
	 * @param symbol new value for variable symbol
	 */
	public void setSymbol(char symbol) { 
		this.symbol = symbol;
	}
	/**
	 * Set the value of class variable position
	 * 
	 * @param newPosition new value for variable position (object of class Position)
	 */

	public void setPosition(Position newPosition) {
		this.position = newPosition;
	}

	/**
	 * Returns the char value of symbol
	 * @return class variable symbol
	 */
	public char getSymbol() {
		return this.symbol;
	}

	/**
	 * Returns class variable position
	 * @return position 
	 */
	
	public Position getPos() {
		return this.position;
	}

	/**	
	 *	Function that computes the next position (coordinates)
	 *	of the next move of the Character 
	 * 
	 * @param c char which corresponds to the move of the character
	 * @param reverse flag that indicates if the character is moving in a reverse order
	 * @return new position
	 */
	public Position move(char c, boolean reverse) {		
		Position pos = new Position();
		switch(c) {
		case 'a':
			if(reverse) pos.setPosition(this.position.getX()+1, this.position.getY());
			else pos.setPosition(this.position.getX()-1, this.position.getY());
			break;
		case 'w':
			if(reverse) pos.setPosition(this.position.getX(), this.position.getY()+1);
			else	pos.setPosition(this.position.getX(), this.position.getY()-1);
			break;
		case 's':
			if(reverse)	pos.setPosition(this.position.getX(), this.position.getY()-1);
			else pos.setPosition(this.position.getX(), this.position.getY()+1);
			break;
		case 'd':
			if(reverse)	pos.setPosition(this.position.getX()-1, this.position.getY());
			else pos.setPosition(this.position.getX()+1, this.position.getY());
			break;
		}
		return pos;
	}

	/**
	 * Checks the proximity to another Character object
	 * @param obj objecto da class Character
	 * @return true if is adjacent , false if not
	 */

	public boolean checkProximity(Character obj) {

		int diferencex = (position.getX() - obj.position.getX()), diferencey = position.getY()- obj.position.getY();

		if ((diferencex == 1 || diferencex == -1 || diferencex == 0) && diferencey == 0)
			return true;
		if ((diferencey == 1 || diferencey == -1 || diferencey == 0) && diferencex == 0)
			return true;
		return false;
	}





}
