package logic;

public class Character {

	protected Position position;
	protected char symbol;

	public Character(Position position) {
		this.position = position;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public void setPosition(Position newPosition) {
		this.position = newPosition;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public Position getPos() {
		return this.position;
	}
	public Position move(char c) {		

		Position pos = new Position();
		switch(c) {
		case 'a':
			pos.setPosition(this.position.getX()-1, this.position.getY());
			break;
		case 'w':
			pos.setPosition(this.position.getX(), this.position.getY()-1);

			break;
		case 's':
			pos.setPosition(this.position.getX(), this.position.getY()+1);
			break;
		case 'd':
			pos.setPosition(this.position.getX()+1, this.position.getY());
			break;
		default:
			break;
		}
		
		return pos;
	}
	
	public Position reversemove(char c) {		

		Position pos = new Position();
		switch(c) {
		case 'a':
			pos.setPosition(this.position.getX()+1, this.position.getY());
			break;
		case 'w':
			pos.setPosition(this.position.getX(), this.position.getY()+1);

			break;
		case 's':
			pos.setPosition(this.position.getX(), this.position.getY()-1);
			break;
		case 'd':
			pos.setPosition(this.position.getX()-1, this.position.getY());
			break;
		default:
			break;
		}
		
		return pos;
	}
	
	public boolean checkProximity(Character obj) {
		
		int diferencex = position.getX() - obj.position.getX(), diferencey = position.getY()- obj.position.getY();

		if ((diferencex == 1 || diferencex == -1 || diferencex == 0) && diferencey == 0)
			return true;
		if ((diferencey == 1 || diferencey == -1 || diferencey == 0) && diferencex == 0)
			return true;
		return false;
	}

	
	
}
