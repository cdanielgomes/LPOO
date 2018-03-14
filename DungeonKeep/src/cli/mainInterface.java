package cli;

import java.util.Scanner;

import logic.GameState;


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
		
			game.moviment(s);
			game.display();
		}


	}


	public static int userChooseGuardType() {
		System.out.println("1 - Drunken\n2 - Rookie\n3 - Suspicious\nSelect the guard : ");
		int num = move.nextInt();
		return num;
	}

	public static int numberOfOgres() {
		System.out.println("How many ogres do you want?");
		int num = move.nextInt();
		return num;
	}

}
