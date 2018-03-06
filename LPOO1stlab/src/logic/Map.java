package logic;

import java.util.Vector;

public class Map {

	private Vector<char[][]> maps = new Vector<char[][]>();
	private int level;

	char[][] map = {{'X','X','X','X','X','X','X','X','X','X'},
					{'X','H',' ',' ','I',' ','X',' ','G','X'},
					{'X','X','X',' ','X','X','X',' ',' ','X'},
					{'X',' ','I',' ','I',' ','X',' ',' ','X'},
					{'X','X','X',' ','X','X','X',' ',' ','X'},
					{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
					{'X','X','X',' ','X','X','X','X',' ','X'},
					{'X',' ','I',' ','I',' ','X','k',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}
	};



	char[][] map2 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'I',' ',' ','O',' ',' ',' ',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','H',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}

	};	


	public Map() {
		level = 0;
		maps.add(map);
		maps.add(map2);

	}

	public int getCharcX(char charac) {
		char[][] m = maps.get(level);
		
		for (int i = 0; i < m.length; i++) {
			for (int b = 0; b < m[i].length; b++) {
				if(m[i][b] == charac){
					return b;
				}
			}
		}
		return -1;
	}
	
	public int getCharcY(char charac) {
		char[][] m = maps.get(level);
		
		for (int i = 0; i < m.length; i++) {
			for (int b = 0; b < m[i].length; b++) {
				if(m[i][b] == charac){
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * @return the maps
	 */
	public Vector<char[][]> getMaps() {
		return maps;
	}


	/**
	 * @param maps the maps to set
	 */
	public void setMaps(Vector<char[][]> maps) {
		this.maps = maps;
	}


	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}


	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}



	public char getMapSymbol(int x, int y) {

		return maps.get(level)[y][x];
	}


	public boolean inWall(int x, int y, char l) {
		return maps.get(level)[y][x] == l;
	}

	public void setMapSymbol(int x, int y, char symbol) {

		maps.get(level)[y][x] = symbol;

	}

	public void printmap() {
		 
		for(int a = 0 ; a < 10  ; a++ ) {
			System.out.print("|");
			for(int b = 0 ; b < 10 ; b++) {
				System.out.print(maps.get(level)[a][b] + "|");

			}
			System.out.print('\n');
		}
	}


	public void deleteCell(int x, int y) {
		maps.get(level)[y][x] = ' ';

	}


	public void fillSndMap() {
		for (int i = 1; i < 9; i++) {
			for (int k = 1; k < 9; k++)
				map[i][k] = ' ';
		}

		map[1][0] = 'I';
		map[5][0] = 'X';
		map[6][0] = 'X';
		map[1][4] = 'O';
		map[1][8] = 'k';
		map[8][1] = 'H';
	}
}
