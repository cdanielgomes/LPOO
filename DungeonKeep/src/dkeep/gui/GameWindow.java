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


		
		
		
		/*playPanel = new PlayWindow(game.getMap().getmap());
		playPanel.setBounds(0, 0, 488, 424);
		MultiplePane.add(playPanel);
		playPanel.setVisible(true);
		playPanel.getImages(game.getMap().getmap());
		playPanel.paintMap(game.getMap().getmap());
		*/
	
		play = new PlayAux();
		play.setBounds(0, 12, 488, 412);
		play.setVisible(false);
		MultiplePane.add(play);
 		
		
		

		
				
		//mapa.setBackground(Color.BLACK);
		/*
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nOgres = textField.getText(); 
				String guardPersonality = guardSelec.getSelectedItem().toString();
				int nogres = Integer.parseInt(nOgres);
				if (nogres <= 5 && nogres >= 0){
				game = new GameState(nogres,guardPersonality);
				game.start_game();
				mapa.setBorder(new EmptyBorder(5, 5, 5, 5));
				mapa.setLayout(new GridLayout(game.getMap().getmap().length, game.getMap().getmap()[0].length));
				mapa.setBackground(java.awt.Color.BLACK);
				mapa.setVisible(true);
				mapa.getImages(game.getMap().getmap());
				mapa.paintMap(game.getMap().getmap());
				lblgameover.setVisible(false);
				
				}  
				else {
					//board.setVisible(false);
				}
			}
		});

		btnNewGame.setBounds(333, 44, 115, 20);
		frmDungeonKeep.getContentPane().add(btnNewGame);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(347, 233, 100, 20);
		frmDungeonKeep.getContentPane().add(btnExit);

		

		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.movement('w');
				mapa.repaintMap(game.getMap().getmap());  
				if(game.getMap().endOfGame()){
					//board.setText(game.getMap().tostring());
					//board.setVisible(false);
					lblgameover.setVisible(true);
				}
				else{
					//board.replaceSelection(game.getMap().tostring());
					//board.setText(game.getMap().tostring());
				}

			}
		});
 
		btnUp.setBounds(356, 103, 60, 20);
		frmDungeonKeep.getContentPane().add(btnUp);

		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.movement('a');
				mapa.repaintMap(game.getMap().getmap());
				if(game.getMap().endOfGame()){
					//board.setText(game.getMap().tostring());
					//board.setVisible(false);
					lblgameover.setVisible(true);
				}
				else{
					//board.replaceSelection(game.getMap().tostring());
					//board.setText(game.getMap().tostring());
				}
			}
		});

		btnLeft.setBounds(298, 135, 70, 20);
		frmDungeonKeep.getContentPane().add(btnLeft);

		JButton btnRigth = new JButton("Rigth");
		btnRigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.movement('d');
				mapa.repaintMap(game.getMap().getmap());
				if(game.getMap().endOfGame()){
					//board.setText(game.getMap().tostring());
					//board.setVisible(false);	
					lblgameover.setVisible(true);
				}
				else{
					//board.replaceSelection(game.getMap().tostring());
					//board.setText(game.getMap().tostring());
				}
			}
		});
		
		btnRigth.setBounds(398, 135, 80, 20);
		frmDungeonKeep.getContentPane().add(btnRigth);

		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.movement('s');
				mapa.repaintMap(game.getMap().getmap());
				if(game.getMap().endOfGame()){
					//board.setText(game.getMap().tostring());
					//board.setVisible(false);	
					lblgameover.setVisible(true);
				}
				else{
					//board.replaceSelection(game.getMap().tostring());
					//board.setText(game.getMap().tostring());
				}
			}
		});
		
		btnDown.setBounds(353, 167, 80, 20);
		frmDungeonKeep.getContentPane().add(btnDown);
	}
	*/
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

}

