package dkeep.gui;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	
	public MenuWindow() {

		super();
		setBackground(Color.BLACK);

		createNewGameButton();
		createExitButton();



	}

	public void createNewGameButton(){

		JButton NGbutton = new JButton("new game");
      	NGbutton.setBackground(Color.WHITE);
	    NGbutton.setHorizontalAlignment(SwingConstants.LEADING);
					// add icon
		NGbutton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			/*JTextField textField = new JTextField();
			textField.setFont(new Font("Courier", Font.PLAIN, 12));
			textField.setBounds(170, 2, 50, 19);
			add(textField);
			textField.setColumns(10);

            JLabel lblNewLabel = new JLabel("Number of ogres");
			lblNewLabel.setBounds(10, 2, 120, 15);
		    add(lblNewLabel);

		    JLabel lblGuardPersonality = new JLabel("Guard Personality");
			lblGuardPersonality.setBounds(10, 30, 130, 15);
			add(lblGuardPersonality);

		    JComboBox<String> guardSelec = new JComboBox<String>();
			guardSelec.setModel(new DefaultComboBoxModel<String>(new String[] {"Suspicious", "Drunken", "Rookie"}));
			guardSelec.setBounds(170, 33, 120, 20);
			add(guardSelec);

	 		String guardPersonality = guardSelec.getSelectedItem().toString();
		    int nogres = Integer.parseInt(textField.getText());

			if ( nogres < 1 || nogres > 5	|| guardPersonality == null){
				return;
			}
	*/ 
			GameWindow.createGame(new GameState(1,"Rookie"));
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











}