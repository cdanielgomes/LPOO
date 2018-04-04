package dkeep.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapEditor {

	private JFrame MapEditorframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapEditor window = new MapEditor();
					window.MapEditorframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MapEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MapEditorframe = new JFrame();
		MapEditorframe.setBounds(100, 100, 450, 300);
		MapEditorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MapEditorframe.getContentPane().setLayout(null);
		
		createOgreButton();
		createHeroButton();
		createFloorButton();
		createHeroClubButton();
		createWallButton();
		createKeyButton();
		createMenuButton();
		createSaveButton();
		createDoorButton();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		panel.setBounds(12, 60, 256, 214);
		MapEditorframe.getContentPane().add(panel);
	}
	
	public void createOgreButton() {
		JButton OgreButton = new JButton("");
		OgreButton.setBounds(394, 49, 28, 25);
		MapEditorframe.getContentPane().add(OgreButton);
		
	}

	public void createWallButton() {
		JButton WallButton = new JButton("");
		WallButton.setBounds(372, 160, 28, 25);
		MapEditorframe.getContentPane().add(WallButton);
		
	}
	public void createHeroClubButton() {
		JButton HeroClub = new JButton("");
		HeroClub.setBounds(394, 123, 28, 25);
		MapEditorframe.getContentPane().add(HeroClub);
	}
	public void createFloorButton() {
		JButton FloorButton = new JButton("");
		FloorButton.setBounds(348, 123,  28, 25);
		MapEditorframe.getContentPane().add(FloorButton);	
	}
	
	public void createHeroButton() {
		JButton Herobutton = new JButton("");
		Herobutton.setBounds(348, 49, 28, 25);
		MapEditorframe.getContentPane().add(Herobutton);
		
	}
	
	
	public void createKeyButton() {
		JButton KeyButton = new JButton("");
		KeyButton.setBounds(348, 86,  28, 25);
		MapEditorframe.getContentPane().add(KeyButton);
		
		
	}
	
	public void createDoorButton() {
		JButton DoorButton = new JButton("");
		DoorButton.setBounds(394, 86,  28, 25);
		MapEditorframe.getContentPane().add(DoorButton);
		
		
	}
	
	
	public JFrame getFrame() {
		return MapEditorframe;
	}
	
	
	public void createMenuButton(){

		JButton Menubutton = new JButton("MENU");
		Menubutton.setBounds(321, 12, 117, 25);
		Menubutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				System.out.println("1");
				GameWindow.mapE.getFrame().setVisible(false);
				GameWindow.frmDungeonKeep.setVisible(true);
				GameWindow.menuPanel.setVisible(true);
				
				
			}

		});

		MapEditorframe.getContentPane().add(Menubutton);

	}
	
	public void createSaveButton(){

		JButton SaveButton = new JButton("SAVE");
		SaveButton.setBounds(321, 197, 117, 25);
		SaveButton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				
				
			}

		});

		MapEditorframe.getContentPane().add(SaveButton);

	}

}
