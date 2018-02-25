
public class Map {


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
	public Map() {

	}

	char getMapSymbol(int x, int y) {
		return map[y][x];
	}

	void setMapSymbol(int x, int y, char symbol) {
		map[y][x] = symbol;
	}

	public void printmap() {

		for(int a = 0 ; a < 10  ; a++ ) {

			for(int b = 0 ; b < 10 ; b++) {
				System.out.print(map[a][b]);

			}
			System.out.print('\n');
		}
	}

	boolean checkNextPosition(Integer x, Integer y) {
		if (!(map[y][x] == ' ' || map[y][x] == 'k' || map[y][x] == 'S')) { 
			return false;
		}
		return true;
	}

	void deleteCell(Integer x, Integer y) {
		map[y][x] = ' ';

	}



}
