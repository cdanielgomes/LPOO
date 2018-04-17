package logic;

import java.util.ArrayList;

/**
 * Represents the second level of the game (Keep level)
 */

public class Keep extends GameMap{
	private ArrayList<Ogre> hordOfOgres = new ArrayList<Ogre>();

	/**
	 * Constructor of class Keep
	 * @param map map of the level
	 * @param numberofogres number of ogres in the level
	 * @param j exit doors in type ArrayList<Door>
	 * 
	 */

	public Keep(char[][] map, int numberofogres) {
		super(map);
		ArrayList<Door> p = new ArrayList<Door>(); 
		p.add(new Door(getCharc('I')));
		this.door = p; 
		for (int i = 0 ; i < numberofogres; i++) {
			hordOfOgres.add(new Ogre(getCharc('O')));
		}
	}
	/**
	 * Makes the moves of all the ogres and hero
	 * @param heromove new move direction of hero
	 */


	@Override
	public	void autoMoves(char heromove) {

		hero.calculateNextPos(this, heromove);

		for (Ogre i : hordOfOgres)
			i.calculateNextPos(this);
	}

	/**
	 * Checks if game is over
	 * @return true if game is over , false if not
	 */

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

	/**
	 * Deletes old Position of the ogres and hero
	 */
	@Override
	void deleteOldPositions() {
		deleteCell(hero);
		for (Ogre i : hordOfOgres) {
			deleteCell(i);
			deleteCell(i.getWeapon());
		}
	}

	/**
	 * Sets new Positions of the map Characters
	 */
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

	/**
	 * Returns the hord of ogres
	 * @return variable hordOfOgres of type ArrayList<Ogre>
	 */

	public ArrayList<Ogre> getHordOfOgres() {
		return hordOfOgres;
	}

}
