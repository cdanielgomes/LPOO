
public class Map {
	int quad = 10;
	
	
	char[][] map = new char [10][10];
	
	public Map() {
		
	}
	
	public void printmap() {
		
		for(int a = 0 ; a < 10  ; a++ ) {
			
			for(int b = 0 ; b < 10 ; b++) {
				System.out.print(map[a][b]);
				
			}
			System.out.print('\n');
		}
	}
	public void setMap(int x, int y) {
		
		
	}
	
	public void fillmap() {
		map[0][0] = 'X';
		map[0][1] = 'X';
		map[0][2] = 'X';
		map[0][3] = 'X';
		map[0][4] = 'X';
		map[0][5] = 'X';
		map[0][6] = 'X';
		map[0][7] = 'X';
		map[0][8] = 'X';
		map[0][9] = 'X';
		map[1][0] = 'X';
		map[1][1] = 'H';
		map[1][2] = ' ';
		map[1][3] = ' ';
		map[1][4] = 'I';
		map[1][5] = ' ';
		map[1][6] = 'X';
		map[1][7] = ' ';
		map[1][8] = 'G';
		map[1][9] = 'X';
		map[2][0] = 'X';
		map[2][1] = 'X';
		map[2][2] = 'X';
		map[2][3] = ' ';
		map[2][4] = 'X';
		map[2][5] = 'X';
		map[2][6] = 'X';
		map[2][7] = ' ';
		map[2][8] = ' ';
		map[2][9] = 'X';
		map[3][0] = 'X';
		map[3][1] = ' ';
		map[3][2] = 'I';
		map[3][3] = ' ';
		map[3][4] = 'I';
		map[3][5] = ' ';
		map[3][6] = 'X';
		map[3][7] = ' ';
		map[3][8] = ' ';
		map[3][9] = 'X';
		map[4][0] = 'X';
		map[4][1] = 'X';
		map[4][2] = 'X';
		map[4][3] = ' ';
		map[4][4] = 'X';
		map[4][5] = 'X';
		map[4][6] = 'X';
		map[4][7] = ' ';
		map[4][8] = ' ';
		map[4][9] = 'X';
		map[5][0] = 'I';
		map[5][1] = ' ';
		map[5][2] = ' ';
		map[5][3] = ' ';
		map[5][4] = ' ';
		map[5][5] = ' ';
		map[5][6] = ' ';
		map[5][7] = ' ';
		map[5][8] = ' ';
		map[5][9] = 'X';
		map[6][0] = 'I';
		map[6][1] = ' ';
		map[6][2] = ' ';
		map[6][3] = ' ';
		map[6][4] = ' ';
		map[6][5] = ' ';
		map[6][6] = ' ';
		map[6][7] = ' ';
		map[6][8] = ' ';
		map[6][9] = 'X';
		map[7][0] = 'X';
		map[7][1] = 'X';
		map[7][2] = 'X';
		map[7][3] = ' ';
		map[7][4] = 'X';
		map[7][5] = 'X';
		map[7][6] = 'X';
		map[7][7] = 'X';
		map[7][8] = ' ';
		map[7][9] = 'X';
		map[8][0] = 'X';
		map[8][1] = ' ';
		map[8][2] = 'I';
		map[8][3] = ' ';
		map[8][4] = 'I';
		map[8][5] = ' ';
		map[8][6] = 'X';
		map[8][7] = 'k';
		map[8][8] = ' ';
		map[8][9] = 'X';
		map[9][0] = 'X';
		map[9][1] = 'X';
		map[9][2] = 'X';
		map[9][3] = 'X';
		map[9][4] = 'X';
		map[9][5] = 'X';
		map[9][6] = 'X';
		map[9][7] = 'X';
		map[9][8] = 'X';
		map[9][9] = 'X';
	}
	
	
}
