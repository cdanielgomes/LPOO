package cli;
import logic.*;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		
		Map kapa = new Map(); 
		Hero h = new Hero();
		Guard g = new Guard();
		Ogre o = new Ogre();
		 
		
		System.out.println(g.TypeOfGuard + " is the chosen guard\n\n");
		kapa.printmap();

		while(!h.key && !((h.getx() == 0 && h.gety() == 5) || (h.getx() == 0 && h.gety() == 6))) {

			if(g.nextToMe(h.getx(), h.gety()) && (!g.getasleep()))
			{
				System.out.println("GAME OVER!");
				return ;
			}

			h.getMove();

			kapa.deleteCell(g.getx(), g.gety());
			
			///// para teste 
			
			g.movement();
			
			///// para teste
			kapa.setMapSymbol(g.getx(), g.gety(), g.getsymbol());

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

		}

		kapa.fillSndMap();
		kapa.printmap();
		h.set(1, 8);
		h.setn(1, 8);
		h.setkey(false);


		while(!(h.getx() == 0 && h.gety() == 1))
		{
			kapa.deleteCell(o.getx(), o.gety());
			kapa.deleteCell(o.getWeaponx(), o.getWeapony());
			
			if(o.nextToMe(h.getx(), h.gety()) || o.nextToWeapon(h.getx(), h.gety()))
			{
				System.out.println("GAME OVER!");
				return ;
			}

			h.getMove();
			
			o.ogreMove();

	
			o.setSymbol('O');
			o.setWeaponSymbol('*');



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

			if(!h.key && o.nextToWeapon(8, 1)){
				kapa.setMapSymbol(8, 1, 'k');
				
			}
			
			if(kapa.getMapSymbol(o.getx(), o.gety()) == 'k' ) {
				o.setSymbol('$');
			}
			
			if(kapa.getMapSymbol(o.getWeaponx(), o.getWeapony()) == 'k' ) {
				o.setWeaponSymbol('$');
				o.setWeaponFlag(false);
			}
			 
			if(!o.weaponFlag && !h.key) {
				o.setWeaponFlag(true);
				kapa.setMapSymbol(8,1, 'k');
			}
			
			kapa.setMapSymbol(o.getWeaponx(), o.getWeapony(), o.getweponSymbol());
			kapa.setMapSymbol(o.getx(), o.gety(), o.getSymbol());
			if(!o.weaponFlag && !h.key) {
				o.setWeaponFlag(true);
				kapa.setMapSymbol(8,1, 'k');
			}
			kapa.printmap();
		}
		System.out.print("You have finished the game ! Congrats\n");
	}
}