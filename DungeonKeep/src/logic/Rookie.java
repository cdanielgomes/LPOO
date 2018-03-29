package logic;

public class Rookie extends Guard{

	public Rookie(Position position, String name, char[] moves) {
		super(position, name, moves);
	}

	@Override
	public void movement() {
		this.guardMoves();
	}

}
 