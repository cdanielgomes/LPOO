package dkeep.gui;

import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;

public class Mapping extends MapRend {

	private static final long serialVersionUID = 7637590126641479471L;
	private char[][] mapEditing;
	private int x ,y;
	public Mapping(int x, int y) {
		super(x,y);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(x,y));
		this.setSize(400, 400);
		this.setVisible(true);
		//getImages();
	}
	
	public void initialMap() {
		
		char[][] p = new char[y][x];
		for(int i = 0; i < x; i++) {
			for(int k = 0; k < y; k++)
				p[k][i] = ' ';
		}
		mapEditing = p;
	}

	
	void setPositions(int x, int y, char l) {	
		if(checkInsertion()) mapEditing[y][x] = l;
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

	
}
