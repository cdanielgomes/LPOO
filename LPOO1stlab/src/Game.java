
public class Game {

	public static void main(String[] args) {
		Map kapa = new Map(); 
		Hero h = new Hero();
		Guard g = new Guard();
		Ogre o = new Ogre();

			/*kapa.printmap();

		while(!h.key && !((h.getx() == 0 && h.gety() == 5) || (h.getx() == 0 && h.gety() == 6))) {

			if(g.nextToMe(h.getx(), h.gety()))
			{
				System.out.println("GAME OVER!");
				return ;
			}

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
				h.set(h.getnx(),h.getny());	

			}

			kapa.printmap();

		}*/

		kapa.fillSndMap();
		kapa.printmap();
		h.set(1, 8);
		h.setn(1, 8);
		h.setkey(false);


		while(!(h.getx() == 0 && h.gety() == 1))
		{
			kapa.deleteCell(o.getx(), o.gety());
			if(o.nextToMe(h.getx(), h.gety()))
			{
				System.out.println("GAME OVER!");
				return ;
			}

			h.getMove();
			
			o.ogreMove();

	
			o.setSymbol('O');



			if(kapa.checkNextPosition(h.getnx(), h.getny())) {

				kapa.deleteCell(h.getx(),h.gety());

				if (kapa.getMapSymbol(h.getnx(),h.getny()) == 'k') { 
					h.setkey(true);
					h.setSymbol('K');
				}

				kapa.setMapSymbol(h.getnx(), h.getny(), h.getSymbol());

				h.set(h.getnx(),h.getny());	



			}
			else {


				if (kapa.getMapSymbol(h.getnx(),h.getny()) == 'I' && h.key) {
					kapa.setMapSymbol(h.getnx(), h.getny(), ' ');
					h.setn(h.getx(), h.gety()); //set the next position as the old position
				}


			}
			

			if(!h.key && o.nextToMe(8, 1)) {
				kapa.setMapSymbol(8, 1, 'k');
			}

			if(kapa.getMapSymbol(o.getx(), o.gety()) == 'k') {
				o.setSymbol('$');
			}			
			
			kapa.setMapSymbol(o.getx(), o.gety(), o.getSymbol());
			kapa.printmap();
		}
		System.out.print("You have finished the game ! Congrats\n");
	}
}
