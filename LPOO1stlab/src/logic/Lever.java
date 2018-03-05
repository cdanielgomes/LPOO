package logic;

public class Lever extends Character {

	private char symbol = 'k';
	private boolean key = false;
	public Lever(int x, int y, Map map) {
		super(x, y, map);
		
	}
	public boolean getKey() {
		return key;
	}
	public void setKey(boolean key) {
		this.key = key;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	
	

	
}
