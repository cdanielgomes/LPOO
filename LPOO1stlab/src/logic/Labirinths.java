package logic;

import java.util.ArrayList;

public class Labirinths { 

	private ArrayList<Map> maps = new ArrayList<Map>();
	private int level = 0;
	
	public Labirinths() {
		super();
		int[] x = {0,5,0,6};
		addMap(new Map(map, true, false, x));
		int[] y = {0,1};
		addMap(new Map(map, false, true, y));
	}
	

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

	public void addMap(Map map) {
		maps.add(map);
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

	public Map getMap() {

		return this.maps.get(this.level);

	}



}
