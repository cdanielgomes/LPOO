
public class Game {

	public static void main(String[] args) {
		Map kapa = new Map(); 
		Hero h = new Hero();
		Guard g = new Guard();
	
		kapa.printmap();
		
		
		while(!(h.key && ((h.getx() == 0 && h.gety() == 5) || (h.getx() == 0 && h.gety() == 6))) && g.nextToMe(h.getx(), h.gety())) {
			//condição do while esta errada
	
			h.getMove();
			
			kapa.deleteCell(g.getx(), g.gety());
			g.guardMoves();
			kapa.setMapSymbol(g.getx(), g.gety(), 'G');
			
			if(kapa.checkNextPosition(h.getnx(), h.getny())) {
				
				kapa.deleteCell(h.getx(),h.gety());
				
				if (kapa.getMapSymbol(h.getnx(),h.getny()) == 'k') { //change the doors when the Hero push the lever
					h.key = false;
					kapa.setMapSymbol(0, 5, 'S');
					kapa.setMapSymbol(0, 6, 'S');
				}
				
				kapa.setMapSymbol(h.getnx(), h.getny(), 'H');
				h.set();	

			}
			
			kapa.printmap();

		}
	}
}
