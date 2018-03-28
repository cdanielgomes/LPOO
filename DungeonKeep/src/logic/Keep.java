package logic;

import java.util.ArrayList;

public class Keep extends GameMap{

	private ArrayList<Ogre> hordOfOgres = new ArrayList<Ogre>();

	public Keep(char[][] map, int numberofogres, Door door) {
		super(map);
		this.door = door;
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

	/*
	 * check if hero is dead -> next to a ogre or his weapon
	 * */

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


	/*
	 * Delete all position in the map
	 * */
	@Override
	void deleteOldPositions() {
		deleteCell(hero);
		for (Ogre i : hordOfOgres) {
			deleteCell(i);
			deleteCell(i.getWeapon());
		}
	}


	/*
	 * set the map symbols in the positions
	 * */
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





}
