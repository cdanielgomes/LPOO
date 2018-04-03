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
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PlayAux extends JPanel{

	static PlayWindow playPanel;
	

	public PlayAux(){

		setBackground(Color.BLUE);
		playPanel = new PlayWindow();
		playPanel.setBounds(0, 0,400, 300);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(playPanel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(playPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		playPanel.setLayout(new GridLayout(10,10));
		setLayout(groupLayout);
		//playPanel.paintMap(GameWindow.getGame().getMap().getmap());



	}
}