package logic;

/**
 * Abstraction os the position of all the characters of the map
 */
public class Position {
	private int x, y;
	
	/**
	 * Constructor of class Position
	 */
	public Position() {};

	/**
	 * Constructor of class position
	 * @param x x value
	 * @param y y value
	 * 
	 */
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	


	void setPosition(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	
	/**
	 * Returns variable x
	 * @return variable x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Returns variable y
	 * @return variable y
	 */

	public int getY() {
		return this.y;
	}

	/**
	 * Override of fucntion equals
	 * @param obj any Object type
	 * 
	 */
	
	@Override //2 points are equal if they have the same coordinates
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
		return false;
		if (getClass() != obj.getClass())
		return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	
	
}
