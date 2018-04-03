package logic;

public class Door extends Character {

	public Door(Position position) {
		super(position);
		this.symbol = 'I';
	}

	public void openDoor(GameMap map) {
			this.setSymbol('S');
			map.setMapSymbol(this);
	}

	
}
