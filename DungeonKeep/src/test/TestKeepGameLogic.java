package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Door;
import logic.GameMap;
import logic.Keep;
import logic.Position;


public class TestKeepGameLogic {
	
	char [][] map = {{'X','I','X','X','X'},
	         		 {'X','H',' ','O','X'},
	         	     {'X',' ',' ','*','X'},
	         	     {'X','k',' ',' ','X'},
	         	     {'X','X','X','X','X'}
					};

	
	@Test
	public void testgetHeroNextToOgre() {
		GameMap newmap = new Keep(map ,1, new Door(new Position(1,0)));
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		assertFalse(newmap.endOfGame());
		newmap.getHero().calculateNextPos(newmap, 'd');
		assertTrue(newmap.endOfGame());
	}
	
	@Test
	public void testgetHeroHasKey() {
		GameMap newmap = new Keep(map ,1, new Door(new Position(1,0)));
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals('K', newmap.getHero().getSymbol());
	}
	
	@Test
	public void testgetHeroMoveToDoorsAndFailsToLeave() {
		GameMap newmap = new Keep(map ,1, new Door(new Position(1,0)));
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals(new Position(1,1),newmap.getHero().getPos());
		assertFalse(newmap.endOfGame());
	}
	
	@Test
	public void testgetHeroMoveToDoorsAndDoorsOpen() {
		GameMap newmap = new Keep(map ,1, new Door(new Position(1,0)));
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals(' ', newmap.getMapSymbol(new Position(1,0)));
		
		
	}
	
	@Test
	public void testgetHeroWinsKeep() {
		GameMap newmap = new Keep(map ,1, new Door(new Position(1,0)));
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertTrue(newmap.getHero().getPos().equals(newmap.getDoor().getPos()));
	}
	
	
	

}
