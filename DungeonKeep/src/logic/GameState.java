package logic;

import java.util.ArrayList;

public class GameState {

	private ArrayList<GameMap> gameMaps = new ArrayList<GameMap>(); 
	private GameMap map;
	private String guard;
	private int nOgres;
	private boolean won = false;
	private int level = 0;

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

	public GameState(int numogres, String guard) {
		this.nOgres = numogres;
		this.guard = guard;
	};

	public void start_game() {
		char[] moves = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd',
				'd', 'w', 'w', 'w', 'w', 'w' };
		ArrayList<Door> i = new ArrayList<Door>(); 
		ArrayList<Door> s = new ArrayList<Door>();
		i.add(new Door(new Position(0,5)));
		i.add(new Door(new Position(0,6)));
		s.add(new Door(new Position(0,1)));
		GameMap m =  new Dungeon(map1,guard, i, moves);
		gameMaps.add(m);
		m = new Keep(map2,nOgres,s);
		gameMaps.add(m);
		map = gameMaps.get(level);	
	}

	public void movement(char hero) {

		map.deleteOldPositions();
		map.autoMoves(hero);
		map.setNewPositions();

		if (map.hero.nextLevel()) {
			if (level + 1 < gameMaps.size()) {
				level++;
				map = gameMaps.get(level);
			}
			else 
				won = true;
		}
	}


	public void display() {
		System.out.println(map.tostring());
	}

	public boolean over() {
		return map.endOfGame() || won;
	}

	public boolean hasWon() {
		return this.won;
	}


	public GameMap getMap() {
		return map;
	}

	public void setMap(GameMap map) {
		this.map = map;
	}
}
