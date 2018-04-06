package logic;

import java.util.ArrayList;

public class Dungeon extends GameMap {

	private Guard guard;
	
	public Dungeon(char[][] map, String i, ArrayList<Door> door, char[] guardMove) {
		super(map);
		this.door = door;
		setGuard(i, guardMove);

	}

	public Dungeon(Dungeon d) {
		super(d);
		this.door = d.door;
		this.guard = d.guard;
	}
	
	public void setGuard(String i, char[] guardMove) {

		switch(i) {
		case "Rookie":
			guard = new Rookie(this.getCharc('G'), "Rookie", guardMove);
			break;
		case "Suspicious":
			guard = new Suspicious(this.getCharc('G'), "Suspicious", guardMove);
			break;
		case "Drunken":
			guard = new Drunken(this.getCharc('G'), "Drunken", guardMove);
			break;
		}
	}
	
	public Guard getGuard() {
		return guard;
	}

	public boolean endOfGame() {
		return guard.checkProximity(hero) && !guard.asleep;

	}

	@Override
	public void deleteOldPositions() {
		deleteCell(hero);
		deleteCell(guard);
	}

	@Override
	public void setNewPositions() {
		setMapSymbol(guard);
		setMapSymbol(hero);
	} 

	@Override
	public void autoMoves(char heromove) {
		hero.calculateNextPos(this, heromove);
		guard.movement();
	}



}
