package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logic.Character;
import logic.Door;
import logic.Dungeon;
import logic.GameState;
import logic.GameMap;
import logic.Hero;
import logic.Lever;
import logic.Position;


public class TestDungeonGameLogic {
	
	
	char [][] map = {{'X','X','X','X','X'},
			         {'X','H',' ','G','X'},
	 				 {'I',' ',' ',' ','X'},
	 				 {'I','k',' ',' ','X'},
	 				 {'X','X','X','X','X'}
					};

	
	@Test
	public void testMoveHeroIntoFreeCell() {
		char[] moves = {'s', 's','a','w','w','d'};
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,2)));
		j.add(new Door(new Position(0,3)));
		GameMap newmap = new Dungeon(map , "Rookie", j,moves);
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		assertEquals(' ', newmap.getMapSymbol(newmap.getHero().move('s', false)));
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap, 's'); 
		((Dungeon) newmap).setNewPositions();
		assertEquals(new Position(1,2), newmap.getHero().getPos());
	}
	
	@Test
	public void testMoveHeroIntoWall() {
		char[] moves = {'s', 's','a','w','w','d'};
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,2)));
		j.add(new Door(new Position(0,3)));
		GameMap newmap = new Dungeon(map , "Suspicious", j,moves);
		assertEquals('X', newmap.getMapSymbol(newmap.getHero().move('a', false)));
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap,'a');
		((Dungeon) newmap).setNewPositions();
		assertEquals(new Position(1,1) , newmap.getHero().getPos());

	}
	
	@Test
	public void testHeroCapturedByGuard() {
		char[] moves = {'s', 's','a','w','w','d'};
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,2)));
		j.add(new Door(new Position(0,3)));
		GameMap newmap = new Dungeon(map , "Drunken", j,moves);
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap,'d');
		((Dungeon) newmap).setNewPositions();
		assertTrue(newmap.getHero().checkProximity(((Dungeon)newmap).getGuard()));
		assertTrue(newmap.endOfGame());
	}
	
	@Test
	public void testHeroMovesIntoClosedDoor() {
		char[] moves = {'s', 's','a','w','w','d'};
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,2)));
		j.add(new Door(new Position(0,3)));
		GameMap newmap = new Dungeon(map , "Rookie", j,moves);
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap,'s');
		((Dungeon) newmap).setNewPositions();
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap,'a');
		((Dungeon) newmap).setNewPositions();
		assertFalse(newmap.endOfGame());
	}
	
	@Test
	public void testHeroMovesIntoLeverAndDoorsOpen() {
		char[] moves = {'s', 's','a','w','w','d'};
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,2)));
		j.add(new Door(new Position(0,3)));
		GameMap newmap = new Dungeon(map , "Rookie", j,moves);
		assertEquals('I' , newmap.getMapSymbol(new Position(0,2)));
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap,'s');
		((Dungeon) newmap).setNewPositions();
		assertEquals('k', newmap.getMapSymbol(newmap.getHero().move('s', false)));
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap,'s');
		((Dungeon) newmap).setNewPositions();
		assertEquals('K', newmap.getHero().getSymbol());
		((Dungeon) newmap).deleteOldPositions();
		assertTrue(newmap.getHero().hasLever());
		((Dungeon) newmap).setNewPositions();
		assertEquals('S' , newmap.getMapSymbol(new Position(0,2)));
	}
	
	@Test
	public void testHeroMovesToKeep() {
		char[] moves = {'a','s','d','w'};
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,2)));
		j.add(new Door(new Position(0,3)));
		GameMap newmap = new Dungeon(map , "Rookie", j,moves);
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap,'s');
		((Dungeon) newmap).setNewPositions();
		((Dungeon) newmap).deleteOldPositions();
		newmap.getHero().calculateNextPos(newmap,'s');
		((Dungeon) newmap).setNewPositions();
		assertEquals('K', newmap.getHero().getSymbol());
		newmap.getHero().calculateNextPos(newmap,'a');
		assertTrue(newmap.getHero().nextLevel());
	}
	

}