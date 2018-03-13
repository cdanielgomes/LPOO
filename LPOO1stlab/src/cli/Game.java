package cli;
import java.util.Scanner;

import logic.GameState;

public class Game {
	private static Scanner move = new Scanner(System.in);
	private static char s;


	public static void main(String[] args) {

		
		
		GameState game = new GameState();		
		
		game.chooseGuard(userChooseGuardType());
		
		do {
			game.setEnemies();
			game.display();
			while(game.getGameEnd() != 1 && game.getGameWon() == 0 && game.getGameOver() == 0) {
				System.out.print("Direction : ");
				s = move.next().charAt(0);
				game.updateGame(s);
				game.display();

				if (game.getNextLevel() == 1) {
					game.setNextLevel(0);
					break;
				}





			}


		}while(game.getGameEnd() != 1 && game.getGameWon() == 0 && game.getGameOver() == 0);

		move.close();
	}

	public static int userChooseGuardType() {
		System.out.println("1 - Drunken\n2 - Rookie\n3 - Suspicious\nSelect the guard : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if (num > 3 || num < 1) {
			return userChooseGuardType();
		}
		return num;
	}

	/*public void setNewMaps() {
		Scanner lb = new Scanner(System.in);
		System.out.println("Quantos mapas quer inserir?");
		int niveis = lb.nextInt();

		System.out.println("Legenda: \n X -> Wall \n O->Ogre \n G -> Guard \n H -> Hero \n I -> exit");

		for(int i = 0; i < niveis; i++) {

			System.out.println("Insira a largura e o comprimento do Labirinto");

			int largura = lb.nextInt();
			int comprimento = lb.nextInt();
			char[][] map;
			int l = 0;
			while(largura*comprimento > l) {
				System.out.println("Insert line by line");

			}

		}


	}
	 */


}
