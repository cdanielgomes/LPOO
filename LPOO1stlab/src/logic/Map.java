package logic;


public class Map {

	private char[][] map;
	private boolean stairs;
	private boolean door;
	private int[] exits;
	
	
	public Map(char[][] map, boolean stairs, boolean door, int[] exits) {
		super();
		this.map = map;
		this.setStairs(stairs);
		this.setDoor(door);
	}

	public int getCharcX(char charac) {
		for (int i = 0; i < this.map.length; i++) {
			for (int b = 0; b < this.map[i].length; b++) {
				if(this.map[i][b] == charac){
					return b;
				}
			}
		}
		return -1;
	}
	
	public int getCharcY(char charac) {
		
		for (int i = 0; i < this.map.length; i++) {
			for (int b = 0; b < this.map[i].length; b++) {
				if(this.map[i][b] == charac){
					return i;
				}
			}
		}
		return -1;
	}


	public char getMapSymbol(int x, int y) {

		return this.map[y][x];
	}


	public boolean inWall(int x, int y, char l) {
		return this.map[y][x] == l;
	}

	public void setMapSymbol(int x, int y, char symbol) {

		this.map[y][x] = symbol;

	}

	public void printmap() {
		 
		for(int a = 0 ; a < 10  ; a++ ) {
			System.out.print("|");
			for(int b = 0 ; b < 10 ; b++) {
				System.out.print(this.map[a][b] + "|");

			}
			System.out.print('\n');
		}
	}


	public void deleteCell(int x, int y) {
		this.map[y][x] = ' ';

	}

	public int[] getExits() {
		return exits;
	}

	public void setExits(int[] exits) {
		this.exits = exits;
	}

	public boolean isDoor() {
		return door;
	}

	public void setDoor(boolean door) {
		this.door = door;
	}

	public boolean isStairs() {
		return stairs;
	}

	public void setStairs(boolean stairs) {
		this.stairs = stairs;
	}

	

}
