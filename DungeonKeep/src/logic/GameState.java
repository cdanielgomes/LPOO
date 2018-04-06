package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class GameState implements Serializable {
	
	
	private static final long serialVersionUID = -1473666951067359647L;
	
	private ArrayList<GameMap> gameMaps = new ArrayList<GameMap>(); 
	private GameMap map;
	private String guard;
	private int nOgres;
	private boolean won = false;
	private int level = 0;

	private char[][] editor;
	
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

	public  GameState() {
		this.nOgres = 1;
		
	}
	
	public void initializeGame() {
		ArrayList<Door> i = new ArrayList<Door>(); 
		char[] moves = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd',
				'd', 'w', 'w', 'w', 'w', 'w' };
		i.add(new Door(new Position(0,5)));
		i.add(new Door(new Position(0,6)));
		GameMap m =  new Dungeon(map1,guard, i, moves); 
		gameMaps.add(m);
		m = new Keep(map2,nOgres);
		gameMaps.add(m);
		this.map = gameMaps.get(level);

	}

	public void setGuard(String guard) {
		this.guard = guard;
	}
	public void setnOgres(int i ) {
		this.nOgres = i;
	}

	
	public void start_game() {
		
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

	public int getNOgres() {
		return nOgres;
	}
	


}
