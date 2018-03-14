package logic;

public class Rookie extends Guard{

	public Rookie(Position position, String name) {
		super(position, name);
	}

	@Override
	public void movement() {
		this.guardMoves();
	}

}
