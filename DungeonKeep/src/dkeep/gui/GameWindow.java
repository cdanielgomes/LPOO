package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import logic.GameState;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridLayout;


public class GameWindow {

	static JFrame frmDungeonKeep;
	static MenuWindow menuPanel;
	static WinWindow winPanel;
	static PlayWindow playPanel;
	static PlayAux play;
	static LoseWindow losePanel;
	static MapEditor mapE;

	private static GameState game;

	static JLayeredPane MultiplePane;


	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public  void run() {
				try {
					GameWindow window = new GameWindow();
					window.frmDungeonKeep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() { 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmDungeonKeep = new JFrame();
		frmDungeonKeep.setTitle("Dungeon Keep");
		frmDungeonKeep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDungeonKeep.setAlwaysOnTop(true);
		frmDungeonKeep.setAutoRequestFocus(false);
		frmDungeonKeep.setResizable(false);
		frmDungeonKeep.setBounds(100, 100, 490, 450);
		frmDungeonKeep.getContentPane().setLayout(null);



		MultiplePane = new JLayeredPane();
		MultiplePane.setBounds(0 , -11 , 488 , 424);
		frmDungeonKeep.getContentPane().add(MultiplePane);
		MultiplePane.setLayout(null);

		menuPanel = new MenuWindow();
		menuPanel.setBounds(0, 12, 488, 412);
		MultiplePane.add(menuPanel);

		mapE = new MapEditor();

		winPanel = new WinWindow();
		winPanel.setBounds(0, 12, 488, 412);
		winPanel.setVisible(false);
		MultiplePane.add(winPanel);

		losePanel = new LoseWindow();
		losePanel.setBounds(0, 12, 488, 412);
		losePanel.setVisible(false);
		MultiplePane.add(losePanel);

		play = new PlayAux();
		play.setBounds(0, 12, 488, 412);
		play.setVisible(false);
		MultiplePane.add(play);

		//mapa.setBackground(Color.BLACK);

	}

	public static void SaveGame() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream("CostumMap.txt");

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(game);
			oos.close();
			fos.close();
		}catch(IOException e){

		}
	}

	public static void LoadGame() {
		try{

			FileInputStream fis = new FileInputStream("CustomMap.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			GameState game = (GameState) ois.readObject();
			ois.close();
			fis.close();

		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void createGame(GameState g){
		game = g;
	}

	public static void startTheGame() {
		game.start_game();
	}

	public static GameState getGame(){
		return game;
	}


	public static void  update(char move) {

		game.movement(move);
		play.playPanel.repaintMap(game.getMap().getmap());
		if(game.getMap().endOfGame()){
			play.setVisible(false);
			losePanel.setVisible(true);
		}
		else if (GameWindow.game.hasWon()) {
			play.setVisible(false);
			winPanel.setVisible(true);
		} 
	}

	public static void setGame(GameState m) {
		game = m;
	}
}

