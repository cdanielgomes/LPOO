package logic;

public class Position {
	private int x, y;
	
	
	public Position() {};
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	

	void setPosition(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

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
