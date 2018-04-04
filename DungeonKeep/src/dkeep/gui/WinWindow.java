package dkeep.gui; 


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 

public class WinWindow extends JPanel{


	public WinWindow(){

		super();
		setBackground(Color.DARK_GRAY);

		createMenuButton();
		createExitButton();
		 WinImageSet();



	}

	public void createMenuButton(){

		JButton Menubutton = new JButton("MENU");
		//add icon
		Menubutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				GameWindow.winPanel.setVisible(false);
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
	
	public void WinImageSet() {

		JPanel p = new JPanel();
		p.setBorder(null);
		p.setBackground(Color.DARK_GRAY);
		p.setBounds(20,40 ,300,300);
		add(p);
		JLabel label = new JLabel(new ImageIcon(WinWindow.class.getResource("/dkeep/gui/img/victory.png")));
		p.add(label);

	}





}