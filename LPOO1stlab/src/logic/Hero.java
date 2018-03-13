package logic;

public class Hero extends Character{

	private Lever key;
	private boolean door;
	private char symbol = 'H';
	private char keySymbol = 'K';
	private boolean onStairs;


	public Hero(int x, int y, Map map, Lever key) {
		super(x, y, map);
		this.key = key;
		this.onStairs = false;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public void setSymbol(char s) {
		this.symbol = s;
	}

	public void set(int x , int y) {
		this.x = x;
		this.y = y;
	}


	public void getMove(char s) {

		int x = this.x, y = this.y;
		move(s);


		if(this.map.inWall(this.x, this.y, 'I') && key.getKey()) {
			this.x = x;
			this.y = y;

			map.deleteCell(0, 1);
		}


		if(this.map.inWall(this.x, this.y, 'X') || this.map.inWall(this.x, this.y, 'I')) {
			this.x = x;
			this.y = y;
		};


		if (this.map.inWall(this.x,this.y, 'S'))
			this.setOnStairs(true);


		if(this.equals(key)) {
			this.key.setKey(true);
			this.setSymbol(keySymbol);	
		};

		map.setMapSymbol(this.x, this.y, symbol);
	}

	public boolean isOnStairs() { //in the first level
		return onStairs;
	}

	public void setOnStairs(boolean onStairs) {
		this.onStairs = onStairs;
	}

	public boolean isDoor() {
		return door;
	}

	public void setDoor(boolean door) {
		this.door = door;
	}



}
