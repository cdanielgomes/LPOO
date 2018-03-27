package logic;

public class Dungeon extends GameMap {

	private Guard guard;
	private Door door1;
	
	public Dungeon(char[][] map, String i ) {
		super(map);
		this.door = new Door(new Position(0,5));
		this.door1 = new Door(new Position(0,6));
	
		switch(i) {
		case "Rookie":
			guard = new Rookie(this.getCharc('G'), "Rookie");
			break;
		case "Suspicious":
			guard = new Suspicious(this.getCharc('G'), "Suspicious");
			break;
		case "Drunken":
			guard = new Drunken(this.getCharc('G'), "Drunken");
			break;
		}

	}


	@Override
<<<<<<< HEAD
	public boolean endOfGame() {
		return guard.checkProximity(hero);
=======
	boolean endOfGame() {
		return guard.checkProximity(hero) && !guard.asleep;
>>>>>>> d755e7479985fa23e9b472facb81a45955d13846
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
