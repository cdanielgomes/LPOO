package dkeep.gui; 


import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoseWindow extends JPanel {


	public LoseWindow(){

		super();
		createMenuButton();
		createExitButton();
	}


	public void createMenuButton(){

		JButton Menubutton = new JButton("MENU");
		//add icon
		Menubutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				GameWindow.losePanel.setVisible(false);
				GameWindow.menuPanel.setVisible(true);
			}

		});

		add(Menubutton);

	}

	public void createExitButton(){

		JButton Exitbutton = new JButton("EXIT");
		//add icon
		Exitbutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		add(Exitbutton);
	}




}