package test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import logic.Character;
import logic.Door;
import logic.Dungeon;
import logic.GameState;
import logic.GameMap;
import logic.Hero;
import logic.Keep;
import logic.Lever;
import logic.Position;


public class TestRandomBehavior {

	private char[][] map = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'k', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'H', ' ', '*', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

	@Test
	public void printMap() {
		GameState game = new GameState(1,"Rookie");
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,1)));
		game.setMap(new Keep(map, 1, j));

		assertEquals(game.getMap().tostring(),"XXXXXXXXXX\n"
				+ "I   O    X\n"
				+ "X   *    X\n"
				+ "Xk       X\n"
				+ "X        X\n"
				+ "X        X\n"
				+ "X        X\n"
				+ "X        X\n"
				+ "XH *     X\n"
				+ "XXXXXXXXXX\n");
	}


	@Test(timeout =1000)
	public void testOgreRandomPositions() {
		GameState g = new GameState(1,"Rookie");
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,1)));
		g.setMap(new Keep(map,1, j));
		int x;
		char[] moving = {'a', 's', 'd', 'w'};


		boolean left= false;
		boolean right= false;
		boolean up = false;
		boolean down = false;
		boolean key =false;
		boolean wall = false;
		boolean heroWeapon = false;
		Random rand = new Random();
		Position oldPos;
		Position newPos;
		while(!left || !right || !up || !down || !key || !wall || !heroWeapon)  {

			x = rand.nextInt(4);

			oldPos = ((Keep) g.getMap()).getHordOfOgres().get(0).getPos();

			g.movement(moving[x]);

			newPos = ((Keep) g.getMap()).getHordOfOgres().get(0).getPos();

			if (oldPos.equals(newPos)) {
				wall = true;
			}
			if(Left(newPos, oldPos))
				left = true;

			if(Right(newPos, oldPos))
				right = true;

			if( Up(newPos, oldPos))
				up = true;

			if( Down(newPos, oldPos))
				down = true;

			if(g.getMap().getHero().checkProximity(((Keep)g.getMap()).getHordOfOgres().get(0))) {
				assertEquals('O', ((Keep)g.getMap()).getHordOfOgres().get(0).getSymbol());
				heroWeapon = true;
			}

			if(((Keep) g.getMap()).getHordOfOgres().get(0).getPos().equals(g.getMap().getLever().getPos())){
				assertEquals('$', ((Keep) g.getMap()).getHordOfOgres().get(0).getSymbol());
				key = true;

			}


		}
	}

	@Test(timeout = 3000)
	public void testWeaponRandomPositions() {
		GameState g = new GameState(1,"Rookie");
		ArrayList<Door> j = new ArrayList<Door>();
		j.add(new Door(new Position(0,1)));
		g.setMap(new Keep(map,1, j));
		Random rand = new Random();
		char[] moving = {'a', 's', 'd', 'w'};
		boolean left= false;
		boolean right= false;
		boolean up = false;
		boolean down = false;
		boolean key =false;
		boolean over = false;
		int x;
		Position ogrePos;
		Position weaponPos;


		while(!left || !right || !up || !down || !key || !over)  {
			x = rand.nextInt(4);

			g.movement(moving[x]);

			ogrePos = ((Keep) g.getMap()).getHordOfOgres().get(0).getPos();
			weaponPos = ((Keep) g.getMap()).getHordOfOgres().get(0).getWeapon().getPos();

			if(Left(weaponPos, ogrePos))
				left = true;

			if(Right(weaponPos, ogrePos))
				right = true;

			if( Up(weaponPos, ogrePos))
				up = true;

			if( Down(weaponPos, ogrePos))
				down = true;

			if(g.over()) {
				over = true;
			}

			if(((Keep) g.getMap()).getHordOfOgres().get(0).getWeapon().getPos().equals(g.getMap().getLever().getPos())){
				assertEquals('$', ((Keep) g.getMap()).getHordOfOgres().get(0).getWeapon().getSymbol());
				key = true;

			}


		}
	}



	private boolean Left(Position newPos, Position oldPos) {

		return (newPos.getX() == oldPos.getX() - 1 && newPos.getY() == oldPos.getY());
	}

	private boolean Right(Position newPos, Position oldPos) {

		return (newPos.getX() == oldPos.getX() + 1 && newPos.getY() == oldPos.getY());

	}

	private boolean Up(Position newPos, Position oldPos) {

		return (newPos.getX() == oldPos.getX()  && newPos.getY() == oldPos.getY()-1);


	}

	private boolean Down(Position newPos, Position oldPos) {

		return (newPos.getX() == oldPos.getX()  && newPos.getY() == oldPos.getY()+1);

	}
}
