package logic;

public abstract class Character {

	protected int x, y;
	protected char symbol;
	protected Map map;
	
	
	Character(int x, int y, Map map){
		setX(x);
		setY(y);
		this.map = map;

	}
	
	void move(char c) {

		map.deleteCell(this.x, this.y);
		
		switch(c) {
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
	
	void reversemove(char c) {
		map.deleteCell(this.x, this.y);
		
		switch(c) {
		case 'a':
		this.x += 1;
			break;
		case 'w':
			this.y += 1;
			break;
		case 's':
			this.y -= 1;
			break;
		case 'd':
			this.x -= 1;
			break;
		default:
			break;
		}
	}



	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	

	@Override
	public boolean equals(Object obj) {
		
		return x == ((Character)obj).x && y == ((Character)obj).y ;
	}


}
