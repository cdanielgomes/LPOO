package dkeep.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class EditMap extends MapRend implements MouseListener{
	
	JFrame edit ;
	
	public EditMap() {
		edit = new JFrame();
		edit.getContentPane().setLayout(null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(321, 12, 117, 25);
		edit.getContentPane().add(btnMenu);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(321, 197, 117, 25);
		edit.getContentPane().add(btnSave);
		
		createOgreButton();
		createHeroButton();
		createFloorButton();
		createHeroClubButton();
		createWallButton();
		createKeyButton();
		
		
		JButton DoorButton = new JButton("");
		DoorButton.setBounds(394, 86,  28, 25);
		edit.getContentPane().add(DoorButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		panel.setBounds(12, 12, 256, 214);
		edit.getContentPane().add(panel);
		
	}
	
	public void createOgreButton() {
		JButton OgreButton = new JButton("");
		OgreButton.setBounds(394, 49, 28, 25);
		edit.getContentPane().add(OgreButton);
		
	}

	public void createWallButton() {
		JButton WallButton = new JButton("");
		WallButton.setBounds(372, 160, 28, 25);
		edit.getContentPane().add(WallButton);
		
	}
	public void createHeroClubButton() {
		JButton HeroClub = new JButton("");
		HeroClub.setBounds(394, 123, 28, 25);
		edit.getContentPane().add(HeroClub);
	}
	public void createFloorButton() {
		JButton FloorButton = new JButton("");
		FloorButton.setBounds(348, 123,  28, 25);
		edit.getContentPane().add(FloorButton);	
	}
	
	public void createHeroButton() {
		JButton Herobutton = new JButton("");
		Herobutton.setBounds(348, 49, 28, 25);
		edit.getContentPane().add(Herobutton);
		
	}
	
	
	public void createKeyButton() {
		JButton KeyButton = new JButton("");
		KeyButton.setBounds(348, 86,  28, 25);
		edit.getContentPane().add(KeyButton);
		
		
	}
	
	private static final long serialVersionUID = -8242357140526138514L;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		e.getY();
		e.getX();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
