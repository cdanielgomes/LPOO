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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PlayAux extends JPanel implements KeyListener{
	
	public PlayWindow playPanel;
	private JPanel Epanel;
	private JPanel Npanel;
	
	public PlayAux(){

		
		setLayout(new BorderLayout(0, 0));
		
		playPanel = new PlayWindow();
		add(playPanel, BorderLayout.CENTER);
		
		Epanel = new JPanel();
		Epanel.setInheritsPopupMenu(true);
		add(Epanel, BorderLayout.EAST);
		Epanel.setLayout(new BorderLayout(0,0));
		
		Npanel = new JPanel();
		Npanel.setBackground(Color.GRAY);
		Npanel.setInheritsPopupMenu(true);
		add(Npanel , BorderLayout.NORTH);

		createUpButton(Epanel);
		createRightButton(Epanel);
		createLeftButton(Epanel);
		createDownButton(Epanel);

		createMenuButton(Npanel);
		createExitButton(Npanel);
		
		addKeyListener(this);


	}

	public void createUpButton(JPanel p){

		JButton button = new JButton("UP");
		button.setBounds(200,200,50,50);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.getGame().movement('w');
				GameWindow.play.playPanel.repaintMap(GameWindow.getGame().getMap().getmap());  
				if(GameWindow.getGame().getMap().endOfGame()){
					GameWindow.play.setVisible(false);
					GameWindow.losePanel.setVisible(true);
				}
				else if (GameWindow.getGame().hasWon()) {
					GameWindow.play.setVisible(false);
					GameWindow.winPanel.setVisible(true);
				}
				else{
					//
				}

			}
		});
		
		p.add(button , BorderLayout.NORTH);


	}

	public void createRightButton(JPanel p){

		JButton button = new JButton("RIGHT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.getGame().movement('d');
				GameWindow.play.playPanel.repaintMap(GameWindow.getGame().getMap().getmap());  
				if(GameWindow.getGame().getMap().endOfGame()){
					GameWindow.play.setVisible(false);
					GameWindow.losePanel.setVisible(true);
				}
				else if (GameWindow.getGame().hasWon()) {
					GameWindow.play.setVisible(false);
					GameWindow.winPanel.setVisible(true);
				}
				else{
					//
				}

			}
		});
		p.add(button, BorderLayout.EAST);


	}

	public void createLeftButton(JPanel p){

		JButton button = new JButton("LEFT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.getGame().movement('a');
				GameWindow.play.playPanel.repaintMap(GameWindow.getGame().getMap().getmap());  
				if(GameWindow.getGame().getMap().endOfGame()){
					GameWindow.play.setVisible(false);
					GameWindow.losePanel.setVisible(true);
				}
				else if (GameWindow.getGame().hasWon()) {
					GameWindow.play.setVisible(false);
					GameWindow.winPanel.setVisible(true);
				}
				else{
					//
				}

			}
		});
		p.add(button, BorderLayout.WEST);


	}

	public void createDownButton(JPanel p){

		JButton button = new JButton("DOWN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.getGame().movement('s');
				GameWindow.play.playPanel.repaintMap(GameWindow.getGame().getMap().getmap());  
				if(GameWindow.getGame().getMap().endOfGame()){
					GameWindow.play.setVisible(false);
					GameWindow.losePanel.setVisible(true);
				}
				else if (GameWindow.getGame().hasWon()) {
					GameWindow.play.setVisible(false);
					GameWindow.winPanel.setVisible(true);
				}
				else{
					//
				}

			}
		});
		p.add(button, BorderLayout.SOUTH);


	}

	public void createMenuButton(JPanel p){

		JButton Menubutton = new JButton("MENU");
		//add icon
		Menubutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				GameWindow.play.setVisible(false);
				GameWindow.menuPanel.setVisible(true);
			}

		});

		p.add(Menubutton);

	}

	public void createExitButton(JPanel p){

		JButton Exitbutton = new JButton("EXIT");
		//add icon
		Exitbutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		p.add(Exitbutton);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		switch(arg0.getKeyCode()){
		case KeyEvent.VK_UP: 
			GameWindow.getGame().movement('w');
			GameWindow.play.playPanel.repaintMap(GameWindow.getGame().getMap().getmap());  
			if(GameWindow.getGame().getMap().endOfGame()){
				GameWindow.play.setVisible(false);
				GameWindow.losePanel.setVisible(true);
			}
			else if (GameWindow.getGame().hasWon()) {
				GameWindow.play.setVisible(false);
				GameWindow.winPanel.setVisible(true);
			} 
			break;
		case KeyEvent.VK_DOWN:
			GameWindow.getGame().movement('s');
			GameWindow.play.playPanel.repaintMap(GameWindow.getGame().getMap().getmap());  
			if(GameWindow.getGame().getMap().endOfGame()){
				GameWindow.play.setVisible(false);
				GameWindow.losePanel.setVisible(true);
			}
			else if (GameWindow.getGame().hasWon()) {
				GameWindow.play.setVisible(false);
				GameWindow.winPanel.setVisible(true);
			} 
			break;
		case KeyEvent.VK_RIGHT: 
			GameWindow.getGame().movement('d');
			GameWindow.play.playPanel.repaintMap(GameWindow.getGame().getMap().getmap());  
			if(GameWindow.getGame().getMap().endOfGame()){
				GameWindow.play.setVisible(false);
				GameWindow.losePanel.setVisible(true);
			}
			else if (GameWindow.getGame().hasWon()) {
				GameWindow.play.setVisible(false);
				GameWindow.winPanel.setVisible(true);
			}
			break;
		case KeyEvent.VK_LEFT: 
			GameWindow.getGame().movement('a');
			GameWindow.play.playPanel.repaintMap(GameWindow.getGame().getMap().getmap());  
			if(GameWindow.getGame().getMap().endOfGame()){
				GameWindow.play.setVisible(false);
				GameWindow.losePanel.setVisible(true);
			}
			else if (GameWindow.getGame().hasWon()) {
				GameWindow.play.setVisible(false);
				GameWindow.winPanel.setVisible(true);
			} 
			break;
		 }

		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}