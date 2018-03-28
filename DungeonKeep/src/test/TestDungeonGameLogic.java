package test;

import static org.junit.Assert.*;
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
		GameMap newmap = new Dungeon(map , "Rookie", new Door(new Position(0,2)),new Door(new Position(0,3)),moves);
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		assertEquals(' ', newmap.getMapSymbol(newmap.getHero().move('s')));
		assertEquals('H' , newmap.getMapSymbol(newmap.getHeroPos()));
	}
	
	@Test
	public void testMoveHeroIntoWall() {
		char[] moves = {'s', 's','a','w','w','d'};
		GameMap newmap = new Dungeon(map , "Rookie",new Door(new Position(0,2)),new Door(new Position(0,3)),moves);
		assertEquals('X', newmap.getMapSymbol(newmap.getHero().move('a')));
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.autoMoves('a');
		assertEquals(new Position(1,1) , newmap.getHeroPos());
	}
	
	@Test
	public void testHeroCapturedByGuard() {
		char[] moves = {'s', 's','a','w','w','d'};
		GameMap newmap = new Dungeon(map , "Rookie",new Door(new Position(0,2)),new Door(new Position(0,3)),moves);
		assertFalse(newmap.endOfGame());
		newmap.autoMoves('a');
		newmap.autoMoves('a');
		newmap.autoMoves('a');
		newmap.autoMoves('s');
		assertTrue(newmap.getHero().checkProximity(((Dungeon)newmap).getGuard()));
		assertTrue(newmap.endOfGame());
	}
	
	@Test
	public void testHeroMovesIntoClosedDoor() {
		char[] moves = {'s', 's','a','w','w','d'};
		GameMap newmap = new Dungeon(map , "Rookie",new Door(new Position(0,2)),new Door(new Position(0,3)),moves);
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.autoMoves('s');
		newmap.autoMoves('a');
		assertFalse(newmap.endOfGame());
	}
	
	@Test
	public void testHeroMovesIntoLeverAndDoorsOpen() {
		char[] moves = {'s', 's','a','w','w','d'};
		GameMap newmap = new Dungeon(map , "Rookie",new Door(new Position(0,2)),new Door(new Position(0,3)),moves);
		assertEquals('I' , newmap.getMapSymbol(new Position(0,2)));
		newmap.autoMoves('s');
		assertEquals('k', newmap.getMapSymbol(newmap.getHero().move('s')));
		newmap.autoMoves('s');
		assertEquals('K', newmap.getHero().getSymbol());
		assertTrue(newmap.getHero().hasLever());
		assertEquals('S' , newmap.getMapSymbol(new Position(0,2)));
		
	}
	
	@Test
	public void testHeroMovesToKeep() {
		char[] moves = {'a','s','d','w'};
		GameMap newmap = new Dungeon(map ,"Rookie",new Door(new Position(0,2)),new Door(new Position(0,3)),moves);
		newmap.autoMoves('s');
		newmap.autoMoves('s');
		assertEquals('K', newmap.getHero().getSymbol());
		newmap.autoMoves('a');
		assertTrue(newmap.getHero().nextLevel());
	}
	

}