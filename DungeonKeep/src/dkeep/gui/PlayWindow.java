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

public class PlayWindow extends MapRend {
	
	

	public PlayWindow(){
		super();
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(defaultMapLength,defaultMapLength));
		this.setSize(400, 400);
		this.setVisible(true);
		
		getImages();
		//paintMap(map);
	}  
  


}