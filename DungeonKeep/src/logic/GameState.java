package logic;

import java.util.ArrayList;

public class GameState {
	private ArrayList<GameMap> gameMaps = new ArrayList<GameMap>(); 
	private GameMap map;
	private ArrayList<GameMap> gameMapsCopy = new ArrayList<GameMap>(); 
	private String guard;
	private int nOgres;
	private boolean won = false;
	private int level = 0;

	private char[][] map1 = {{'X','X','X','X','X','X','X','X','X','X'},
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



	private char[][] copy2 = {{'X','X','X','X','X','X','X','X','X','X'},
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

	private char[][] map2 = {{'X','X','X','X','X','X','X','X','X','X'},
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

		initializeGame();

	};


	public char[][] cloning(char[][] m) {
		char[][] p = new char[m.length][m[0].length];
		for(int i = 0; i<10; i++) {
			p[i] = map1[i].clone();
		}
		return p;
	}


	public void initializeGame() {
		ArrayList<Door> i = new ArrayList<Door>(); 
		ArrayList<Door> s = new ArrayList<Door>();
		char[] moves = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd',
				'd', 'w', 'w', 'w', 'w', 'w' };
		i.add(new Door(new Position(0,5)));
		i.add(new Door(new Position(0,6)));
		s.add(new Door(new Position(0,1)));
		GameMap m =  new Dungeon(map1,guard, i, moves); 
		GameMap copy = new Dungeon((Dungeon)m);
		gameMaps.add(m);
		gameMaps.add(copy);
		m = new Keep(map2,nOgres,s);
		copy = new Keep((Keep)m);
		gameMapsCopy.add(copy);
		gameMapsCopy.add(copy);
		this.map = gameMaps.get(level);

	}

	public void setGuard(String guard) {
		this.guard = guard;
	}

	public void setnOgres(int nOgres) {
		this.nOgres = nOgres;
	}


	public char[][] restart(char[][] m) {
		char[][] p = new char[m.length][m[0].length];
		for(int i = 0; i < m.length; i++) {
			p[i] = m[i].clone();
		}
		return p;
	}
	public void start_game() {
		//gameMaps = (ArrayList<GameMap>) gameMapsCopy.clone(); 
		this.won = false;
		this.level = 0;

		this.map = gameMaps.get(level);

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

	public void addMap(GameMap m) {
		gameMaps.add(m);

	}
}
