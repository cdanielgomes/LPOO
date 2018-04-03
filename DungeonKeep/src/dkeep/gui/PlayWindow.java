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

public class PlayWindow extends MapRend implements KeyListener{
	
	

	public PlayWindow(){
		super();
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(10,10));
		this.setSize(400, 400);
		this.setVisible(true);
		
		getImages();
		addKeyListener(this);
		//paintMap(map);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
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
		requestFocus();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}  
  


}