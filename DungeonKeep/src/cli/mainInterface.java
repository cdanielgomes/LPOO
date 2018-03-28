package cli;

import java.util.Scanner;

import logic.Door;
import logic.Dungeon;
import logic.GameState;
import logic.Keep;
import logic.Position;


public class mainInterface {

	private static Scanner move = new Scanner(System.in);
	private static char s;


	public static void main(String[] args) {



		GameState game = new GameState(numberOfOgres(),userChooseGuardType());		
		game.start_game();
		game.display();

		while(!game.over()) {

			System.out.println("Insert your play with wasd");
			s = move.next().charAt(0);

			if(s == 'a' ||s == 'w' || s == 's' ||s == 'd' ) {
				game.movement(s);
				game.display();
			}
		}
		
		if(game.hasWon()) {
			System.out.println("YOU WON!!!!!");
		}
		else
			System.out.println("YOU LOOSE!!");
	}


	public static String userChooseGuardType() {
		System.out.println("1 - Drunken\n2 - Rookie\n3 - Suspicious\nSelect the guard : ");
		int num = move.nextInt();
		while(num >= 4 && num <= 0) {
			System.out.println("Choose a available guard");
			num = move.nextInt();
		}

		switch(num) {
		case 1:
			return "Drunken";
		case 2:
			return "Rookie";
		case 3: 
			return "Suspicious";
		}

		return "Rookie";
	}

	public static int numberOfOgres()  {

		System.out.println("How many ogres do you want?");
		int num;
		do {
			num = move.nextInt();
			if (num >= 5 && num <= 0)
				System.out.println("Insert a number between 0 and 5\n");
		}while (num <= 0 && num >= 5);

		return num;
	}

}
