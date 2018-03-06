package cli;
import logic.Guard;
import logic.Guard.*;
import logic.Hero;
import logic.Hero.*;
import logic.Lever;
import logic.Map;
import logic.Map.*;
import logic.Ogre;
import logic.Ogre.*;
import logic.GameState;

public class Game {

	public static void main(String[] args) {
		
		GameState game = new GameState();
		//	System.out.println(g.getTypeOfGuard() + " is the chosen guard\n\n");

		
		
		do {
			game.setEnemies();
			game.display();

			while(game.getGameEnd() != 1 && game.getGameWon() == 0 && game.getGameOver() == 0) {
				
				game.updateGame();
				game.display();
				
				if (game.getNextLevel() == 1) {
					break;
				}
				
				
			}
			
			
		}while(game.getGameEnd() != 1 && game.getGameWon() == 0 && game.getGameOver() == 0);


		/*	kapa.fillSndMap();
		kapa.printmap();
		h.set(1, 8);
		l.setKey(false);

		while(!(h.getX() == 0 && h.getY() == 1))
		{
			kapa.deleteCell(o.getX(), o.getY());
			kapa.deleteCell(o.getWeaponx(), o.getWeapony());

			if(o.nextToMe(h.getX(), h.getY()) || o.nextToWeapon(h.getX(), h.getY()))
			{
				System.out.println("GAME OVER!");
				return ;
			}

			h.getMove();

			o.ogreMove();


			o.setSymbol('O');
			o.setWeaponSymbol('*');



			if(kapa.checkNextPosition(h.getnx(), h.getny())) {

				kapa.deleteCell(h.getX(),h.getY());

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
					h.setn(h.getX(), h.getY()); //set the next position as the old position
				}


			}


			if(!h.key && o.nextToMe(8, 1)) {
				kapa.setMapSymbol(8, 1, 'k');
			}

			if(!h.key && o.nextToWeapon(8, 1)){
				kapa.setMapSymbol(8, 1, 'k');

			}

			if(kapa.getMapSymbol(o.getX(), o.getY()) == 'k' ) {
				o.setSymbol('$');
			}

			if(kapa.getMapSymbol(o.getWeaponx(), o.getWeapony()) == 'k' ) {
				o.setWeaponSymbol('$');
				o.setWeaponFlag(false);
			}

			if(!o.getWeaponFlag() && !h.key) {
				o.setWeaponFlag(true);
				kapa.setMapSymbol(8,1, 'k');
			}

			kapa.setMapSymbol(o.getWeaponx(), o.getWeapony(), o.getweponSymbol());
			kapa.setMapSymbol(o.getX(), o.getY(), o.getNormalSymbol());
			if(!o.getWeaponFlag() && !h.key) {
				o.setWeaponFlag(true);
				kapa.setMapSymbol(8,1, 'k');
			}
			kapa.printmap();
		}*/
	}
}
