package dkeep.gui;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.EmptyBorder;

public class Mapping extends MapRend  implements MouseListener{

	private static final long serialVersionUID = 7637590126641479471L;
	private char[][] mapEditing;
	private char k = ' ';
	public Mapping(int x, int y) {
		super(x,y);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(java.awt.Color.BLACK);
		this.setSize(400, 400);
		getImages();
		initialMap();
	
		addMouseListener(this);
	}
	
	public void initialMap() {
		
		char[][] p = new char[defaultMapHeight][defaultMapWidth];
		for(int i = 0; i < defaultMapWidth; i++) {
			for(int k = 0; k < defaultMapHeight; k++)
				p[k][i] = 'X';
		}
		mapEditing = p;
		
	}

	
	void setPositions(int x, int y, char l) {	
		//if(checkInsertion()) 
			mapEditing[y][x] = l;
	}
	
	public boolean checkInsertion() {
		if(findPers('O')) return false ;
		if(findPers('H'))return false;
		if(findPers('k')) return false;
		if(findPers('I')) return false;
		return true;
	}

	public boolean findPers(char par){
		int z = 0;
		for(int i = 0; i < mapEditing.length; i++) {
			for(int k = 0; k < mapEditing[i].length; k++)
				if(mapEditing[i][k] == par) z++; 
		}
		
		if('I' != par)return z == 1;
		else return z==0;
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	int mouseX = (int) Math.floor((e.getX()-100)/(this.getWidth()/defaultMapWidth));//temos de retirar do text 
	int mouseY = (int) Math.floor((e.getY()-100)/(this.getHeight()/defaultMapHeight));// temos de retirar do text
		this.setPositions(mouseY,mouseX, this.k);
		
	repaintMap(mapEditing);

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
	
	public void setChar(char k) {
		this.k = k;
	}
}
