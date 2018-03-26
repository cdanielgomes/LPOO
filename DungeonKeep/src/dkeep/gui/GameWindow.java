package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow {

	private JFrame frmDungeonKeep;
	private JTextField textField;

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
		frmDungeonKeep.setBounds(100, 100, 450, 300);
		frmDungeonKeep.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(170, 2, 50, 19);
		frmDungeonKeep.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Number of ogres");
		lblNewLabel.setBounds(10, 2, 120, 15);
		frmDungeonKeep.getContentPane().add(lblNewLabel);
		
		JLabel lblGuardPersonality = new JLabel("Guard Personality");
		lblGuardPersonality.setBounds(10, 30, 130, 15);
		frmDungeonKeep.getContentPane().add(lblGuardPersonality);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 33, 100, 17);
		frmDungeonKeep.getContentPane().add(comboBox);
		
		JButton btnNewGomes = new JButton("New Game");
		btnNewGomes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewGomes.setBounds(301, 44, 115, 20);
		frmDungeonKeep.getContentPane().add(btnNewGomes);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setBounds(316, 233, 100, 20);
		frmDungeonKeep.getContentPane().add(btnExit);
		
		JTextArea textStatus = new JTextArea();
		textStatus.setEditable(false);
		textStatus.setBounds(22, 236, 200, 15);
		frmDungeonKeep.getContentPane().add(textStatus);
		
		JButton btnUp = new JButton("Up");
		btnUp.setBounds(311, 88, 60, 20);
		frmDungeonKeep.getContentPane().add(btnUp);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setBounds(261, 119, 70, 20);
		frmDungeonKeep.getContentPane().add(btnLeft);
		
		JButton btnRigth = new JButton("Rigth");
		btnRigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRigth.setBounds(350, 119, 80, 20);
		frmDungeonKeep.getContentPane().add(btnRigth);
		
		JButton btnDown = new JButton("Down");
		btnDown.setBounds(306, 151, 80, 20);
		frmDungeonKeep.getContentPane().add(btnDown);
	}
}
