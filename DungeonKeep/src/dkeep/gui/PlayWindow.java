package dkeep.gui;


import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PlayWindow extends MapRend implements KeyListener{

	private static final long serialVersionUID = 6659466331228348653L;

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
			GameWindow.update('w');
			break;
		case KeyEvent.VK_DOWN:
			GameWindow.update('s');
			break;
		case KeyEvent.VK_RIGHT: 
			GameWindow.update('d');
			break;
		case KeyEvent.VK_LEFT: 
			GameWindow.update('a');
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