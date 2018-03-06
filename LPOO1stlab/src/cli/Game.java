package cli;
import logic.Guard;
import logic.Guard.*;
import logic.Hero;
import logic.Hero.*;
import logic.Lever;
import logic.Map;
import logic.Map.*;
import logic.Ogre;
import logic.Ogre.*;

import java.util.Scanner;

import logic.GameState;

public class Game {

	public static void main(String[] args) {
		
		GameState game = new GameState();
		

		
		
		do {
			game.setEnemies();
			game.display();

			while(game.getGameEnd() != 1 && game.getGameWon() == 0 && game.getGameOver() == 0) {
				
				game.updateGame();
				game.display();
				
				if (game.getNextLevel() == 1) {
					break;
				}
				
				
			}
			
			
		}while(game.getGameEnd() != 1 && game.getGameWon() == 0 && game.getGameOver() == 0);
	}
	
	public int userChooseGuardType() {
		System.out.println("1 - Drunken\n2 - Rookie\n3 - Suspicious\nSelect the guard : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		return num;
	}
	
	
}
