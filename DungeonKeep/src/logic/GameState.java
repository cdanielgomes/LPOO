package logic;

public class GameState {

	private GameMap map;
	private int guard;
	private int nOgres;
	private boolean won = false;

	char[][] map1 = {{'X','X','X','X','X','X','X','X','X','X'},
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
			{'X','H',' ',' ','*',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}
	};	


	public GameState(int numogres, int guard) {
		this.nOgres = numogres;
		this.guard = guard;
	};

	public void start_game() {

		map = new Dungeon(map1,guard);
		//map = new Keep(map2,nOgres);

	}

	public void moviment(char hero) {

		map.deleteOldPositions();
		map.autoMoves(hero);
		map.setNewPositions();
		if (map.hero.nextLevel()) {
			if (map instanceof Dungeon)
				map = new Keep(map2,nOgres);
			else 
				won = true;
		}
	}

	public void display() {
		map.printmap();
	}

	public boolean over() {
		return map.endOfGame() || won;
	}
	
	public boolean hasWon() {
		return this.won;
	}

}
