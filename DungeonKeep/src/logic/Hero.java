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

		Position newPos = super.move(move);
		char symbol = map.getMapSymbol(newPos);
		
		switch(symbol) {
		case 'X':
			break;
		case 'k':
			setPosition(newPos);
			this.symbol = 'K';
			setLever(true);
			break;
		case 'S':
			this.setNextLevel(true);
			break;
		case ' ':
			setPosition(newPos);
			break;
		case 'I':
			if (map.getDoor().equals(newPos) && this.lever)
				this.kickDoor = true;
			break;
			
		case '*':
			if(!hasLever()) {
				this.setSymbol('A');
			}
			this.arm = true;
			setPosition(newPos);
			break;
		default:
			break;
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
