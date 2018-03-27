package test;

import static org.junit.Assert.*;

import org.junit.Test;

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
	public void testHeroNextToOgre() {
		GameMap newmap = new Keep(map , 1);
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		assertFalse(newmap.endOfGame());
		newmap.hero.calculateNextPos(newmap, 'd');
		assertTrue(newmap.endOfGame());
	}
	
	@Test
	public void testHeroHasKey() {
		GameMap newmap = new Keep(map , 1);
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 's');
		assertEquals('K', newmap.getHero().getSymbol());
	}
	
	@Test
	public void testHeroMoveToDoorsAndFailsToLeave() {
		GameMap newmap = new Keep(map , 1);
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.hero.calculateNextPos(newmap, 'w');
		assertEquals(new Position(1,1),newmap.getHero().getPos());
		assertFalse(newmap.endOfGame());
	}
	
	@Test
	public void testHeroMoveToDoorsAndDoorsOpen() {
		GameMap newmap = new Keep(map , 1);
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 'w');
		newmap.hero.calculateNextPos(newmap, 'w');
		newmap.hero.calculateNextPos(newmap, 'w');
		assertTrue(newmap.endOfGame());
	}
	
	@Test
	public void testHeroWinsKeep() {
		GameMap newmap = new Keep(map , 1);
		assertEquals(new Position(1,1) , newmap.getHeroPos());
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 's');
		newmap.hero.calculateNextPos(newmap, 'w');
		newmap.hero.calculateNextPos(newmap, 'w');
		newmap.hero.calculateNextPos(newmap, 'w');
		assertTrue(newmap.endOfGame());
	}
	
	
	

}
