package dkeep.gui;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
public class PlayAux extends JPanel{
	
	
	private static final long serialVersionUID = -5017522783333197713L;
	
	public PlayWindow playPanel;
	private JPanel Epanel;
	private JPanel Npanel;
	
	public PlayAux(){

		
		setLayout(new BorderLayout(0, 0));
	
		//char[][] l = GameWindow.getGame().getMap().getmap();
		
		playPanel = new PlayWindow();
		add(playPanel, BorderLayout.CENTER);
		
		Epanel = new JPanel();
		Epanel.setAutoscrolls(true);
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
		

	}

	public void createUpButton(JPanel p){
		JButton button = new JButton("");
		button.setAutoscrolls(true);
		button.setBorderPainted(false);
		
		button.setBackground(SystemColor.inactiveCaption);
		button.setBounds(200,200,50,50);

		button.setIcon(new ImageIcon(MenuWindow.class.getResource("/dkeep/gui/img/arrowup.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.update('w');
				GameWindow.play.playPanel.requestFocusInWindow();

			}
		});
		
		p.add(button , BorderLayout.NORTH);


	}

	public void createRightButton(JPanel p){

		JButton button = new JButton("");
		button.setBorderPainted(false);
		button.setBackground(SystemColor.inactiveCaption);

		button.setIcon(new ImageIcon(MenuWindow.class.getResource("/dkeep/gui/img/arrowr.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.update('d');
				GameWindow.play.playPanel.requestFocusInWindow();


			}
		});
		p.add(button, BorderLayout.EAST);


	}

	public void createLeftButton(JPanel p){

		JButton button = new JButton();
		button.setBackground(SystemColor.inactiveCaption);
		button.setBorderPainted(false);

		button.setIcon(new ImageIcon(MenuWindow.class.getResource("/dkeep/gui/img/arrowl.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.update('a');
				GameWindow.play.playPanel.requestFocusInWindow();


			}
		});
		p.add(button, BorderLayout.WEST);


	}

	public void createDownButton(JPanel p){

		JButton button = new JButton();
		button.setBackground(SystemColor.inactiveCaption);
		button.setBorderPainted(false);

		button.setIcon(new ImageIcon(MenuWindow.class.getResource("/dkeep/gui/img/arrowd.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow.update('s');
				GameWindow.play.playPanel.requestFocusInWindow();


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

}