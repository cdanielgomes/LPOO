package logic;

import java.util.ArrayList;

public abstract class GameMap {
	protected char[][] map;
	protected int collum;
	protected int lines;

	protected Hero hero;
	protected Lever lever;
	protected ArrayList<Door> door = new ArrayList<Door>();


	public GameMap(char[][] map) {
		this.map = map;
		this.collum = map.length;
		this.lines = map[0].length;
		this.hero = new Hero(getCharc('H'));
		this.lever = new Lever(getCharc('k'));

	}



	public Position getCharc(char charac) {
		for (int i = 0; i < collum; i++) {
			for (int b = 0; b < lines; b++) {
				if(this.map[i][b] == charac){
					return new Position(b,i);
				}
			}
		}
		return new Position(-1,-1);
	}


	public char getMapSymbol(Position symbol) {

		return this.map[symbol.getY()][symbol.getX()];
	}


	public void deleteCell(Character pos) {
		this.map[pos.position.getY()][pos.position.getX()] = ' ';
	}

	public void setMapSymbol(Character pos) {
		this.map[pos.position.getY()][pos.position.getX()] = pos.getSymbol();
	}

	public Position leverPos() {
		return lever.position;
	}

	public void printmap() {
		for(int a = 0 ; a < collum  ; a++ ) {
			System.out.print("|");
			for(int b = 0 ; b < lines ; b++) {
				System.out.print(this.map[a][b] + "|");

			}
			System.out.print('\n');
		}
	}

	public String totring() {
		String map = "";
		for(int a = 0 ; a < collum  ; a++ ) {
			//System.out.print("|");
			for(int b = 0 ; b < lines ; b++) {
				//System.out.print(this.map[a][b] + "|");
				map += this.map[a][b];
			}		
			map += "\n";
		}
		return map;
	}
	
	public Lever getLever() {
		return lever;
	}


	public ArrayList<Door> getDoor() {
		return this.door;
	}

	
	public Hero getHero() {
		return this.hero;
	}
	
	 public abstract void autoMoves(char heromove);
	 public abstract boolean endOfGame();
	 abstract void setNewPositions();
	abstract void deleteOldPositions();

}
