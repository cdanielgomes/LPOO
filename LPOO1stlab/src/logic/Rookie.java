package logic;

public class Rookie extends Guard{

	public Rookie(int x, int y, Map map , String name) {
		super(x, y, map , name);
	}

	@Override
	public void movement() {
		this.guardMoves();
	}

}
