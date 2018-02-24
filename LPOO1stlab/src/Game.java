
public class Game {

	public static void main(String[] args) {
		Map kapa = new Map(); 
		Hero h = new Hero();
		kapa.fillmap();
		kapa.printmap();
		
		while(true) {
			h.getMove();

			if(kapa.checkNextPosition(h.getnx(), h.getny())) {
				kapa.deleteCell(h.getx(),h.gety());
				h.set();
				kapa.printmap();

			}

		}
	}
}
