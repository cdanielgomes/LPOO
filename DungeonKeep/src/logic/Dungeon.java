package logic;

public class Dungeon extends GameMap {

	private Guard guard;
	private Door door1;
	
	public Dungeon(char[][] map, String i, Door door1, Door door2, char[] guardMove) {
		super(map);
		this.door = door1;
		this.door1 = door2;
	
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

	/**
	 * @return the guard
	 */
	public Guard getGuard() {
		return guard;
	}

	public boolean endOfGame() {
		return guard.checkProximity(hero) && !guard.asleep;

	}

	@Override
	void deleteOldPositions() {
		deleteCell(hero);
		deleteCell(guard);
	}

	@Override
	void setNewPositions() {
		setMapSymbol(guard);
		setMapSymbol(hero);
	} 

	@Override
	public	void autoMoves(char heromove) {
		hero.calculateNextPos(this, heromove);
		guard.movement();

		if(hero.hasLever()) {
			door1.openDoor(this);
			door.openDoor(this);
		}
	}
	

}
