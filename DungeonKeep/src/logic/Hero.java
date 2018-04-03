package logic;

public class Hero extends Character{

	private boolean arm = false;
	private boolean lever = false;
	private boolean nextLevel = false;
	public boolean kickDoor = false;

	public Hero(Position position) {
		super(position);
		this.symbol = 'H';

	}
	
	public void calculateNextPos(GameMap map , char move) {
		Position newPos = super.move(move, false);
		char symbol = map.getMapSymbol(newPos);
		switch(symbol) {
		case 'X':
			break;
		case 'k':
			kCompund(map, newPos);
			break;
		case 'S':
			this.setPosition(newPos);
			this.setNextLevel(true);
			break;
		case ' ':
			setPosition(newPos);
			break;
		case 'I':
			ICompound(map, newPos);
			break;
		case '*':
			if(!hasLever()) this.setSymbol('A');
			this.arm = true;
			setPosition(newPos);
			break;
		default:
			setPosition(newPos);
			break;
		}
	}

	
	public void ICompound(GameMap map, Position newPos ) {
		for (Door i: map.getDoor()) {
			if (i.getPos().equals(newPos) && this.lever) {
				this.kickDoor = true;
				i.openDoor(map);
			}
		}
	}
	public void kCompund(GameMap map, Position newPos) {
		setPosition(newPos);
		this.symbol = 'K';
		setLever(true);
		if(map instanceof Dungeon) {
			for(Door i : map.getDoor()) {
				i.openDoor(map);
			}
		}
	}
	public boolean isArmed() {
		return arm;
	}
	public boolean hasLever() {
		return lever;
	}

	public void setLever(boolean lever) {
		this.lever = lever;
	}

	public boolean nextLevel() {
		return nextLevel;
	}
	
	public void setNextLevel(boolean nextLevel) {
		this.nextLevel = nextLevel;
	}
}
