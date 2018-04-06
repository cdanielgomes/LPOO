package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logic.Door;
import logic.Dungeon;
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
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(1,0)));
		GameMap newmap = new Keep(map ,1);
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		assertFalse(newmap.endOfGame());
		newmap.getHero().calculateNextPos(newmap, 'd');
		assertTrue(newmap.endOfGame());
	}

	@Test
	public void testgetHeroHasKey() {
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(1,0)));
		GameMap newmap = new Keep(map ,1);
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals('K', newmap.getHero().getSymbol());
	}

	@Test
	public void testgetHeroMoveToDoorsAndFailsToLeave() {
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(1,0)));
		GameMap newmap = new Keep(map ,1);
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals(new Position(1,1),newmap.getHero().getPos());
		assertFalse(newmap.endOfGame());
	}

	@Test
	public void testgetHeroMoveToDoorsAndDoorsOpen() {
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(1,0)));
		GameMap newmap = new Keep(map ,1);
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 's');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');
		newmap.getHero().calculateNextPos(newmap, 'w');

		assertEquals('S', newmap.getMapSymbol(new Position(1,0)));


	}

	@Test
	public void testgetHeroWinsKeep() {
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(1,0)));
		GameMap newmap = new Keep(map ,1);
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 's');
		assertEquals(new Position(1,2) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 's');
		assertEquals(new Position(1,3) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals(new Position(1,2) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals(new Position(1,1) , newmap.getHero().getPos());
		newmap.getHero().calculateNextPos(newmap, 'w');
		assertEquals(new Position(1,0) , newmap.getHero().getPos());
		assertTrue(newmap.getHero().getPos().equals(newmap.getDoor().get(0).getPos()));

	}




}
