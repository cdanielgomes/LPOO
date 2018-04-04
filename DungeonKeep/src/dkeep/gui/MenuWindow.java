package dkeep.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import logic.GameState;

public class MenuWindow extends JPanel {

	private static final long serialVersionUID = 2261208719927717162L;
	
	static PlayAux play;
	private JFrame frmMazeGame = GameWindow.frmDungeonKeep;

	
	public MenuWindow() {

		super();
		setBackground(Color.BLACK);

		createNewGameButton();
		createExitButton();
		createMEButton();
		MenuImageSet();


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
			
			GameWindow.play.playPanel.requestFocusInWindow();
			
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

	public void createMEButton() {
		JButton EMbutton = new JButton("Edit Map");
		add(EMbutton);
	
	}

	public void MenuImageSet() {
		
		JPanel p = new JPanel();
		p.setBackground(Color.DARK_GRAY);
		p.setBounds(20,40 ,300,300);
		p.add(new JLabel(new ImageIcon(MenuWindow.class.getResource("/dkeep/gui/img/menu.jpg"))));
		add(p);
			
	}





}