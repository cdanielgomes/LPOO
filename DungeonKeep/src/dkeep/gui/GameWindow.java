package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import logic.GameState;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GameWindow {

	private JFrame frmDungeonKeep;
	private JTextField textField;
	private GameState game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		
		textField = new JTextField();
		textField.setBounds(170, 2, 50, 19);
		frmDungeonKeep.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Number of ogres");
		lblNewLabel.setBounds(10, 2, 120, 15);
		frmDungeonKeep.getContentPane().add(lblNewLabel);
		String nOgres = textField.getText(); 
		
		JLabel lblGuardPersonality = new JLabel("Guard Personality");
		lblGuardPersonality.setBounds(10, 30, 130, 15);
		frmDungeonKeep.getContentPane().add(lblGuardPersonality);; 
		
		JComboBox guardSelec = new JComboBox();
		guardSelec.setModel(new DefaultComboBoxModel(new String[] {"Suspicious", "Drunken", "Rookie"}));
		guardSelec.setBounds(170, 33, 120, 20);
		frmDungeonKeep.getContentPane().add(guardSelec);
		String guardPersonality = guardSelec.getActionCommand();
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new GameState(Integer.parseInt(nOgres),guardPersonality);
				game.start_game();
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
		btnUp.setBounds(356, 103, 60, 20);
		frmDungeonKeep.getContentPane().add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeft.setBounds(298, 135, 70, 20);
		frmDungeonKeep.getContentPane().add(btnLeft);
		
		JButton btnRigth = new JButton("Rigth");
		btnRigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRigth.setBounds(398, 135, 80, 20);
		frmDungeonKeep.getContentPane().add(btnRigth);
		
		JButton btnDown = new JButton("Down");
		btnDown.setBounds(353, 167, 80, 20);
		frmDungeonKeep.getContentPane().add(btnDown);
		
		JTextArea board = new JTextArea();
		board.setEditable(false);
		board.setBounds(11, 62, 281, 285);
		frmDungeonKeep.getContentPane().add(board);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(12, 373, 210, 15);
		frmDungeonKeep.getContentPane().add(lblNewLabel_1);
	}
}
