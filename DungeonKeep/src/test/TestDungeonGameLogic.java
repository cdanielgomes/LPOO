package test;

import static org.junit.Assert.*;
import org.junit.Test;

import logic.Character;
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
		GameMap newmap = new Dungeon(map , "Rookie");
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		//newmap.autoMoves('s');
		//newmap.getHero().calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 's');
		assertEquals(new Position(2,1) , newmap.getHeroPos());
	}
	
	@Test
	public void testMoveHeroIntoWall() {
		GameMap newmap = new Dungeon(map , "Rookie");
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.hero.calculateNextPos(newmap, 'a');
		assertEquals(new Position(1,1) , newmap.getHeroPos());
	}
	
	@Test
	public void testHeroCapturedByGuard() {
		GameMap newmap = new Dungeon(map , "Rookie");
		assertFalse(newmap.endOfGame());
		newmap.hero.calculateNextPos(newmap, 'd');
		assertTrue(newmap.endOfGame());
	}
	
	@Test
	public void testHeroMovesIntoClosedDoor() {
		GameMap newmap = new Dungeon(map , "Rookie");
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 'a');
		assertFalse(newmap.endOfGame());
	}
	
	@Test
	public void testHeroMovesIntoLeverAndDoorsOpen() {
		GameMap newmap = new Dungeon(map , "Rookie");
		assertEquals('I' , newmap.getMapSymbol(new Position(0,2)));
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 's');
		assertEquals('S' , newmap.getMapSymbol(new Position(0,2)));
		
	}
	
	@Test
	public void testHeroMovesToKeep() {
		GameMap newmap = new Dungeon(map ,"Rookie");
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 'a');
		assertTrue(newmap.hero.nextLevel());
	}
	

}
