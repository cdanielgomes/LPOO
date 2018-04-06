package logic;

/**
 * Class that represents the Hero of the game,
 * extends Character
 */
public class Hero extends Character{

	private boolean arm = false;
	private boolean lever = false;
	private boolean nextLevel = false;
	public boolean kickDoor = false;

	/**
	 * Constructor of class Hero
	 * @param position postion of the Hero in the map
	 * 
	 */
	public Hero(Position position) {
		super(position);
		this.symbol = 'H';

	}

	/**
	 * Calculates the next position of the Hero
	 * @param map GameMap which has the map where the hero moves
	 * @param move next move direction
	 */
	
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

	/**
	 * Checks if the hero can open the door
	 * @param map GameMap which has the current map of the game
	 * @param newPos new position of the hero
	 */
	
	public void ICompound(GameMap map, Position newPos ) {
		for (Door i: map.getDoor()) {
			if (i.getPos().equals(newPos) && this.lever) {
				this.kickDoor = true;
				i.openDoor(map);
			}
		}
	}

	/**
	 * If the hero catch the key , then the exit doors are now open
	 * @param map GameMap of the game
	 * @param newPos new Position of the hero
	 */
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

	/**
	 * Returns arm flag value
	 * @return true if armed , false if not
	 */
	public boolean isArmed() {
		return arm;
	}

	/**
	 * Returns if hero has lever 
	 * @return true if has , false if not
	 */
	public boolean hasLever() {
		return lever;
	}

	/**
	 * Changes value of lever variable
	 * @param lever new value 
	 */
	public void setLever(boolean lever) {
		this.lever = lever;
	}

	/**
	 * Checks if can go to next level
	 * @return true if is posible to advance in the level of the game , false if not
	 */
	public boolean nextLevel() {
		return nextLevel;
	}

	/**
	 * Changes nextLevel value
	 * @param nextLevel new value of the variable nextLevel
	 */
	
	public void setNextLevel(boolean nextLevel) {
		this.nextLevel = nextLevel;
	}
}
