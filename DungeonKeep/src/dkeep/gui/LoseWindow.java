package dkeep.gui; 


import java.awt.Color;
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

		setBackground(Color.DARK_GRAY);
		createMenuButton();
		createExitButton();

		LooseImageSet();
		
		
	}


	public void createMenuButton(){

		JButton Menubutton = new JButton("MENU");
		//add icon
		Menubutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				GameWindow.losePanel.setVisible(false);
				GameWindow.menuPanel.setVisible(true);
				GameWindow.getGame().display();
				
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

	public void LooseImageSet() {
		JLabel label = new JLabel(new ImageIcon(WinWindow.class.getResource("/dkeep/gui/img/defeat1.jpg")));
		add(label);

		JPanel p = new JPanel();
		p.setBorder(null);
		p.setBackground(Color.DARK_GRAY);
		p.setBounds(0,40 ,300,300);
		add(p);

	}



}