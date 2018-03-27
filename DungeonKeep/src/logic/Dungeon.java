package logic;

public class Dungeon extends GameMap {

	private Guard guard;
	private Door door1;
	
	public Dungeon(char[][] map, int i ) {
		super(map);
		this.door = new Door(new Position(0,5));
		this.door1 = new Door(new Position(0,6));
	
		switch(i) {
		case 2:
			guard = new Rookie(this.getCharc('G'), "Rookie");
			break;
		case 3:
			guard = new Suspicious(this.getCharc('G'), "Suspicious");
			break;
		case 1:
			guard = new Drunken(this.getCharc('G'), "Drunken");
			break;
		}

	}


	@Override
	public boolean endOfGame() {
		return guard.checkProximity(hero);
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
	
	x

}
