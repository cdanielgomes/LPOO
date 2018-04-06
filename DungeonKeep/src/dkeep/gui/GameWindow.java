package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import logic.GameState;
import logic.Keep;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
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
	static boolean costum = false; 
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
		if(game.getMap() instanceof Keep) {
			char[][] a = game.getMap().getmap();
 			play.playPanel.setLayout(new GridLayout(a.length, a.length));
		}
		else {
			char[][] a = game.getMap().getmap();
 			play.playPanel.setLayout(new GridLayout(a.length, a.length));
	
		}
		if(game.getMap().endOfGame()){
			play.setVisible(false);
			losePanel.setVisible(true);
		}
		else if (GameWindow.game.hasWon()) {
			play.setVisible(false);
			winPanel.setVisible(true);
		} 
	}

}

