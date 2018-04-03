package dkeep.gui;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import logic.GameState;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


public class MenuWindow extends JPanel {

	static PlayAux play;
	private JFrame frmMazeGame = GameWindow.frmDungeonKeep;

	
	public MenuWindow() {

		super();
		setBackground(Color.BLACK);

		createNewGameButton();
		createExitButton();
		
		//MenuImageSet();


	}

	public void createNewGameButton(){

		JButton NGbutton = new JButton("new game");
      	NGbutton.setBackground(Color.WHITE);
	    NGbutton.setHorizontalAlignment(SwingConstants.LEADING);
					// add icon
		NGbutton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
			String Guard;
			String nogres;


			String[] guardTypes = { "Rookie", "Drunken", "Suspicious" };

			String[] Onumber = { "1", "2", "3", "4", "5" };

			Guard = (String) JOptionPane.showInputDialog(frmMazeGame, "             Guard's Personality",
					"", JOptionPane.PLAIN_MESSAGE, null, guardTypes, "Rookie");

			nogres = (String) JOptionPane.showInputDialog(frmMazeGame,
					"             Number of Ogres", "", JOptionPane.PLAIN_MESSAGE, null, Onumber, "1");
			
			if(Guard== null || 	nogres== null)
				return;
	
			GameWindow.createGame(new GameState(Integer.parseInt(nogres),Guard));
			GameWindow.startTheGame();
			
			
			GameWindow.menuPanel.setVisible(false);


			
			GameWindow.play.setVisible(true);
			GameWindow.play.playPanel.paintMap(GameWindow.getGame().getMap().getmap());
			
			} 

		}); 

		add(NGbutton);
	}

	public void createExitButton(){
										
		
												
												
		JButton Exitbutton = new JButton("exit");
		Exitbutton.setBackground(Color.WHITE);
		//add icon
		Exitbutton.addActionListener(new ActionListener (){
    	public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		});
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(Exitbutton);
		
		
	}


	public void MenuImageSet() {
		
		JPanel p = new JPanel();
		p.setBackground(Color.DARK_GRAY);
		p.setBounds(20,40 ,300,300);
		ImageIcon i = new ImageIcon(this.getClass().getResource("img/menu.png"));
		p.add(new JLabel(i));
		add(p);
		
		
		
	}








}