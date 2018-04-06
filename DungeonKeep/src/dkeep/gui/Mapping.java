package dkeep.gui;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

import logic.Door;
import logic.Position;

public class Mapping extends MapRend  implements MouseListener{

	private static final long serialVersionUID = 7637590126641479471L;
	private char[][] mapEditing;
	private char k = 'X';
	private ArrayList<Door> doors = new ArrayList<Door>();
	public Mapping(int x, int y) {
		super(x,y);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(x,y));
		this.setSize(360, 360);
		getImages();
		initialMap();

		addMouseListener(this);
	}
	
	public Mapping() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(java.awt.Color.BLACK);
		this.setSize(360, 360);
		addMouseListener(this);
	}

	public void initialMap() {

		char[][] p = new char[defaultMapHeight][defaultMapWidth];
		for(int i = 0; i < defaultMapHeight; i++) {
			for(int k = 0; k < defaultMapWidth; k++)
				if(i == 0 || i == defaultMapHeight - 1 || k == 0|| k == defaultMapWidth-1)
					p[i][k] = 'X';
				else 
					p[i][k] = ' ';
		}
		this.mapEditing = p;

		paintMap(mapEditing);
	}


	
	
	void setPositions(int x, int y, char l) {	
		if((y == 0 || y == defaultMapHeight - 1 || x== 0|| x == defaultMapWidth-1)) {
			if(l == 'X' || l=='I') {
					mapEditing[y][x] = l;

			}

			else return ;
		}
		if (l == 'H' && searchHero()) return; 
		if (l == 'O' && searchOgre()) return; 
		if (l == 'k' && searchKey()) return; 
		if (l == '*' && searchHeroClub()) return;

		mapEditing[y][x] = l;		
	}

	public boolean searchHero() {
		return findPers('H') == 1;
	}
	public boolean searchOgre() {
		return findPers('O') == 1;
	}

	public boolean searchKey() {
		return findPers('k') == 1;
	}
	
	public boolean searchHeroClub() {
		return findPers('*') == 1;
	}
	public boolean searchDoor() {
		return findPers('I') == 1;
	}
	public int findPers(char par){
		int z = 0;
		for(int i = 0; i < mapEditing.length; i++) {
			for(int k = 0; k < mapEditing[i].length; k++)
				if(mapEditing[i][k] == par) z++; 
		}
	
		return z ;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int mouseX = (int) Math.floor((e.getX()/(this.getWidth() / defaultMapWidth)));//temos de retirar do text 
		int mouseY = (int) Math.floor((e.getY()/(this.getHeight()/defaultMapHeight)));// temos de retirar do text
		if(mouseX >= defaultMapWidth) return;
		if(mouseY >= defaultMapHeight) return ;
		this.setPositions(mouseX,mouseY, this.k);
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

	public char[][] getMapEditing(){
		return mapEditing;
	}

	public ArrayList<Door> getDoors() {
		return doors;
	}
}
