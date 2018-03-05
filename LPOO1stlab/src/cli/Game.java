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

public class Game {

	public static void main(String[] args) {
		Map kapa = new Map(); 
		Guard g = new Guard(8,1,kapa);
		Ogre o = new Ogre(4,1, kapa);
		Lever l = new Lever(7,8, kapa);
		Hero h = new Hero(1,1, kapa,l);

		System.out.println(g.getTypeOfGuard() + " is the chosen guard\n\n");
		kapa.printmap();

		while(!(l.getKey() && h.isOnStairs() )) {

			if(g.nextToMe(h.getX(), h.getY()) && (!g.getasleep()))
			{
				System.out.println("GAME OVER!");
				return ;
			}

			h.getMove();

			///// para teste 

			g.movement();

			///// para teste
			kapa.setMapSymbol(g.getX(), g.getY(), g.getsymbol());

			if (h.equals(l)) { //change the doors when the Hero push the lever

				kapa.setMapSymbol(0, 5, 'S');
				kapa.setMapSymbol(0, 6, 'S');
			}

			kapa.printmap();

		}

		/*kapa.fillSndMap();
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
		System.out.print("You have finished the game ! Congrats\n");
	}
}
