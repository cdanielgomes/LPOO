package logic;

import java.util.ArrayList;

public class Keep extends GameMap{
	private ArrayList<Ogre> hordOfOgres = new ArrayList<Ogre>();

	public Keep(char[][] map, int numberofogres) {
		super(map);
		ArrayList<Door> p = new ArrayList<Door>(); 
		p.add(new Door(getCharc('I')));
		this.door = p; 
		for (int i = 0 ; i < numberofogres; i++) {
			hordOfOgres.add(new Ogre(getCharc('O')));
		}
	}





	@Override
	public	void autoMoves(char heromove) {

		hero.calculateNextPos(this, heromove);

		for (Ogre i : hordOfOgres)
			i.calculateNextPos(this);
	}


	@Override
	public boolean endOfGame() {
		for (Ogre i : hordOfOgres) {

			if(i.checkProximity(hero) && hero.isArmed()) {
				i.setStun(true);
			}
			if (i.checkProximity(hero) && !i.isStun())
				return true;

			if (i.getWeapon().checkProximity(hero)) {
				return true;
			}

		}

		return false;
	}

	@Override
	void deleteOldPositions() {
		deleteCell(hero);
		for (Ogre i : hordOfOgres) {
			deleteCell(i);
			deleteCell(i.getWeapon());
		}
	}

	@Override
	void setNewPositions() {

		setMapSymbol(hero);
		if(!hero.hasLever())
			setMapSymbol(lever);

		for (Ogre i : hordOfOgres) {
			setMapSymbol(i);
			setMapSymbol(i.getWeapon());
		} 

	}


	public ArrayList<Ogre> getHordOfOgres() {
		return hordOfOgres;
	}

}
